package com.aca.homework.week11.repository.invoice;

import java.util.Objects;

public class Invoice {

    private String id;
    private double amountToPay;
    private InvoiceStatus status;

    public Invoice(String id, double amountToPay, InvoiceStatus status) {
        this.id = id;
        this.amountToPay = amountToPay;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setAmountToPay(double amountToPay) {
        this.amountToPay = amountToPay;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;
        return id != null ? id.equals(invoice.id) : invoice.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}