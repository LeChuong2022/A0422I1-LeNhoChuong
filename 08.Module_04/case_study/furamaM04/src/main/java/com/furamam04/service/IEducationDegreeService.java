package com.furamam04.service;

import com.furamam04.entity.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();

    EducationDegree findById(Long id);
}
