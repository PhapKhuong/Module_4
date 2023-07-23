package com.blog_api_2.repository;

import com.blog_api_2.model.Blog;
import com.blog_api_2.query.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = BlogQuery.SELECT_ALL_BLOG, nativeQuery = true)
    Page<Blog> findAllBlogPage(Pageable pageable);

    @Query(value = BlogQuery.SELECT_ALL_BLOG, nativeQuery = true)
    List<Blog> findAllBlogList();

    @Query(value = BlogQuery.SELECT_BLOG_BY_ID, nativeQuery = true)
    Blog findBlogById(@Param("id") int id);

    @Query(value = BlogQuery.SELECT_BLOG_BY_CATEGORY, nativeQuery = true)
    List<Blog> findBlogListByCategory(@Param("blog.category_id") int categoryId);

    @Query(value = BlogQuery.SELECT_BLOG_BY_CATEGORY, nativeQuery = true)
    Page<Blog> findBlogPageByCategory(Pageable pageable, @Param("blog.category_id") int categoryId);
}
