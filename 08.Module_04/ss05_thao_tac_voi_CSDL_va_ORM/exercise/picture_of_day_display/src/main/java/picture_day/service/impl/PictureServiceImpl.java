package picture_day.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import picture_day.bean.PictureRate;
import picture_day.repository.IPictureRepository;
import picture_day.service.IPictureService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public void create(PictureRate p) {
        long millis = System.currentTimeMillis();
        p.setDay(new java.sql.Date(millis));
        pictureRepository.create(p);
    }

    @Override
    public void update(PictureRate p) {
        pictureRepository.update(p);
    }

    @Override
    public void updateLike(Long id) {
        PictureRate p = pictureRepository.findById(id);
        if (p.getLikeNumber() == null) {
            p.setLikeNumber(1L);
        } else{
            p.setLikeNumber(p.getLikeNumber()+1);
        }
        pictureRepository.update(p);
    }

    @Override
    public PictureRate findById(long id) {
        return pictureRepository.findById(id);
    }

    @Override
    public List<PictureRate> findAll() {
        return pictureRepository.findAll();
    }
}
