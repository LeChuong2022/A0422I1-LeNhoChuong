package com.furamam04.service.impl;

import com.furamam04.repository.IServiceRepository;
import com.furamam04.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public void save(com.furamam04.entity.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public List<com.furamam04.entity.Service> findAll() {
        return (List<com.furamam04.entity.Service>) serviceRepository.findAll();
    }

    @Override
    public Page<com.furamam04.entity.Service> findAllWithPagingAndSort(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public com.furamam04.entity.Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
