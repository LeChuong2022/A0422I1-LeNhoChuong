package com.example.blogexpanse.controller.restController;

import com.example.blogexpanse.entity.Blog;
import com.example.blogexpanse.entity.Category;
import com.example.blogexpanse.service.IBlogService;
import com.example.blogexpanse.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("list")
    public ResponseEntity<List<Blog>> getListBlog() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @GetMapping("category/{categoryName}")
    public ResponseEntity<List<Blog>> getListBlogByCategory(@PathVariable("categoryName") String categoryName) {
        List<Blog> blogs = blogService.findAllByCategoryName(categoryName);
        if (blogs.size() == 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

}
