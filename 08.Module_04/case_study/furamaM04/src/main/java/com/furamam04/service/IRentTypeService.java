package com.furamam04.service;

import com.furamam04.entity.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    RentType findById(Long id);
}
