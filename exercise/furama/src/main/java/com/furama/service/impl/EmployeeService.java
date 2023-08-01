package com.furama.service.impl;

import com.furama.model.Employee;
import com.furama.repository.IEmployeeRepository;
import com.furama.service.itf.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable, String employeeName) {
        return employeeRepository.findEmployee(pageable, employeeName);
    }

    @Override
    public void addOne(Employee employee) {
        employeeRepository.save(employee);
    }
}
