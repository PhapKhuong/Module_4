package com.blog_api_1.dto;

import com.blog_api_1.model.Category;

import java.time.LocalDate;

public class BlogDto {
    private int id;
    private String title;
    private String content;
    private LocalDate date;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String title, String content, LocalDate date, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
