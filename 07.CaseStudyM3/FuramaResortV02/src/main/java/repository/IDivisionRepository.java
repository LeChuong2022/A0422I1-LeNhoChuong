package repository;

import model.DivisionModel;
import model.EmployeeModel;

import java.util.List;

public interface IDivisionRepository {
    List<DivisionModel> findAll();
}
