package com.aca.homework.week9.invoice.service;

import java.util.Objects;

public class Invoice {
    private String id;
    private int amount;
    private InvoiceType type;
    private String code;

    public Invoice(String id, int amount, InvoiceType type, String code) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.code = code;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", code='" + code + '\'';
    }

    public int getAmount() {
        return amount;
    }

    public String getCode() {
        return code;
    }

    public String getId() {
        return id;
    }

    public InvoiceType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return amount == invoice.amount && Objects.equals(id, invoice.id) && type == invoice.type && Objects.equals(code, invoice.code);
    }

}