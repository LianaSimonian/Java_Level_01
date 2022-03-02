package com.aca.homework.week8.credit.card;

public class PaymentService {
    public static void pay(CreditCard creditCard, double amountToBePaid) throws InsufficientBalanceException {
        if (creditCard.getBalance() < amountToBePaid)
            throw new InsufficientBalanceException("the provided credit card balance: " + creditCard.getBalance() + " is not enough to perform a payment equals " + amountToBePaid);
        creditCard.setBalance(creditCard.getBalance() - amountToBePaid);

    }
}
