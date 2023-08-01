package com.furama.model.dto;

import com.furama.model.CustomerType;
import com.furama.regex.FRegex;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

public class CustomerDto implements Validator {
    private String customerId;
    private CustomerType customerType;
    private String customerName;
    private LocalDate customerBirthday;
    private boolean customerGender;
    private String customerIdCard;
    private String customerPhone;
    private String customerEmail;
    private String customerAddress;

    public CustomerDto() {
    }

    public CustomerDto(String customerId, CustomerType customerType, String customerName, LocalDate customerBirthday, boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        if(!customerDto.getCustomerId().matches(FRegex.REGEX_CUSTOMER_ID)){
            errors.rejectValue("customerId", null, "Customer ID is not formatted correctly!");
        }

        if(!customerDto.getCustomerIdCard().matches(FRegex.REGEX_ID_NUMBER)){
            errors.rejectValue("customerIdCard", null, "ID card is not formatted correctly!");
        }

        if(!customerDto.getCustomerPhone().matches(FRegex.REGEX_PHONE)){
            errors.rejectValue("customerPhone", null, "Phone is not formatted correctly!");
        }

        if(!customerDto.getCustomerEmail().matches(FRegex.REGEX_EMAIL)){
            errors.rejectValue("customerEmail", null, "Email is not formatted correctly!");
        }
    }
}
