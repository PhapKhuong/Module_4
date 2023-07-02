package com.blogs.service.itf;

import com.blogs.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    void add(Blog blog);

    void update(Blog blog);

    void delete(int id);

    Blog findOne(int id);

    Page<Blog> findByCategory(Pageable pageable, int id);

    List<Blog> findByCategory(int id);

}
