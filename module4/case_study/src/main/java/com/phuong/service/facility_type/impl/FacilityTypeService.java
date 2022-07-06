package com.phuong.service.facility_type.impl;

import com.phuong.model.facility.FacilityType;
import com.phuong.repository.facility_type.IFacilityTypeRepository;
import com.phuong.service.facility_type.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return this.facilityTypeRepository.findAll();
    }
}
