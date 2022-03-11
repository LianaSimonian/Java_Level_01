package com.aca.homework.week9.iservice.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvoiceTest {
    private Invoice testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Invoice("SAD2022-87456", 544611032, InvoiceType.SAD, "GUCE-CUSTOMS");
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("id='SAD2022-87456', amount=544611032, type=SAD, code='GUCE-CUSTOMS'", testSubject.toString());
    }

    @Test
    public void testGetId() {
        Assertions.assertEquals("SAD2022-87456", testSubject.getId());
    }

    @Test
    public void testGetAmount() {
        Assertions.assertEquals(544611032, testSubject.getAmount());
    }

    @Test
    public void testGetType() {
        Assertions.assertEquals(InvoiceType.SAD, testSubject.getType());
    }

    @Test
    public void testGetCode() {
        Assertions.assertEquals("GUCE-CUSTOMS", testSubject.getCode());
    }

    @Test
    public void testEqualsWhenReferenceIsSame() {
        Assertions.assertTrue(testSubject.equals(testSubject));
    }

    @Test
    public void testEqualsWhenInvoicesHaveSameFieldValues() {
        Invoice invoice = new Invoice("SAD2022-87456", 544611032, InvoiceType.SAD, "GUCE-CUSTOMS");
        Assertions.assertTrue(testSubject.equals(invoice));
    }

    @Test
    public void testInvoiceEqualInteger() {
        Assertions.assertFalse(testSubject.equals(Integer.valueOf(12)));
    }

    @Test
    public void testEqualsWhenArgumentIsNull() {
        Assertions.assertFalse(testSubject.equals(null));
    }

    @Test
    public void testEqualsWhenInvoicesHaveDifferentFieldValues() {
        Invoice invoice = new Invoice("SAD2022-8745", 54461103, InvoiceType.SAD, "GUCE-CUSTOM");
        Assertions.assertFalse(testSubject.equals(invoice));
    }
}