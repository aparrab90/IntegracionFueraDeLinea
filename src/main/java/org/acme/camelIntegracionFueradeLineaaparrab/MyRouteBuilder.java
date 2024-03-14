package org.acme.camelIntegracionFueradeLineaaparrab;
import org.apache.camel.builder.RouteBuilder;
import java.util.concurrent.atomic.AtomicInteger;
import javax.sql.DataSource;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.AppDataSource;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.ClientCreditValidationProcessor;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.RecordValidationException;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.ClientCreditProfile;


public class MyRouteBuilder extends RouteBuilder {

    // Contadores para registros exitosos y fallidos
    private final AtomicInteger successfulRecords = new AtomicInteger(0);
    private final AtomicInteger failedRecords = new AtomicInteger(0);
    private final AtomicInteger recordCounter = new AtomicInteger(0);

    @Override
    public void configure() {

        // Registrar el DataSource creado por DataSourceConfig
        DataSource dataSource = AppDataSource.createDataSource();
        getContext().getRegistry().bind("myDataSource", dataSource);
        
        recordCounter.set(0); // Reiniciar contador de registros

        // Manejo de excepciones general para errores de validación
        onException(RecordValidationException.class)
            .process(exchange -> {
                failedRecords.incrementAndGet(); // Incrementar contador de fallidos
                Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                exchange.getIn().setBody("Error de validacion: " + exception.getMessage());
            })
            .log("${body}")
            .handled(true);

        BindyCsvDataFormat bindyFormat = new BindyCsvDataFormat(ClientCreditProfile.class);

        //from("sftp://localhost:22/upload?username=foo&password=pass&noop=true")
        from("sftp://sftp:22/upload?username=foo&password=pass&noop=true")
        //from("sftp://localhost:22/upload?username=foo&password=pass&useUserKnownHostsFile=false&strictHostKeyChecking=no")
            .routeId("read-csv-file-route")
            .unmarshal(bindyFormat)
            .split(body()).streaming()
                .process(new ClientCreditValidationProcessor(successfulRecords, recordCounter))
                .process(exchange -> {
                    ClientCreditProfile payment = exchange.getIn().getBody(ClientCreditProfile.class);
                    String insertSQL = String.format(
                        "INSERT INTO customer_payments " +
                        "(id, limit_bal, sex, education, marriage, age, " +
                        "pay0, pay2, pay3, pay4, pay5, pay6, " +
                        "bill_amt1, bill_amt2, bill_amt3, bill_amt4, bill_amt5, bill_amt6, " +
                        "pay_amt1, pay_amt2, pay_amt3, pay_amt4, pay_amt5, pay_amt6, " +
                        "default_payment_next_month) VALUES " +
                        "(%d, %f, %d, %d, %d, %d, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %d)",
                        payment.getId().intValue(),
                        payment.getLimitBal().doubleValue(),
                        payment.getSex().intValue(),
                        payment.getEducation().intValue(),
                        payment.getMarriage().intValue(),
                        payment.getAge().intValue(),
                        payment.getPay0().doubleValue(),
                        payment.getPay2().doubleValue(),
                        payment.getPay3().doubleValue(),
                        payment.getPay4().doubleValue(),
                        payment.getPay5().doubleValue(),
                        payment.getPay6().doubleValue(),
                        payment.getBillAmt1().doubleValue(),
                        payment.getBillAmt2().doubleValue(),
                        payment.getBillAmt3().doubleValue(),
                        payment.getBillAmt4().doubleValue(),
                        payment.getBillAmt5().doubleValue(),
                        payment.getBillAmt6().doubleValue(),
                        payment.getPayAmt1().doubleValue(),
                        payment.getPayAmt2().doubleValue(),
                        payment.getPayAmt3().doubleValue(),
                        payment.getPayAmt4().doubleValue(),
                        payment.getPayAmt5().doubleValue(),
                        payment.getPayAmt6().doubleValue(),
                        payment.getDefaultPaymentNextMonth().intValue()
                    );
                    
                    exchange.getIn().setBody(insertSQL);
                })
                .to("jdbc:myDataSource") // Usa el DataSource para insertar en la base de datos
            .end()
            .process(exchange -> {
                String summary = String.format("Carga completada. Registros exitosos: %d, Registros con error: %d",
                        successfulRecords.get(), failedRecords.get());
                exchange.getIn().setBody(summary);
            })
            .log("${body}");
    }
}