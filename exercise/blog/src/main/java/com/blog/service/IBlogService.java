package com.blog.service;

import com.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void add(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Blog findOne(int id);
}
