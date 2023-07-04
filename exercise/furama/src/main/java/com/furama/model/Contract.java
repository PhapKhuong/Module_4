package com.furama.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractId;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "serviceId")
    private Service service;

    @Column(name = "contract_start_date")
    private LocalDateTime contractStartDate;
    @Column(name = "contract_end_date")
    private LocalDateTime contractEndDate;
    @Column(name = "deposit")
    private double deposit;
    @Column(name = "total_money")
    private double totalMoney;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetail> contractDetailSet;

    public Contract() {
    }

    public Contract(int contractId, Employee employee, Customer customer, Service service, LocalDateTime contractStartDate, LocalDateTime contractEndDate, double deposit, double totalMoney, Set<ContractDetail> contractDetailSet) {
        this.contractId = contractId;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.contractStartDate = contractStartDate;
        this.contractEndDate = contractEndDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.contractDetailSet = contractDetailSet;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public LocalDateTime getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(LocalDateTime contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public LocalDateTime getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(LocalDateTime contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Set<ContractDetail> getContractDetailSet() {
        return contractDetailSet;
    }

    public void setContractDetailSet(Set<ContractDetail> contractDetailSet) {
        this.contractDetailSet = contractDetailSet;
    }
}
