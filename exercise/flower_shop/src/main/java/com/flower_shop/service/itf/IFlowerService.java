package com.flower_shop.service.itf;

import com.flower_shop.model.Flower;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFlowerService {
    Page<Flower> findAllPage(Pageable pageable, String flowerName);

    List<Flower> findAllList();

    void addOne(Flower flower);

    Flower findById(String id);
}
