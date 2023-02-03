package com.furamam04.service;

import com.furamam04.entity.Position;

import java.util.List;

public interface IPositionService {
    List <Position> findAll();

    Position findById(Long id);
}
