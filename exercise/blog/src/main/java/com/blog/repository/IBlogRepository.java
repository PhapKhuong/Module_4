package com.blog.repository;

import com.blog.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    void add(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Blog findOne(int id);
}
