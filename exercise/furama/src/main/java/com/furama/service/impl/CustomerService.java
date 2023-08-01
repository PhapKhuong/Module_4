package com.furama.service.impl;

import com.furama.model.Customer;
import com.furama.repository.ICustomerRepository;
import com.furama.service.itf.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable, String customerName) {
        return customerRepository.findCustomer(pageable, customerName);
    }

    @Override
    public void addOne(Customer customer) {
        customerRepository.save(customer);
    }
}
