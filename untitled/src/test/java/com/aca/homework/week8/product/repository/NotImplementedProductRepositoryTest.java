package com.aca.homework.week8.product.repository;

import com.aca.homework.week8.product.repository.NotImplementedException;
import com.aca.homework.week8.product.repository.NotImplementedProductRepository;
import com.aca.homework.week8.product.repository.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class NotImplementedProductRepositoryTest {
    private NotImplementedProductRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new NotImplementedProductRepository();
    }

    @Test
    public void testForSave() {
        NotImplementedException notImplementedException = Assertions.assertThrows(NotImplementedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.save(new Product(121214, "the product"));
            }
        });
        Assertions.assertEquals("save() not implemented" , notImplementedException.getMessage());
    }

    @Test
    public void testForGetById() {
        NotImplementedException notImplementedException = Assertions.assertThrows(NotImplementedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.getById(1245L);
            }
        });
        Assertions.assertEquals("getById() not implemented" , notImplementedException.getMessage());
    }

    @Test
    public void testForFindById() {
        NotImplementedException notImplementedException = Assertions.assertThrows(NotImplementedException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.findById(1245L);
            }
        });
        Assertions.assertEquals("findById not implemented" , notImplementedException.getMessage());
    }
}