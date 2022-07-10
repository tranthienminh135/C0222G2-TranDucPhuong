package com.phuong.service.attach_facility.impl;

import com.phuong.model.contract.AttachFacility;
import com.phuong.repository.attach_facility.IAttachFacilityRepository;
import com.phuong.service.attach_facility.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IAttachFacility implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return this.attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findById(String id) {
        return this.attachFacilityRepository.findById(Integer.valueOf(id)).orElse(null);
    }
}
