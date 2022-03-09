package com.aca.homework.week9.invoice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class InvoiceServiceTest {
    @Test
    public void testTotalAmountByTypeSAD() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {
                Invoice[] invoices = {new Invoice("SAD2022-87456", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice(" SAD2022-e4459", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice("SAD2022-f272e", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice("SAD2022-ae", 200, InvoiceType.SAD, "GUCE-CUSTOMS")};
                return invoices;
            }
        });
        testSubject.load();
        Assertions.assertEquals(500, testSubject.totalAmountByType(InvoiceType.SAD));
    }

    @Test
    public void testGetBySADType() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {
                Invoice[] invoices = {new Invoice("SAD2022-87456", 100, InvoiceType.MAN, "GUCE-CUSTOMS"),
                        new Invoice(" SAD2022-e4459", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice("SAD2022-f272e", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice("SAD2022-ae", 200, InvoiceType.MAN, "GUCE-CUSTOMS")};
                return invoices;
            }
        });
        testSubject.load();
        Invoice[] expectedResult = {new Invoice(" SAD2022-e4459", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                new Invoice("SAD2022-f272e", 100, InvoiceType.SAD, "GUCE-CUSTOMS")};
        Invoice[] result = testSubject.getByType(InvoiceType.SAD);
        Assertions.assertEquals(result.length, expectedResult.length);
        Assertions.assertTrue(result[0].equals(expectedResult[0]));
        Assertions.assertTrue(result[1].equals(expectedResult[1]));
    }

    @Test
    public void testGetByMANType() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {
                Invoice[] invoices = {new Invoice("SAD2022-87456", 100, InvoiceType.MAN, "GUCE-CUSTOMS"),
                        new Invoice(" SAD2022-e4459", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice("SAD2022-f272e", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice("SAD2022-ae", 200, InvoiceType.MAN, "GUCE-CUSTOMS")};
                return invoices;
            }
        });
        testSubject.load();
        Invoice[] expectedResult = {new Invoice("SAD2022-87456", 100, InvoiceType.MAN, "GUCE-CUSTOMS"),
                new Invoice("SAD2022-ae", 200, InvoiceType.MAN, "GUCE-CUSTOMS")
        };
        Invoice[] result = testSubject.getByType(InvoiceType.MAN);
        Assertions.assertEquals(result.length, expectedResult.length);
        Assertions.assertTrue(result[0].equals(expectedResult[0]));
        Assertions.assertTrue(result[1].equals(expectedResult[1]));
    }

    @Test
    public void getBySADTypeAndCode() {
        InvoiceService testSubject = new InvoiceService(new InvoiceReader() {
            @Override
            public Invoice[] read() throws FileNotFoundException {
                Invoice[] invoices = {new Invoice("SAD2022-87456", 100, InvoiceType.MAN, "MY-CODE"),
                        new Invoice(" SAD2022-e4459", 100, InvoiceType.SAD, "MY-CODE"),
                        new Invoice("SAD2022-f272e", 100, InvoiceType.SAD, "GUCE-CUSTOMS"),
                        new Invoice("SAD2022-ae45", 245, InvoiceType.MAN, "MY-CODE"),
                        new Invoice("SAD2022-a1e", 200, InvoiceType.SAD, "MY-CODE"),
                        new Invoice("SAD2022-a12e", 200, InvoiceType.MAN, "MY-CODE")
                };
                return invoices;
            }
        });
        testSubject.load();
        Invoice[] result = testSubject.getByTypeAndCode(InvoiceType.MAN, "MY-CODE");
        Invoice[] expectedResult = {new Invoice("SAD2022-87456", 100, InvoiceType.MAN, "MY-CODE"),
                new Invoice("SAD2022-ae45", 245, InvoiceType.MAN, "MY-CODE"),
                new Invoice("SAD2022-a12e", 200, InvoiceType.MAN, "MY-CODE")};
        Assertions.assertEquals(result.length, expectedResult.length);
        Assertions.assertTrue(result[0].equals(expectedResult[0]));
        Assertions.assertTrue(result[1].equals(expectedResult[1]));
        Assertions.assertTrue(result[2].equals(expectedResult[2]));
    }
}