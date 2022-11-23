package service.impl;

import model.PositionModel;
import repository.IPositionRepository;
import repository.impl.PositionRepositoryImpl;
import service.IPositionService;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<PositionModel> findAll() {
        return positionRepository.findAll();
    }

}
