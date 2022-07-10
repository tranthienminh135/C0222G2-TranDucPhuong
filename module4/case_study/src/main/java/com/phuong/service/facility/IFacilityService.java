package com.phuong.service.facility;

import com.phuong.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> getAllFacility(Pageable pageable, String searchParam);

    void save(Facility facility);

    Facility findById(Integer idEdit);

    void delete(Integer idDelete);

    List<Facility> findAll();
}
