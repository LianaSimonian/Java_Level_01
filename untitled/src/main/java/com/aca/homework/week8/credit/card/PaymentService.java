package com.aca.homework.week8.credit.card;

public class PaymentService {
    public static void pay(CreditCard creditCard, double amountToBePaid) {
        double creditCardBalance = creditCard.getBalance();
        if (creditCardBalance < amountToBePaid)
            throw new InsufficientBalanceException(creditCardBalance, amountToBePaid);
        creditCard.setBalance(creditCardBalance - amountToBePaid);

    }
}
