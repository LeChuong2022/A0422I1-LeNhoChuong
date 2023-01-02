package com.example.blogexpanse.service.impl;

import com.example.blogexpanse.entity.Blog;
import com.example.blogexpanse.repository.IBlogRepository;
import com.example.blogexpanse.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public void save(Blog n) {
        Date date = new Date();
        n.setDatePublish(date);
        blogRepository.save(n);
    }

    @Override
    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAllByCategoryName(String name) {
        return blogRepository.findAllByCategoryName(name);
    }

    @Override
    public Page<Blog> findAllWithPaging(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllWithPagingAndSort(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByTittle(String title, Pageable pageable) {
        return blogRepository.findAllByTitle(title, pageable);
    }
}
