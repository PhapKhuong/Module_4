package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    private IBlogRepository repository;

    public BlogServiceImpl(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Blog> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Blog blog) {
        repository.add(blog);
    }

    @Override
    public void update(Blog blog) {
        repository.update(blog);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }

    @Override
    public Blog findOne(int id) {
        return repository.findOne(id);
    }
}
