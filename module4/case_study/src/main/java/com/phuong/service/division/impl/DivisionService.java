package com.phuong.service.division.impl;

import com.phuong.model.employee.Division;
import com.phuong.repository.division.IDivisionRepository;
import com.phuong.service.division.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }
}
