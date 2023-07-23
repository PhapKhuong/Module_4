package com.blog_api_1.service.itf;

import com.blog_api_1.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void add(Category category);

    Category findOne(int id);
}
