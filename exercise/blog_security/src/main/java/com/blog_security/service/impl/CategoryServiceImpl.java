package com.blog_security.service.impl;

import com.blog_security.model.Category;
import com.blog_security.repository.ICategoryRepository;
import com.blog_security.service.itf.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    private ICategoryRepository categoryRepository;

    public CategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void add(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findOne(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
