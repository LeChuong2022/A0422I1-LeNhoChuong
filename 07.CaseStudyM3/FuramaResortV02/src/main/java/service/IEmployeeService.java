package service;

import model.EmployeeModel;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<EmployeeModel> findAll(); //

    Map<String, String> save(EmployeeModel employee);
    boolean edit(EmployeeModel employee);//

    boolean delete(int id); //

    EmployeeModel getEmployee(int id); // làm theo thẻ edit

    List<EmployeeModel> search(String searchName, String searchUser, String searchPositionId, String searchEducationDegreeId);

    List<EmployeeModel> sort(String sortType);

}
