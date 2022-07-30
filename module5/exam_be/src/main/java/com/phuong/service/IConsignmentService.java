package com.phuong.service;

import com.phuong.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IConsignmentService {
    Page<Consignment> findAll(Pageable pageable, String productName);
}
