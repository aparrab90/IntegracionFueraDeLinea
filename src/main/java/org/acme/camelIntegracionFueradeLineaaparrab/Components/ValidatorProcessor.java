package org.acme.camelIntegracionFueradeLineaaparrab.Components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.CustomerPayment;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.ValidationException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

public class ValidatorProcessor implements Processor {

    private AtomicInteger successfulRecords;
    private AtomicInteger recordCounter;

    // Constructor que acepta los contadores
    public ValidatorProcessor(AtomicInteger successfulRecords, AtomicInteger recordCounter) {
        this.successfulRecords = successfulRecords;
        this.recordCounter = recordCounter;
    }

    private void validatePayments(CustomerPayment payment, int currentRecordNumber) throws ValidationException {
        LinkedHashMap<String, Function<CustomerPayment, BigDecimal>> paymentChecks = new LinkedHashMap<>();
        paymentChecks.put("PAY_0_1", CustomerPayment::getPAY_0_1);
        paymentChecks.put("PAY_2_1", CustomerPayment::getPAY_2_1);
        paymentChecks.put("PAY_3_1", CustomerPayment::getPAY_3_1);
        paymentChecks.put("PAY_4_1", CustomerPayment::getPAY_4_1);
        paymentChecks.put("PAY_5_1", CustomerPayment::getPAY_5_1);
        paymentChecks.put("PAY_6_1", CustomerPayment::getPAY_6_1);
        paymentChecks.put("PAY_1_2", CustomerPayment::getPAY_1_2);
        paymentChecks.put("PAY_2_2", CustomerPayment::getPAY_2_2);
        paymentChecks.put("PAY_3_2", CustomerPayment::getPAY_3_2);
        paymentChecks.put("PAY_4_2", CustomerPayment::getPAY_4_2);
        paymentChecks.put("PAY_5_2", CustomerPayment::getPAY_5_2);
        paymentChecks.put("PAY_6_2", CustomerPayment::getPAY_6_2);
        paymentChecks.put("BILL_1", CustomerPayment::getBILL_1);
        paymentChecks.put("BILL_2", CustomerPayment::getBILL_2);
        paymentChecks.put("BILL_3", CustomerPayment::getBILL_3);
        paymentChecks.put("BILL_4", CustomerPayment::getBILL_4);
        paymentChecks.put("BILL_5", CustomerPayment::getBILL_5);
        paymentChecks.put("BILL_6", CustomerPayment::getBILL_6);

        for (Map.Entry<String, Function<CustomerPayment, BigDecimal>> check : paymentChecks.entrySet()) {
            BigDecimal value = check.getValue().apply(payment);
            if (value.compareTo(BigDecimal.ZERO) <= 0) {
                throw new ValidationException("El valor de " + check.getKey() + " no puede ser menor o igual a cero.", currentRecordNumber);
            }
        }
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        CustomerPayment payment = exchange.getIn().getBody(CustomerPayment.class);
        int currentRecordNumber = recordCounter.incrementAndGet();

        validatePayments(payment, currentRecordNumber);
        successfulRecords.incrementAndGet();
    }
}