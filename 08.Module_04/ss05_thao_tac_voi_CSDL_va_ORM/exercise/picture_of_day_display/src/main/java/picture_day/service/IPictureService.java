package picture_day.service;

import picture_day.bean.PictureRate;

import java.util.List;

public interface IPictureService {
    void create(PictureRate p);

    void update(PictureRate p);

    void updateLike(Long id);

    PictureRate findById(long id);

    List<PictureRate> findAll();


}
