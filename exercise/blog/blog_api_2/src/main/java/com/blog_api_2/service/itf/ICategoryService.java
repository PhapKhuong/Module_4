package com.blog_api_2.service.itf;

import com.blog_api_2.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void add(Category category);

    Category findOne(int id);
}
