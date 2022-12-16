package blog.repository;

import blog.bean.Blog;

import java.util.List;

public interface IBlogRepository {
    void save(Blog blog);

    Blog findById(Long id);

    List<Blog> findByAll();

    void remove(Long id);

    Blog detail(Long id);
}
