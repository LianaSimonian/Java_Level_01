package com.aca.homework.week8.credit.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreditCardTest {
    private CreditCard testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new CreditCard(100_000.0, "1234567");
    }

    @Test
    public void testEqualsWhenReferenceIsSame() {
        Assertions.assertTrue(testSubject.equals(testSubject));
    }

    @Test
    public void testEqualsWhenCreditCardsHaveSameFieldValues() {
        CreditCard creditCard = new CreditCard(100_000, "1234567");
        Assertions.assertTrue(testSubject.equals(creditCard));
    }

    @Test
    public void testCreditCardEqualString() {
        Assertions.assertFalse(testSubject.equals("String"));
    }

    @Test
    public void testEqualsWhenOneOfIsNull() {
        Assertions.assertFalse(testSubject.equals(null));
    }

    @Test
    public void testEqualsWhenCreditCardsHaveDifferentFieldValues() {
        CreditCard creditCard = new CreditCard(100_000_000, "978645");
        Assertions.assertFalse(testSubject.equals(creditCard));
    }

    @Test
    public void testGetBalance() {
        Assertions.assertEquals(100_000, testSubject.getBalance());
    }

    @Test
    public void testGetNumber() {
        Assertions.assertEquals("1234567", testSubject.getNumber());
    }

    @Test
    public void testSetBalance() {
        testSubject.setBalance(400_000);
        Assertions.assertEquals(400_000, testSubject.getBalance());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("balance: 100000.0, number: 1234567", testSubject.toString());
    }
}