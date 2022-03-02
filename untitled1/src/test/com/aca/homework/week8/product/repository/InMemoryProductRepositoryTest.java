package com.aca.homework.week8.product.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class InMemoryProductRepositoryTest {
    private InMemoryProductRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new InMemoryProductRepository();
    }

    @Test
    public void testSaveWhenProductIsNull() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(null);
            }
        });
        Assertions.assertEquals("product is null" , illegalArgumentException.getMessage());
    }

    @Test
    public void testSaveWhenProductDoesNotExist() {
        int sizeBeforeSave = testSubject.getCounter();
        Product product = new Product(124578, "product name");
        testSubject.save(product);
        int sizeAfterSave = testSubject.getCounter();
        Assertions.assertEquals(sizeAfterSave, sizeBeforeSave + 1);
    }

    @Test
    public void testSaveWhenProductAlreadyExist() {
        Product product = new Product(124578, "product name");
        testSubject.save(product);
        ProductAlreadyExistsException productAlreadyExistsException = Assertions.assertThrows(ProductAlreadyExistsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(product);
            }
        });
        Assertions.assertEquals("element exists" , productAlreadyExistsException.getMessage());
    }

    @Test
    public void testFindByIdWhenProductDoesNotExist() {
        Product product = new Product(124578, "product name");
        testSubject.save(product);
        Assertions.assertNull(testSubject.findById(12455L));
    }

    @Test
    public void testFindByIdWhenProductExists() {
        Product product = new Product(124578, "product name");
        testSubject.save(product);
        Assertions.assertEquals(product, testSubject.findById(124578L));
    }

    @Test
    public void testGetByIdWhenProductDoesNotExist() {
        Product product = new Product(124578, "product name");
        testSubject.save(product);
        ProductNotFoundException productNotFoundException = Assertions.assertThrows(ProductNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.getById(1248712L);
            }
        });
        Assertions.assertEquals("element don't find" , productNotFoundException.getMessage());
    }

    @Test
    public void testGetByIdWhenProductExists() {
        Product product = new Product(124578, "product name");
        testSubject.save(product);
        Assertions.assertEquals(product, testSubject.getById(124578L));
    }
}