package com.aca.homework.week8.credit.card;

import java.util.Objects;

public class CreditCard {
    private double balance;
    private String number;

    public CreditCard(double balance, String number) {
        this.balance = balance;
        this.number = number;
    }

    @Override
    public String toString() {
        return "balance: " + balance +
                ", number: " + number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != CreditCard.class) return false;
        CreditCard creditCard = (CreditCard) o;
        return creditCard.balance == balance && number == creditCard.number;
    }

    public double getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
