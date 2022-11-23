package repository;

import model.PositionModel;

import java.util.List;

public interface IPositionRepository {
    List<PositionModel> findAll();

}
