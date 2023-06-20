package com.product.service;

import com.product.model.Product;
import com.product.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private IProductRepository repository;

    private ProductService(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(Product product) {
        return repository.create(product);
    }

    @Override
    public void update(int id, Product product) {
        repository.update(id, product);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public boolean showDetail(int id) {
        return repository.showDetail(id);
    }

    @Override
    public Product searchByName(String name) {
        return repository.searchByName(name);
    }
}
