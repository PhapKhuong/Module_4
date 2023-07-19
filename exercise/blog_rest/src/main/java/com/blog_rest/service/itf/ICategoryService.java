package com.blog_rest.service.itf;

import com.blog_rest.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void add(Category category);

    Category findOne(int id);
}
