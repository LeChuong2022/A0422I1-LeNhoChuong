package picture_day.repository;

import picture_day.bean.PictureRate;

import java.util.List;

public interface IPictureRepository {
    void create(PictureRate p);

    void update(PictureRate p);

    PictureRate findById(long id);

    List<PictureRate> findAll();
}
