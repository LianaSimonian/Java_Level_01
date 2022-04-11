package com.aca.homework.week8.credit.card;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(double balance, double amountToBePaid) {
        super("the provided credit card balance: " + balance + " is not enough to perform a payment equals " + amountToBePaid);
    }
}
