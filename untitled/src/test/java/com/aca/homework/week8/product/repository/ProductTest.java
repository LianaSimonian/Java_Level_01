package com.aca.homework.week8.product.repository;

import com.aca.homework.week8.product.repository.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
    private Product testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Product(121245, "product name");
    }

    @Test
    public void testEqualsWhenReferenceIsSame() {
        Assertions.assertTrue(testSubject.equals(testSubject));
    }

    @Test
    public void testEqualsWhenOneOfIsNull() {
        Assertions.assertFalse(testSubject.equals(null));
    }

    @Test
    public void testProductEqualString() {
        Assertions.assertFalse(testSubject.equals("String"));
    }

    @Test
    public void testEqualsWhenProductsHaveSameFieldValues() {
        Product product = new Product(121245, "product name");
        Assertions.assertTrue(testSubject.equals(product));
    }

    @Test
    public void testEqualsWhenProductsHaveDifferentFieldValues() {
        Product product = new Product(121248, "product name1");
        Assertions.assertFalse(testSubject.equals(product));
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("id=121245, name='product name'" , testSubject.toString());
    }
}