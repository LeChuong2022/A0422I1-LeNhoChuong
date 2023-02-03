package com.furamam04.repository;

import com.furamam04.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "select e. from Employee as e order by e.id desc limit 1", nativeQuery = true)
    Long findIdLastRecord();

    Employee findTopByOrderByIdDesc();

    Page<Employee> findAllByNameContainingOrIdCardContainingOrPhoneContaining(String name, String idCard, String phone, Pageable pageable);
}
