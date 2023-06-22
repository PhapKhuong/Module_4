package com.picture.service;

import com.picture.model.Feedback;
import com.picture.repository.IPictureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {
    private IPictureRepository repository;

    public PictureServiceImpl(IPictureRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(Feedback feedback) {
        return repository.add(feedback);
    }

    @Override
    public List<Feedback> find() {
        return repository.find();
    }

    @Override
    public void update(int id) {
        repository.update(id);
    }

    @Override
    public Feedback findById(int id) {
        return repository.findById(id);
    }
}
