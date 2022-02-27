package com.aca.homework.week8.payment.service;

public class PaymentResult {
    private int paymentAmount;
    private long processingTime;

    public PaymentResult(int paidAmount, long processingTime) {
        this.paymentAmount = paidAmount;
        this.processingTime = processingTime;
    }

    public long getProcessingTime() {
        return processingTime;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public static PaymentResult paymentResultOf(int paymentAmount, long processingTime) {
        return new PaymentResult(paymentAmount, processingTime);
    }
}
