package com.furama.repository;

import com.furama.model.Customer;
import com.furama.query.FQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = FQuery.SELECT_ALL_CUSTOMER, nativeQuery = true)
    Page<Customer> findCustomer(Pageable pageable);
}
