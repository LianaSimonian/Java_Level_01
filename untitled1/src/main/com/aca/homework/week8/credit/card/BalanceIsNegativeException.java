package com.aca.homework.week8.credit.card;

public class BalanceIsNegativeException extends RuntimeException {
    BalanceIsNegativeException(String massage) {
        super(massage);
    }
}
