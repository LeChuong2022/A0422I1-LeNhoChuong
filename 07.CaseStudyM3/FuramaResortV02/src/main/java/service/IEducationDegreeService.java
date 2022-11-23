package service;

import model.EducationDegreeModel;
import model.EmployeeModel;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegreeModel> findAll();

}
