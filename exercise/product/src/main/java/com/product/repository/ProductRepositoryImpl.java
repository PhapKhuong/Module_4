package com.product.repository;

import com.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Iphone X", "China", 7000000));
        products.add(new Product(2, "Iphone 11", "Vietnam", 10000000));
        products.add(new Product(3, "SamSung Galaxy S22", "USA", 20000000));
        products.add(new Product(4, "Laptop Asus", "Japan", 35000000));
        products.add(new Product(5, "Laptop Dell", "Malaysia", 28000000));
        products.add(new Product(6, "Iphone 14", "Indonesia", 17000000));
    }

    public List<Product> findAll() {
        return products;
    }

    public boolean create(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                return false;
            }
        }
        products.add(product);
        return true;
    }

    public void update(int id, Product product) {
        products.removeIf(p -> p.getId() == id);
        products.add(product);
    }

    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public boolean showDetail(int id) {
        return true;
    }

    public Product searchByName(String name) {
        return null;
    }
}
