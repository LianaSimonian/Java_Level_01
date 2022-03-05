package com.aca.homework.week8.product.repository;

public class InMemoryProductRepository implements ProductRepository {
    private final int size = 10000;
    private Product[] products = new Product[size];
    private int counter;

    @Override
    public void save(Product product) {
        if (product == null)
            throw new IllegalArgumentException("product is null");
        Product elementFound = findProduct(product);
        if (elementFound != null)
            throw new ProductAlreadyExistsException("element exists");
        products[counter++] = product;
    }
    @Override
    public Product findById(Long id) {
        for (int i = 0; i < counter; i++)
            if (products[i].getId() == id) return products[i];
        return null;
    }

    @Override
    public Product getById(Long Id) {
        for (int i = 0; i < counter; i++)
            if (products[i].getId() == Id) return products[i];
        throw new ProductNotFoundException(Id);
    }

    public int counter() {
        return counter;
    }

    private Product findProduct(Product product) {
        for (int i = 0; i < counter; i++)
            if (products[i].equals(product))
                return products[i];
        return null;
    }
}
