package com.phuong.service.impl;

import com.phuong.model.Consignment;
import com.phuong.repository.IConsignmentRepository;
import com.phuong.service.IConsignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ConsignmentService implements IConsignmentService {

    @Autowired
    private IConsignmentRepository consignmentRepository;

    @Override
    public Page<Consignment> findAll(Pageable pageable, String productName, String endDate, String dateInStart, String dateInEnd) {
        return this.consignmentRepository.findAll(pageable, "%" + productName + "%", "%" + endDate + "%", dateInStart, dateInEnd);
    }

    @Override
    public void save(Consignment consignment) {
        this.consignmentRepository.save(consignment);
    }

    @Override
    public void delete(Integer id) {
        this.consignmentRepository.delete(this.consignmentRepository.getById(id));
    }

    @Override
    public Consignment findById(Integer id) {
        return this.consignmentRepository.findById(id).orElse(null);
    }
}
