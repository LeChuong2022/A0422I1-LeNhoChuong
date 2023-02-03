package com.furamam04.service;

import com.furamam04.entity.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    CustomerType findById(Long id);
}
