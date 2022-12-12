package picture_day.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import picture_day.bean.PictureRate;
import picture_day.repository.IPictureRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PictureRepositoryImpl implements IPictureRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void create(PictureRate p) {
        entityManager.persist(p);
    }

    @Override
    public void update(PictureRate p) {
        entityManager.merge(p);
    }

    @Override
    public PictureRate findById(long id) {
        return entityManager.find(PictureRate.class, id);
    }

    @Override
    public List<PictureRate> findAll() {
        return entityManager.createQuery("select p from PictureRate p where p.day = current_date ").getResultList();
    }
}
