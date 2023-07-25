package com.blog_security.service.itf;

import com.blog_security.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void add(Category category);

    Category findOne(int id);
}
