package com.picture.repository;

import com.picture.model.Feedback;

import java.util.List;

public interface IPictureRepository {
    boolean add(Feedback feedback);

    List<Feedback> find();

    void update(int id);

    Feedback findById(int id);
}
