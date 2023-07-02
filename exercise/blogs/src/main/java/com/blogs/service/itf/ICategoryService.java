package com.blogs.service.itf;

import com.blogs.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void add(Category category);

    Category findOne(int id);
}
