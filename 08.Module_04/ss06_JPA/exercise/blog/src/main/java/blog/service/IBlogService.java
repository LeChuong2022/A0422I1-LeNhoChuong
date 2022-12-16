package blog.service;

import blog.bean.Blog;

import java.util.List;

public interface IBlogService {
    void save(Blog blog);

    Blog findById(Long id);

    List<Blog> findByAll();

    void remove(Long id);

    Blog detail(Long id);
}
