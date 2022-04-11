package com.aca.homework.week11.repository.invoice;

public class NullInvoiceArgumentException extends RuntimeException {
    public NullInvoiceArgumentException(String message) {
        super(message);
    }
}
