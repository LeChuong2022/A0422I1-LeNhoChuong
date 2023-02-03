package com.furamam04.service.impl;

import com.furamam04.entity.ServiceType;
import com.furamam04.repository.IServiceTypeRepository;
import com.furamam04.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return (List<ServiceType>) serviceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(Long id) {
        return serviceTypeRepository.findById(id).orElse(null);
    }
}
