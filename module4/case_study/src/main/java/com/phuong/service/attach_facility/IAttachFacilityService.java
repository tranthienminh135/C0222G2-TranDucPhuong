package com.phuong.service.attach_facility;

import com.phuong.model.contract.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAll();

    AttachFacility findById(String id);
}
