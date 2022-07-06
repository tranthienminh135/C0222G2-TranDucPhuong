package com.phuong.service.facility.impl;

import com.phuong.model.facility.Facility;
import com.phuong.repository.facility.IFacilityRepository;
import com.phuong.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> getAllFacility(Pageable pageable, String searchParam) {
        return this.facilityRepository.getAllFacility(pageable, "%" + searchParam + "%");
    }

    @Override
    public void save(Facility facility) {
        this.facilityRepository.save(facility);
    }

    @Override
    public Facility findById(Integer idEdit) {
        return this.facilityRepository.getById(idEdit);
    }

    @Override
    public void delete(Integer idDelete) {
        this.facilityRepository.delete(this.facilityRepository.getById(idDelete));
    }
}
