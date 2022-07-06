package com.phuong.service.rent_type.impl;

import com.phuong.model.facility.RentType;
import com.phuong.repository.rent_type.IRentTypeRepository;
import com.phuong.service.rent_type.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
