package com.example.blogexpanse.restController;

import com.example.blogexpanse.entity.Blog;
import com.example.blogexpanse.service.IBlogService;
import com.example.blogexpanse.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "/search")
    public ResponseEntity<List<Blog>> list(Model model, @RequestParam(value = "search", defaultValue = "") String search) {
        List<Blog> blogList = "".equals(search) ? blogService.findAll() : blogService.findAllByTittle(search);
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<Blog>> allBlogs(){
        return new ResponseEntity<>(blogService.findAllOrderByDatePublish(), HttpStatus.OK);
    }
}
