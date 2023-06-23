package com.picture.repository;

import com.picture.model.Feedback;
import com.picture.query.PictureQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PictureRepositoryImpl implements IPictureRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public boolean add(Feedback feedback) {
        try {
            entityManager.persist(feedback);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Feedback> find() {
        List<Feedback> feedbacks;
        TypedQuery<Feedback> query =
                (TypedQuery<Feedback>) entityManager.createNativeQuery(PictureQuery.FIND_BY_DATE, Feedback.class);
        feedbacks = query.getResultList();
        return feedbacks;
    }

    @Transactional
    @Override
    public void update(int id) {
        Feedback feedback = findById(id);
        int newLike = feedback.getLiked() + 1;
        feedback.setLiked(newLike);
        entityManager.merge(feedback);
    }

    @Override
    public Feedback findById(int id) {
        return entityManager.find(Feedback.class, id);
    }
}