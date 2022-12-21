package com.example.blogexpanse.service;

import com.example.blogexpanse.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    void save(Blog n);
    void delete(Long id);
    List<Blog> findAll();
    Blog findById(Long id);

    List<Blog> findAllByCategoryName(String name);

    Page<Blog> findAllWithPaging(Pageable pageable);

    Page<Blog> findAllWithPagingAndSort(Pageable pageable);

    Page<Blog> findAllByContentSummary(String contentSummary, Pageable pageable);
}
