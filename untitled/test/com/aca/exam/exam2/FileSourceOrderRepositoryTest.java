package com.aca.exam.exam2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class FileSourceOrderRepositoryTest {
    private FileSourceOrderRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new FileSourceOrderRepository();
    }

    @Test
    public void testFindByIdWhenIdIsNotFound() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.findById(null);
            }
        });
        Assertions.assertEquals("id can not be null", illegalArgumentException.getMessage());
    }

    @Test
    public void testFindByIdWhenIdIsFound() {
        Order order = new Order(9, "picnic mat", 3000, new User("shawlinspire", "Janea", "Dawson"));
        Order testOrder = testSubject.findById(9);
        Assertions.assertEquals(order.getId(), testOrder.getId());
        Assertions.assertEquals(order.getPrice(), testOrder.getPrice());
        Assertions.assertEquals(order.getName(), testOrder.getName());
        Assertions.assertEquals(order.getPurchasedUser(), testOrder.getPurchasedUser());
    }

    @Test
    public void testFindAllSize() {
    Assertions.assertEquals(9,testSubject.findAll().size());
    }
}