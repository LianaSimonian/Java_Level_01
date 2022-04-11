package com.aca.homework.week9.iservice.invoice;

public class InvoiceService {
    private Invoice[] invoices;
    private InvoiceReader invoiceReader;

    public InvoiceService(InvoiceReader invoiceReader) {
        this.invoiceReader = invoiceReader;
    }

    public void load() {
        invoices = invoiceReader.read();
    }

    public long totalAmountByType(InvoiceType type) {
        long totalAmount = 0;
        for (Invoice invoice : invoices)
            if (invoice.getType() == type)
                totalAmount += invoice.getAmount();
        return totalAmount;
    }

    public Invoice[] getByType(InvoiceType type) {
        int length = invoices.length;
        Invoice[] filteredInvoices = new Invoice[length];
        int lengthOfFilteredArray = 0;
        for (int i = 0; i < length; i++) {
            if (invoices[i].getType() == type) {
                filteredInvoices[lengthOfFilteredArray] = invoices[i];
                lengthOfFilteredArray++;
            }
        }
        Invoice[] filteredInvoicesWithoutNullTail = getArrayWithoutNullTail(filteredInvoices, lengthOfFilteredArray);
        return filteredInvoicesWithoutNullTail;

    }

    public Invoice[] getByTypeAndCode(InvoiceType type, String code) {
        int length = invoices.length;
        Invoice[] filteredInvoices = new Invoice[length];
        int lengthOfFilteredArray = 0;
        for (int i = 0; i < length; i++)
            if (invoices[i].getType() == type && invoices[i].getCode().equals(code)) {
                filteredInvoices[lengthOfFilteredArray] = invoices[i];
                lengthOfFilteredArray++;
            }
        Invoice[] filteredInvoicesWithoutNullTail = getArrayWithoutNullTail(filteredInvoices, lengthOfFilteredArray);
        return filteredInvoicesWithoutNullTail;

    }

    private static Invoice[] getArrayWithoutNullTail(Invoice[] invoices, int numberOfNotNullElem) {
        Invoice[] invoicesWithoutNullTail = new Invoice[numberOfNotNullElem];
        for (int i = 0; i < numberOfNotNullElem; i++) {
            invoicesWithoutNullTail[i] = invoices[i];
        }
        return invoicesWithoutNullTail;
    }
}