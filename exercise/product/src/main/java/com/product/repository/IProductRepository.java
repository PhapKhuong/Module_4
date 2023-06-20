package com.product.repository;

import com.product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean create(Product product);

    void update(int id, Product product);

    void delete(int id);

    boolean showDetail(int id);

    Product searchByName(String name);
}
