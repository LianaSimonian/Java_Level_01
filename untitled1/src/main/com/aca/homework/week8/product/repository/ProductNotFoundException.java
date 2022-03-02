package com.aca.homework.week8.product.repository;

public class ProductNotFoundException extends RuntimeException {
    ProductNotFoundException(String massage) {
        super(massage);
    }
}
