package repository;

import model.EducationDegreeModel;

import java.util.List;

public interface IEducationDegreeRepository {
    List<EducationDegreeModel> findAll();

}
