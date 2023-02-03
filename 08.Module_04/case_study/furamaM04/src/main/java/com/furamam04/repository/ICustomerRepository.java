package com.furamam04.repository;

import com.furamam04.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Query(value = "select c from Customer as c where c.name like %:search% or c.idCard like %:search% or c.phone like %:search%")
    Page<Customer> findAllWithPagingAndSortAndSearch(String search, Pageable pageable);

//    Page<Customer> findAllByNameContainingOrIdCardContainingOrPhoneContaining(String name, String idCard, String phone, Pageable pageable);
}
