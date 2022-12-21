package com.example.blogexpanse.service;

import com.example.blogexpanse.entity.Category;

import java.util.List;

public interface ICategoryService {
    void save(Category c);
    void delete(Long id);
    List<Category> findAll();
    Category findById(Long id);
}
