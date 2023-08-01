package com.furama.repository;

import com.furama.model.Employee;
import com.furama.query.FQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = FQuery.SELECT_ALL_EMPLOYEE, nativeQuery = true)
    Page<Employee> findEmployee(Pageable pageable,
                                @Param("employee_name") String employeeName);
}
