package service.impl;

import model.EducationDegreeModel;
import model.EmployeeModel;
import repository.IEducationDegreeRepository;
import repository.IEmployeeRepository;
import repository.impl.EducationDegreeRepositoryImpl;
import repository.impl.EmployeeRepositoryImpl;
import service.IEducationDegreeService;
import service.IEmployeeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegreeModel> findAll() {
        return educationDegreeRepository.findAll();
    }

}
