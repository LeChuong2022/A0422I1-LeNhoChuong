package service.impl;

import model.DivisionModel;
import model.EmployeeModel;
import repository.IDivisionRepository;
import repository.IEmployeeRepository;
import repository.impl.DivisionRepositoryImpl;
import repository.impl.EmployeeRepositoryImpl;
import service.IDivisionService;
import service.IEmployeeService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    private IDivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<DivisionModel> findAll() {
        return divisionRepository.findAll();
    }

}
