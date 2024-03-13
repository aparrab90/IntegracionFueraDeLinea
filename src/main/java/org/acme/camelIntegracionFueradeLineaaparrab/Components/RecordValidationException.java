package org.acme.camelIntegracionFueradeLineaaparrab.Components;

public class RecordValidationException extends RuntimeException {
    private final int recordNumber;

    public RecordValidationException(String message, int recordNumber) {
        super(message + " (Número de registro: " + recordNumber + ")");
        this.recordNumber = recordNumber;
    }

    public int getRecordNumber() {
        return recordNumber;
    }
}