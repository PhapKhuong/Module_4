package com.blog_rest.dto;

import com.blog_rest.model.Blog;
import com.blog_rest.model.Category;
import org.springframework.data.domain.Page;

public class BlogPageSearch {
    private Category category;
    private Page<Blog> blogPage;

    public BlogPageSearch() {
    }

    public BlogPageSearch(Category category, Page<Blog> blogPage) {
        this.category = category;
        this.blogPage = blogPage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Page<Blog> getBlogPage() {
        return blogPage;
    }

    public void setBlogPage(Page<Blog> blogPage) {
        this.blogPage = blogPage;
    }
}
