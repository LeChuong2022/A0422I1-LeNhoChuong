package repository.impl;

import model.DivisionModel;
import model.EmployeeModel;
import repository.BaseRepository;
import repository.IDivisionRepository;
import repository.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements IDivisionRepository {
    private final String SELECT_ALL = "select * from division;";

    @Override
    public List<DivisionModel> findAll() {
        List<DivisionModel> divisionModelList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");
                DivisionModel divisionModel = new DivisionModel(id, name);
                divisionModelList.add(divisionModel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionModelList;
    }


}
