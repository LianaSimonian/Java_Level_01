package com.aca.homework.week11.repository.invoice;

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
}