package blog.repository.impl;

import blog.bean.Blog;
import blog.repository.IBlogRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements IBlogRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null) {
            entityManager.merge(blog);
        } else {
            entityManager.persist(blog);
        }

    }

    @Override
    public Blog findById(Long id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b where b.id =:id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Blog> findByAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b", Blog.class);
        return query.getResultList();
    }

    @Override
    public void remove(Long id) {
        Blog blog = findById(id);
        if (blog != null){
            entityManager.remove(blog);
        }
    }

    @Override
    public Blog detail(Long id) {
        return findById(id);
    }
}
