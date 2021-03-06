package com.aca.homework.week8.product.repository;

public class NotImplementedProductRepository implements ProductRepository {
    @Override
    public void save(Product product) {
        throw new NotImplementedException("save() not implemented");
    }

    @Override
    public Product getById(Long Id) {
        throw new NotImplementedException("getById() not implemented");
    }

    @Override
    public Product findById(Long id) {
        throw new NotImplementedException("findById not implemented");
    }
}
