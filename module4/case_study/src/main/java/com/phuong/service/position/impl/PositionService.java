package com.phuong.service.position.impl;

import com.phuong.model.employee.Position;
import com.phuong.repository.position.IPositionRepository;
import com.phuong.service.position.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return this.positionRepository.findAll();
    }
}
