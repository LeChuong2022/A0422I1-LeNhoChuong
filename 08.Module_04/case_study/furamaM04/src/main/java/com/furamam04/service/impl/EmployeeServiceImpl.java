package com.furamam04.service.impl;

import com.furamam04.entity.Customer;
import com.furamam04.entity.Employee;
import com.furamam04.repository.IEmployeeRepository;
import com.furamam04.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employeeRepository.save(employee);
            Employee e = employeeRepository.findTopByOrderByIdDesc();
            long idLastRecord = e.getId();
//        if (e != null)
//            idLastRecord = e.getId();
            if (idLastRecord < 10)
                employee.setStringId("NV00" + idLastRecord);
            else if (idLastRecord < 100)
                employee.setStringId("NV0" + idLastRecord);
            else
                employee.setStringId("NV" + idLastRecord);
        }
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllWithPagingAndSort(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findAllByNameContainingOrIdCardContainingOrPhoneContaining(String search, Pageable pageable) {
        return employeeRepository.findAllByNameContainingOrIdCardContainingOrPhoneContaining(search, search, search, pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
