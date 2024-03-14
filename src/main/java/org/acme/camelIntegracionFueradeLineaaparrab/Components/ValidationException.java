package org.apache.camel.learn.exception;

public class ValidationException extends RuntimeException {
    private final int recordNumber;

    public ValidationException(String message, int recordNumber) {
        super(message + " (Numero de registro: " + recordNumber + ")");
        this.recordNumber = recordNumber;
    }

    public int getRecordNumber() {
        return recordNumber;
    }
}