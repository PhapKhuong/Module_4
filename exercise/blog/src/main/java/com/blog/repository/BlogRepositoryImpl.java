package com.blog.repository;

import com.blog.blog_query.BlogQuery;
import com.blog.model.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        List<Blog> blogs;
        TypedQuery<Blog> query =
                (TypedQuery<Blog>) entityManager.createNativeQuery(BlogQuery.SELECT_ALL_BLOG, Blog.class);
        blogs = query.getResultList();
        return blogs;
    }

    @Transactional
    @Override
    public void add(Blog blog) {
        try {
            entityManager.persist(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void update(Blog blog) {
        try {
            Blog blogToUpdate = findOne(blog.getId());
            blogToUpdate.setTitle(blog.getTitle());
            blogToUpdate.setContent(blog.getContent());
            blogToUpdate.setDate(blog.getDate());
            entityManager.merge(blogToUpdate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void delete(int id) {
        try {
            Blog blog = findOne(id);
            entityManager.remove(blog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Blog findOne(int id) {
        return entityManager.find(Blog.class, id);
    }
}
