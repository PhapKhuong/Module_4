package com.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attachServiceId;

    @Column(name = "attach_service_name")
    private String attachServiceName;
    @Column(name = "attach_service_cost")
    private double attachServiceCost;
    @Column(name = "attach_service_unit")
    private int attachServiceUnit;
    @Column(name = "attach_service_status")
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetailSet;

    public AttachService() {
    }

    public AttachService(int attachServiceId, String attachServiceName, double attachServiceCost, int attachServiceUnit, String attachServiceStatus, Set<ContractDetail> contractDetailSet) {
        this.attachServiceId = attachServiceId;
        this.attachServiceName = attachServiceName;
        this.attachServiceCost = attachServiceCost;
        this.attachServiceUnit = attachServiceUnit;
        this.attachServiceStatus = attachServiceStatus;
        this.contractDetailSet = contractDetailSet;
    }

    public int getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(int attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public int getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(int attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
