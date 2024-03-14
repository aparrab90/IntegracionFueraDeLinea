package org.acme.camelIntegracionFueradeLineaaparrab;

import java.util.concurrent.atomic.AtomicInteger;
import javax.sql.DataSource;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.DataSourceConfig;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.ValidatorProcessor; 
import org.acme.camelIntegracionFueradeLineaaparrab.Components.ValidationException;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.CustomerPayment;


public class MyRouteBuilder extends RouteBuilder {

    // Contadores para registros exitosos y fallidos
    private final AtomicInteger successfulRecords = new AtomicInteger(0);
    private final AtomicInteger failedRecords = new AtomicInteger(0);
    private final AtomicInteger recordCounter = new AtomicInteger(0);

    @Override
    public void configure() {

        // Registrar el DataSource creado por DataSourceConfig
        DataSource dataSource = DataSourceConfig.createDataSource();
        getContext().getRegistry().bind("myDataSource", dataSource);
        
        recordCounter.set(0); // Reiniciar contador de registros

        // Manejo de excepciones general para errores de validación
        onException(ValidationException.class)
            .process(exchange -> {
                failedRecords.incrementAndGet(); // Incrementar contador de fallidos
                Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
                exchange.getIn().setBody("Error de validacion: " + exception.getMessage());
            })
            .log("${body}")
            .handled(true);

        BindyCsvDataFormat bindyFormat = new BindyCsvDataFormat(CustomerPayment.class);

        from("sftp://sftp:22/upload?username=foo&password=pass&noop=true")
            .routeId("read-csv-file-route")
            .unmarshal(bindyFormat)
            .split(body()).streaming()
                .process(new ValidatorProcessor(successfulRecords, recordCounter))
                .process(exchange -> {
<<<<<<< HEAD
                    ClientCreditProfile payment = exchange.getIn().getBody(ClientCreditProfile.class);
                    String insertSQL = String.format(
                        "INSERT INTO public.customer_payments " +
                        "(id) VALUES " +
                        "(%d)",
                        payment.getId().intValue()
                        
                    );
                    
=======
                    CustomerPayment payment = exchange.getIn().getBody(CustomerPayment.class);
                    String insertSQL = String.format("INSERT INTO customer_payments (id, limit_bal, sex, education, marriage, age, pay_0_1, pay_2_1, pay_3_1, pay_4_1, pay_5_1, pay_6_1, pay_1_2, pay_2_2, pay_3_2, pay_4_2, pay_5_2, pay_6_2, bill_1, bill_2, bill_3, bill_4, bill_5, bill_6, default_payment_next_month) VALUES (%d, %f, %d, %d, %d, %d, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %f, %d)",
                            payment.getID().intValue(), payment.getLIMIT_BAL().doubleValue(), payment.getSEX().intValue(), payment.getEDUCATION().intValue(), payment.getMARRIAGE().intValue(), payment.getAGE().intValue(), payment.getPAY_0_1().doubleValue(), payment.getPAY_2_1().doubleValue(), payment.getPAY_3_1().doubleValue(), payment.getPAY_4_1().doubleValue(), payment.getPAY_5_1().doubleValue(), payment.getPAY_6_1().doubleValue(), payment.getPAY_1_2().doubleValue(), payment.getPAY_2_2().doubleValue(), payment.getPAY_3_2().doubleValue(), payment.getPAY_4_2().doubleValue(), payment.getPAY_5_2().doubleValue(), payment.getPAY_6_2().doubleValue(), payment.getBILL_1().doubleValue(), payment.getBILL_2().doubleValue(), payment.getBILL_3().doubleValue(), payment.getBILL_4().doubleValue(), payment.getBILL_5().doubleValue(), payment.getBILL_6().doubleValue(), payment.getDefaultPaymentNextMonth().intValue());
>>>>>>> a22e340692f368488c4223da792fedbd7b85a373
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