package com.blogs.service;

import com.blogs.model.Blog;
import com.blogs.repository.IBlogRepository;
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
        repository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        repository.save(blog);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Blog findOne(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Blog findByTitle(String str) {
        return repository.findBlogByTitleContaining(str);
    }
}
