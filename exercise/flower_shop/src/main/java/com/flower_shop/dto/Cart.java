package com.flower_shop.dto;

import com.flower_shop.model.Flower;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Flower, Integer> flowerMap = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Flower, Integer> flowerMap) {
        this.flowerMap = flowerMap;
    }

    public Map<Flower, Integer> getFlowerMap() {
        return flowerMap;
    }

    public void setFlowerMap(Map<Flower, Integer> flowerMap) {
        this.flowerMap = flowerMap;
    }

    public void addFlower(Flower flower, int number) {
        if (this.flowerMap.containsKey(flower)) {
            Integer currentValue = flowerMap.get(flower);
            this.flowerMap.replace(flower, currentValue + number);
        } else {
            this.flowerMap.put(flower, number);
        }
    }
}
