package blog.service.impl;

import blog.bean.Blog;
import blog.repository.IBlogRepository;
import blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        Date date = new Date();
        blog.setDatePublish(date);
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findByAll() {
        return blogRepository.findByAll();
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }

    @Override
    public Blog detail(Long id) {
        return blogRepository.detail(id);
    }
}
