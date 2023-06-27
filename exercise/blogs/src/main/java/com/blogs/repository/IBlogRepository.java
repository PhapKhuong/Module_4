package com.blogs.repository;

import com.blogs.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Blog findBlogByTitleContaining(String str);
}
