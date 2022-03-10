package com.aca.homework.week8.product.repository;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(Long id) {
        super("element having " + id + " don't find");
    }
}
