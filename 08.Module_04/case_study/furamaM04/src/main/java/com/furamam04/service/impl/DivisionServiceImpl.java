package com.furamam04.service.impl;

import com.furamam04.entity.Division;
import com.furamam04.repository.IDivisionRepository;
import com.furamam04.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return (List<Division>) divisionRepository.findAll();
    }

    @Override
    public Division findById(Long id) {
        return divisionRepository.findById(id).orElse(null);
    }
}
