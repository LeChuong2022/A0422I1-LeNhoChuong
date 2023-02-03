package com.furamam04.service;

import com.furamam04.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    void save(Customer customer);

    void delete(Long id);

    List<Customer> findAll();

    Page<Customer> findAllWithPagingAndSortAndSearch(String search, Pageable pageable);

    Page<Customer> findAllWithPagingAndSort(Pageable pageable);

    Customer findById(Long id);


}
