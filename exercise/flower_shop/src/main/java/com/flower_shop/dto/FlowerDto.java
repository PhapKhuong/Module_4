package com.flower_shop.dto;

import org.springframework.web.multipart.MultipartFile;

public class FlowerDto {
    private String flowerId;
    private String flowerName;
    private double price;
    private int quantity;
    private String description;
    private MultipartFile image;

    public FlowerDto() {
    }

    public FlowerDto(String flowerId, String flowerName, double price, int quantity, String description, MultipartFile image) {
        this.flowerId = flowerId;
        this.flowerName = flowerName;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
