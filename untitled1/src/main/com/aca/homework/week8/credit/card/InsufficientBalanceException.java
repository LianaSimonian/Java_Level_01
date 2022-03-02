package com.aca.homework.week8.credit.card;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String massage) {
        super(massage);
    }
}
