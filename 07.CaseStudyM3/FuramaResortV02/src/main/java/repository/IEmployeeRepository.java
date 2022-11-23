package repository;

import model.EmployeeModel;

import java.util.List;

public interface IEmployeeRepository {
    List<EmployeeModel> findAll(); //

    boolean save(EmployeeModel employee); //

    boolean delete(int id); //

    EmployeeModel getEmployee(int id); //

    boolean edit(EmployeeModel employee);  // làm theo thẻ edit

    List<EmployeeModel> search(String searchName, String searchUser, String searchPositionId, String searchEducationDegreeId);

    List<EmployeeModel> sort(String sortType);

}


