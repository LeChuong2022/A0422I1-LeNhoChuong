package service.impl;

import model.EmployeeModel;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.IEmployeeService;
import validate.Validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<EmployeeModel> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Map<String, String> save(EmployeeModel employee) {
        // kiểm tra dữ liệu
        Map<String, String> errorMap = new HashMap<>();
        if ("".equals(employee.getEmail())) {
            errorMap.put("email", "Email không được để trống");
        } else if (!Validation.checkEmail(employee.getEmail())) {
            errorMap.put("email", "Email không đúng định dạng");
        }
        if (!Validation.checkPhone(employee.getPhone())) {
            errorMap.put("phone", "Phone không đúng định dạng");
        }
        if (!Validation.checkIdCard(employee.getIdCard())) {
            errorMap.put("idCard", "idCard không đúng định dạng");
        }
        if (employee.getSalary() < 0) {
            errorMap.put("salary", "Salary phải lớn hơn 0");
        }
        // nêu không có lỗi thì cho lưu vào db
        if (errorMap.isEmpty()) {
            employeeRepository.save(employee);
        }
        return errorMap;
    }

    @Override
    public boolean edit(EmployeeModel employee) {
        return employeeRepository.edit(employee);
    }

    @Override
    public boolean delete(int id) {
        return employeeRepository.delete(id);
    }

    @Override
    public EmployeeModel getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }  // làm theo thẻ edit

    @Override
    public List<EmployeeModel> search(String searchName, String searchUser, String searchPositionId, String searchEducationDegreeId) {
        return employeeRepository.search(searchName, searchUser, searchPositionId, searchEducationDegreeId);
    }

    @Override
    public List<EmployeeModel> sort(String sortType) {
        return employeeRepository.sort(sortType);
    }
}
