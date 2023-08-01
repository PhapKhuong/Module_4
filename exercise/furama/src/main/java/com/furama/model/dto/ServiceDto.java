package com.furama.model.dto;

import com.furama.model.RentType;
import com.furama.model.ServiceType;
import com.furama.regex.FRegex;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ServiceDto implements Validator {
    private String serviceId;
    private String serviceName;
    private int serviceArea;
    private double serviceCost;
    private int serviceMaxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    private String standardRoom;
    private String descriptionOtherConvenience;
    private double poolArea;
    private int numberOfFloors;

    public ServiceDto() {
    }

    public ServiceDto(String serviceId, String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String descriptionOtherConvenience, double poolArea, int numberOfFloors) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;

        if (!serviceDto.getServiceId().matches(FRegex.REGEX_SERVICE_ID)) {
            errors.rejectValue("serviceId", null, "Service ID is not formatted correctly!");
        }

        if (serviceDto.getServiceArea() <= 0) {
            errors.rejectValue("serviceArea", null, "Service area is more than 0");
        }

        if (serviceDto.getServiceCost() <= 0) {
            errors.rejectValue("serviceCost", null, "Service cost is more than 0");
        }

        if (serviceDto.getServiceMaxPeople() <= 0) {
            errors.rejectValue("serviceMaxPeople", null, "Max people is more than 0");
        }

        if (serviceDto.getPoolArea() <= 0) {
            errors.rejectValue("poolArea", null, "Pool area is more than 0");
        }

        if (serviceDto.getNumberOfFloors() <= 0) {
            errors.rejectValue("numberOfFloors", null, "Number of floor is more than 0");
        }
    }
}
