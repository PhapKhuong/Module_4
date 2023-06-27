package com.blogs.service;

import com.blogs.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void add(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Blog findOne(int id);

    Blog findByTitle (String str);
}
