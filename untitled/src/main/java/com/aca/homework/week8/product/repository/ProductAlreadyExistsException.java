package com.aca.homework.week8.product.repository;

public class ProductAlreadyExistsException extends RuntimeException {
    ProductAlreadyExistsException(String massage) {
        super(massage);
    }
}
