package com.picture.service;

import com.picture.model.Feedback;

import java.util.List;

public interface IPictureService {
    boolean add(Feedback feedback);

    List<Feedback> find();

    void update(int id);

    Feedback findById(int id);
}
