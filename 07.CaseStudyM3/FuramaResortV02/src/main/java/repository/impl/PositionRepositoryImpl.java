package repository.impl;

import model.PositionModel;
import repository.BaseRepository;
import repository.IPositionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {
    private final String SELECT_ALL = "select * from position;";

    @Override
    public List<PositionModel> findAll() {
        List<PositionModel> positionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("position_name");
                PositionModel position = new PositionModel(id, name);
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}
