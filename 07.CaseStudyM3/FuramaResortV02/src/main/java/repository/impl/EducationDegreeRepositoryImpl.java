package repository.impl;

import model.EducationDegreeModel;
import model.EmployeeModel;
import repository.BaseRepository;
import repository.IEducationDegreeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements IEducationDegreeRepository {
    private final String SELECT_ALL = "select * from education_degree;";

    @Override
    public List<EducationDegreeModel> findAll() {
        List<EducationDegreeModel> educationDegreeModelList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                EducationDegreeModel educationDegreeModel = new EducationDegreeModel(id, name);
                educationDegreeModelList.add(educationDegreeModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeModelList;
    }

}
