package com.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentTypeId;

    @Column(name = "rent_type_name")
    private String rentTypeName;
    @Column(name = "rent_type_cost")
    private double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> serviceSet;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, double rentTypeCost, Set<Service> serviceSet) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.serviceSet = serviceSet;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }
}
