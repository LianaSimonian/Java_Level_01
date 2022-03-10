package com.aca.homework.week8.product.repository;

import java.util.Objects;

public class Product {
    private long id;
    private String name;

    public Product(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() == o.getClass()) {
            Product product = (Product) o;
            return id == product.id && name.equals(product.name);
        }
        return false;
    }

    public long getId() {
        return id;
    }
}
