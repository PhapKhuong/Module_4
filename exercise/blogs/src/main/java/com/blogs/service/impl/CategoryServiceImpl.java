package com.blogs.service.impl;

import com.blogs.model.Category;
import com.blogs.repository.ICategoryRepository;
import com.blogs.service.itf.ICategoryService;
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
