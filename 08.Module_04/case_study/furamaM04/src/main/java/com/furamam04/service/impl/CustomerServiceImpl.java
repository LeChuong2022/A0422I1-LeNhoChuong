package com.furamam04.service.impl;

import com.furamam04.entity.Contract;
import com.furamam04.entity.Customer;
import com.furamam04.repository.ICustomerRepository;
import com.furamam04.service.IContractService;
import com.furamam04.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IContractService contractService;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAllWithPagingAndSortAndSearch(String search, Pageable pageable) {
        return customerRepository.findAllWithPagingAndSortAndSearch(search, pageable);
    }

    @Override
    public Page<Customer> findAllWithPagingAndSort(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> findAllJoinContract(Pageable pageable) {
        return customerRepository.findAllJoinContract(pageable);
    }

    @Override
    public Page<Customer> findAllJoinContractWithSearch(String search, Pageable pageable) {
        return customerRepository.findAllJoinContractWithSearch(search, pageable);
    }

    @Override
    public List<Double> calTotal() {
        return null;
    }


//        return customerRepository.calTotal();


}
