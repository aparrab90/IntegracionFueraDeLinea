package org.acme.camelIntegracionFueradeLineaaparrab.Components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import org.acme.camelIntegracionFueradeLineaaparrab.Components.ClientCreditProfile; 
import org.acme.camelIntegracionFueradeLineaaparrab.Components.RecordValidationException;

public class ClientCreditValidationProcessor implements Processor {

    private AtomicInteger successfulRecords;
    private AtomicInteger recordCounter;

    // Constructor que acepta los contadores
    public ClientCreditValidationProcessor(AtomicInteger successfulRecords, AtomicInteger recordCounter) {
        this.successfulRecords = successfulRecords;
        this.recordCounter = recordCounter;
    }

    private void validatePaymentFields(ClientCreditProfile payment, int currentRecordNumber) throws RecordValidationException {
        LinkedHashMap<String, Function<ClientCreditProfile, BigDecimal>> fieldValidationRules = new LinkedHashMap<>();
        fieldValidationRules.put("pay0", ClientCreditProfile::getPay0);
        fieldValidationRules.put("pay2", ClientCreditProfile::getPay2);
        fieldValidationRules.put("pay3", ClientCreditProfile::getPay3);
        fieldValidationRules.put("pay4", ClientCreditProfile::getPay4);
        fieldValidationRules.put("pay5", ClientCreditProfile::getPay5);
        fieldValidationRules.put("pay6", ClientCreditProfile::getPay6);
        fieldValidationRules.put("payAmt1",ClientCreditProfile::getPayAmt1);
        fieldValidationRules.put("payAmt2",ClientCreditProfile::getPayAmt2);
        fieldValidationRules.put("payAmt3",ClientCreditProfile::getPayAmt3);
        fieldValidationRules.put("payAmt4",ClientCreditProfile::getPayAmt4);
        fieldValidationRules.put("payAmt5",ClientCreditProfile::getPayAmt5);
        fieldValidationRules.put("payAmt6",ClientCreditProfile::getPayAmt6);
        fieldValidationRules.put("billAmt1",ClientCreditProfile::getBillAmt1);
        fieldValidationRules.put("billAmt2",ClientCreditProfile::getBillAmt2);
        fieldValidationRules.put("billAmt3",ClientCreditProfile::getBillAmt3);
        fieldValidationRules.put("billAmt4",ClientCreditProfile::getBillAmt4);
        fieldValidationRules.put("billAmt5",ClientCreditProfile::getBillAmt5);
        fieldValidationRules.put("billAmt6",ClientCreditProfile::getBillAmt6);

        

        for (Map.Entry<String, Function<ClientCreditProfile, BigDecimal>> check : fieldValidationRules.entrySet()) {
            BigDecimal value = check.getValue().apply(payment);
            if (value.compareTo(BigDecimal.ZERO) <= 0) {
                throw new RecordValidationException("El valor de " + check.getKey() + " no puede ser menor o igual a cero.", currentRecordNumber);
            }
        }
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        ClientCreditProfile payment = exchange.getIn().getBody(ClientCreditProfile.class);
        int currentRecordNumber = recordCounter.incrementAndGet();

        validatePaymentFields(payment, currentRecordNumber);
        successfulRecords.incrementAndGet();
    }
}
