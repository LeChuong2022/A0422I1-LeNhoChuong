package com.furamam04.service.impl;

import com.furamam04.entity.RentType;
import com.furamam04.repository.IRentTypeRepository;
import com.furamam04.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return (List<RentType>) rentTypeRepository.findAll();
    }

    @Override
    public RentType findById(Long id) {
        return rentTypeRepository.findById(id).orElse(null);
    }
}
