package com.blog_api_2.model.dto;

import com.blog_api_2.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class BlogDto implements Validator {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BlogDto blogDto = (BlogDto) target;
        if (blogDto.getTitle().isEmpty()) {
            errors.rejectValue("title", null, "Tittle is not empty!");
        }

        if (blogDto.getContent().isEmpty()) {
            errors.rejectValue("content", null, "Content is not empty");
        } else if (blogDto.getContent().length() > 100) {
            errors.rejectValue("content", null, "Content is not longer 100 characters!");
        }
    }
}
