package com.furamam04.service;

import com.furamam04.entity.Division;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();

    Division findById(Long id);
}
