package com.blog_api_1.service.impl;

import com.blog_api_1.model.Blog;
import com.blog_api_1.repository.IBlogRepository;
import com.blog_api_1.service.itf.IBlogService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    private IBlogRepository blogRepository;

    public BlogServiceImpl(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAllBlogPage(pageable);
//        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAllBlogList();
    }

    @Override
    public void add(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Blog findOne(int id) {
        return blogRepository.findBlogById(id);
    }

    @Override
    public Page<Blog> findByCategory(Pageable pageable, int id) {
        return blogRepository.findBlogPageByCategory(pageable, id);
    }

    @Override
    public List<Blog> findByCategory(int id) {
        return blogRepository.findBlogListByCategory(id);
    }
}
