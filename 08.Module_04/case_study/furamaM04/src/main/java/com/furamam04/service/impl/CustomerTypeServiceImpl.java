package com.furamam04.service.impl;

import com.furamam04.entity.CustomerType;
import com.furamam04.repository.ICustomerTypeRepository;
import com.furamam04.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return (List<CustomerType>) customerTypeRepository.findAll();
    }

    @Override
    public CustomerType findById(Long id) {
        return customerTypeRepository.findById(id).orElse(null);
    }
}
