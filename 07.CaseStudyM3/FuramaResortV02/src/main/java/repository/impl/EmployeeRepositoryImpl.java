package repository.impl;

import model.EmployeeModel;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {
    private final String SELECT_ALL = "select * from employee;";
    private final String INSERT_EMPLOYEE = "insert into employee (employee_name, employee_birthday, employee_id_card," +
            "employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username)" +
            "values (?,?,?,?,?,?,?,?,?,?,?)";
    private final String EDIT_EMPLOYEE = "update employee set employee_name = ?, employee_birthday = ?, employee_id_card = ?," +
            "employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, position_id = ?, education_degree_id = ?, division_id = ?" +
            " where employee_id = ?";
    private final String DELETE_BY_ID = "delete from employee where employee_id = ?;\n";
    private final String SELECT_EMPLOYEE_BY_ID_STORE = "call get_employee_by_id(?);";
    private final String SEARCH_EMPLOYEE = "select * from employee where employee_name like ? and username like ? and position_id like ? and education_degree_id like ?;";

    private static final String SORT_BY_NAME = "select * from employee order by employee_name asc;";
    private static final String SORT_BY_USERNAME = "select * from employee order by username asc;";
    private static final String SORT_BY_SALARY = "select * from employee order by employee_salary asc;";


    @Override
    public List<EmployeeModel> findAll() {
        List<EmployeeModel> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                Date birthday = resultSet.getDate("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("username");
                EmployeeModel employee = new EmployeeModel(id, name, birthday, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, userName);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean save(EmployeeModel employee) {
        // Ket noi database
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_EMPLOYEE); // dùng preparestatement để excute câu query
            ps.setString(1, employee.getName());
            ps.setDate(2, employee.getBirthday());
            ps.setString(3, employee.getIdCard());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getAddress());
            ps.setInt(8, employee.getPositionId());
            ps.setInt(9, employee.getEducationDegreeId());
            ps.setInt(10, employee.getDivisionId());
            ps.setString(11, employee.getUserName());

            return ps.executeUpdate() > 0; // Thêm sửa xóa dùng excuteUpdate (trả lại số hàng bị thay đổi)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean edit(EmployeeModel employee) {
        // Ket noi database
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(EDIT_EMPLOYEE); // dùng preparestatement để excute câu query
            ps.setString(1, employee.getName());
            ps.setDate(2, employee.getBirthday());
            ps.setString(3, employee.getIdCard());
            ps.setDouble(4, employee.getSalary());
            ps.setString(5, employee.getPhone());
            ps.setString(6, employee.getEmail());
            ps.setString(7, employee.getAddress());
            ps.setInt(8, employee.getPositionId());
            ps.setInt(9, employee.getEducationDegreeId());
            ps.setInt(10, employee.getDivisionId());
            ps.setInt(11, employee.getId());            // so với create sửa thì thêm cái này để where
//            ps.setString(11, employee.getUserName());

            return ps.executeUpdate() > 0; // Thêm sửa xóa dùng excuteUpdate (trả lại số hàng bị thay đổi)
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public EmployeeModel getEmployee(int id) {
        EmployeeModel employeeModel = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement callableStatement = connection.prepareCall(SELECT_EMPLOYEE_BY_ID_STORE);
            callableStatement.setInt(1, id);
            ResultSet rs = callableStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("employee_name"); // employee_name theo database
                Date birthday = Date.valueOf(rs.getString("employee_birthday")); // employee_name theo database
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("username");
                employeeModel = new EmployeeModel(id, name, birthday, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, userName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeModel;
    }

    @Override
    public List<EmployeeModel> search(String searchName, String searchUser, String searchPositionId, String searchEducationDegreeId) {
        EmployeeModel employeeModel = null;
        List<EmployeeModel> employeeModelList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement pr = connection.prepareStatement(SEARCH_EMPLOYEE);
            pr.setString(1, "%" + searchName + "%");
            pr.setString(2, "%" + searchUser + "%");
            pr.setString(3, "%" + searchPositionId + "%");
            pr.setString(4, "%" + searchEducationDegreeId + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                // phan nay giống y findAll
                int id = rs.getInt("employee_id");
                String name = rs.getString("employee_name"); // employee_name theo database
                Date birthday = Date.valueOf(rs.getString("employee_birthday")); // employee_name theo database
                String idCard = rs.getString("employee_id_card");
                Double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("username");
                employeeModel = new EmployeeModel(id, name, birthday, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, userName);
                employeeModelList.add(employeeModel);
                // phan nay giống y findAll

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeModelList;
    }

    @Override
    public List<EmployeeModel> sort(String typeSort) {
        EmployeeModel employeeModel = null;
        List<EmployeeModel> employeeModelList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement pr = null;
        try {
            switch (typeSort) {
                case "id":
                    pr = connection.prepareStatement(SELECT_ALL); // mặc định xếp từ trên xuống dưới
                    break;
                case "name":
                    pr = connection.prepareStatement(SORT_BY_NAME);
                    break;
                case "salary":
                    pr = connection.prepareStatement(SORT_BY_SALARY);
                    break;
                case "userName":
                    pr = connection.prepareStatement(SORT_BY_USERNAME);
                    break;
                default:
                    pr = connection.prepareStatement(SELECT_ALL);
                    break;
            }
            ResultSet resultSet = pr.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                Date birthday = resultSet.getDate("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String userName = resultSet.getString("username");
                EmployeeModel employee = new EmployeeModel(id, name, birthday, idCard, phone, email, address, salary, positionId, educationDegreeId, divisionId, userName);
                employeeModelList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeModelList;
    }

}
