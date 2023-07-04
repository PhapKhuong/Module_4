package com.furama.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_birthday")
    private LocalDate customerBirthday;
    @Column(name = "customer_gender")
    private boolean customerGender;
    @Column(name = "customer_id_card")
    private String customerIdCard;
    @Column(name = "customer_phone")
    private String customerPhone;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "customer_address")
    private String customerAddress;

    @OneToMany(mappedBy = "customer")
    private Set<Contract> contractSet;

    public Customer() {
    }

    public Customer(int customerId, CustomerType customerType, String customerName, LocalDate customerBirthday, boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, Set<Contract> contractSet) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.contractSet = contractSet;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(LocalDate customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }
}
