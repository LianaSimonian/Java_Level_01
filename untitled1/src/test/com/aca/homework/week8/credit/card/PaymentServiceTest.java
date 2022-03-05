package com.aca.homework.week8.credit.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PaymentServiceTest {
    @Test
    public void testPayWhenBalanceLessThenAmountToBePaid() {
        InsufficientBalanceException insufficientBalanceException = Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                PaymentService.pay(new CreditCard(100, "12457"), 150);
            }
        });
        Assertions.assertEquals("the provided credit card balance: 100.0 is not enough to perform a payment equals 150.0", insufficientBalanceException.getMessage());
    }

    @Test
    public void testPayWhenBalanceGreaterThenAmountToBePaid() {
        CreditCard creditCard = new CreditCard(100, "12457");
        PaymentService.pay(creditCard, 30);
        PaymentService.pay(creditCard, 30);
        PaymentService.pay(creditCard, 30);
        InsufficientBalanceException insufficientBalanceException = Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                PaymentService.pay(creditCard, 30);
            }
        });
        Assertions.assertEquals("the provided credit card balance: 10.0 is not enough to perform a payment equals 30.0", insufficientBalanceException.getMessage());
    }
}