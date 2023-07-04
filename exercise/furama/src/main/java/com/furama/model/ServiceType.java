package com.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int serviceTypeId;

    @Column(name = "service_type_name")
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> serviceSet;

    public ServiceType() {
    }

    public ServiceType(int serviceTypeId, String serviceTypeName, Set<Service> serviceSet) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.serviceSet = serviceSet;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }
}
