package com.example.blogexpanse.controller.restController;

import com.example.blogexpanse.entity.Category;
import com.example.blogexpanse.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Category>> getListCategory(){
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
