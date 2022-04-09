package com.aca.homework.week11.repository.invoice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

class HashSetInvoiceRepositoryTest {

    private HashSetInvoiceRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new HashSetInvoiceRepository();
    }

    @Test
    public void testSaveWhenSetIsEmpty() {
        Invoice invoice = new Invoice("id", 1245, InvoiceStatus.PAID);
        Invoice invoice1 = testSubject.save(invoice);
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals("id", invoice1.getId());
        Assertions.assertEquals(1245, invoice1.getAmountToPay());
        Assertions.assertEquals(InvoiceStatus.PAID, invoice1.getStatus());
    }

    @Test
    public void testSaveWhenExistsWithSameIdButNewFieldsAreDifferent() {
        testSubject.save(new Invoice("id", 1245, InvoiceStatus.PAID));
        Invoice invoice = testSubject.save(new Invoice("id", 12, InvoiceStatus.UNPAID));
        Assertions.assertEquals(1, testSubject.size());
        Assertions.assertEquals("id", invoice.getId());
        Assertions.assertEquals(InvoiceStatus.UNPAID, invoice.getStatus());
        Assertions.assertEquals(12, invoice.getAmountToPay());
    }

    @Test
    public void testSave2Times() {
        testSubject.save(new Invoice("id", 1245, InvoiceStatus.PAID));
        Invoice invoice = testSubject.save(new Invoice("id1", 124, InvoiceStatus.UNPAID));
        Assertions.assertEquals(2, testSubject.size());
        Assertions.assertEquals("id1", invoice.getId());
        Assertions.assertEquals(124, invoice.getAmountToPay());
        Assertions.assertEquals(InvoiceStatus.UNPAID, invoice.getStatus());
    }

    @Test
    public void testFindByIdWhenNotFound() {
        Assertions.assertNull(testSubject.findById("id"));
    }

    @Test
    public void testFindByIdWhenFound() {
        Invoice invoice = new Invoice("id", 1245, InvoiceStatus.PAID);
        testSubject.save(invoice);
        Assertions.assertSame(invoice, testSubject.findById("id"));
    }

    @Test
    public void testFindAllWhenEmpty() {
        Assertions.assertTrue(testSubject.findAll().isEmpty());
    }

    @Test
    public void testFindAllWhenIsNotEmpty() {
        Invoice invoice1 = new Invoice("id1", 12, InvoiceStatus.PAID);
        Invoice invoice2 = new Invoice("id2", 13, InvoiceStatus.PAID);
        Invoice invoice3 = new Invoice("id3", 14, InvoiceStatus.UNPAID);
        testSubject.save(invoice1);
        testSubject.save(invoice2);
        testSubject.save(invoice3);
        List<Invoice> list = List.of(invoice1, invoice2, invoice3);
        List<Invoice> testList = testSubject.findAll();
        Assertions.assertEquals(3, testList.size());
        Assertions.assertTrue(testList.containsAll(list));
    }

    @Test
    public void testDeleteWhenEmpty() {
        HashSetEmptyException hashSetEmptyException = Assertions.assertThrows(HashSetEmptyException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.delete(new Invoice("id", 1245, InvoiceStatus.PAID));
            }
        });
        Assertions.assertEquals("HashSetRepository is empty", hashSetEmptyException.getMessage());
    }

    @Test
    public void testDeleteWhenExist() {
        Invoice invoice = new Invoice("id", 1245, InvoiceStatus.PAID);
        testSubject.save(invoice);
        Assertions.assertEquals(1, testSubject.size());
        testSubject.delete(invoice);
        Assertions.assertEquals(0, testSubject.size());
        Assertions.assertNull(testSubject.findById("id"));
    }

    @Test
    public void testSize() {
        Assertions.assertEquals(0, testSubject.size());
        Invoice invoice = new Invoice("id", 1245, InvoiceStatus.PAID);
        testSubject.save(invoice);
        Assertions.assertEquals(1, testSubject.size());
    }
}