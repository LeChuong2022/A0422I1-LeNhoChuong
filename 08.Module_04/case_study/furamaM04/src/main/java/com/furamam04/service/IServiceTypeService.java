package com.furamam04.service;

import com.furamam04.entity.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();

    ServiceType findById(Long id);
}
