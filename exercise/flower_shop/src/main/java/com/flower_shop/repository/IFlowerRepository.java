package com.flower_shop.repository;

import com.flower_shop.model.Flower;
import com.flower_shop.query.FlowerQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IFlowerRepository extends JpaRepository<Flower, String> {

    @Query(value = FlowerQuery.SELECT_ALL_FLOWER_PAGE_BY_NAME, nativeQuery = true)
    Page<Flower> findFlowerPage(Pageable pageable, @Param("flower_name") String flowerName);

    @Query(value = FlowerQuery.SELECT_ALL_FLOWER, nativeQuery = true)
    List<Flower> findAllFlower();
}
