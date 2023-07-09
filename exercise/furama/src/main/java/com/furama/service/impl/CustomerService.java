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
    private ICustomerRepository customerRepository;

    private CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findCustomer(pageable);
    }

    @Override
    public boolean addOne(Customer customer) {
        customerRepository.save(customer);
        return true;
    }
}
