package com.furamam04.service;

import com.furamam04.entity.Customer;
import com.furamam04.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    void save(Employee employee);

    void delete(Long id);

    List<Employee> findAll();

    Page<Employee> findAllWithPagingAndSort(Pageable pageable);

    Page<Employee> findAllByNameContainingOrIdCardContainingOrPhoneContaining(String search, Pageable pageable);

    Employee findById(Long id);
}
