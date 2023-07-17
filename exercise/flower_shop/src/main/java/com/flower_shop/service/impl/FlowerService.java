package com.flower_shop.service.impl;

import com.flower_shop.model.Flower;
import com.flower_shop.repository.IFlowerRepository;
import com.flower_shop.service.itf.IFlowerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService implements IFlowerService {
    private IFlowerRepository flowerRepository;

    private FlowerService(IFlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @Override
    public Page<Flower> findAllPage(Pageable pageable, String flowerName) {
        return flowerRepository.findFlowerPage(pageable, flowerName);
    }

    @Override
    public List<Flower> findAllList() {
        return flowerRepository.findAllFlower();
    }

    @Override
    public void addOne(Flower flower) {
        flowerRepository.save(flower);
    }

    @Override
    public Flower findById(String id) {
        return flowerRepository.findById(id).orElse(null);
    }
}
