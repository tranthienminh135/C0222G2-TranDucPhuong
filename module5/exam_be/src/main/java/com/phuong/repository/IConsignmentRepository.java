package com.phuong.repository;

import com.phuong.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsignmentRepository extends JpaRepository<Consignment, Integer> {


    Page<Consignment> findAll(Pageable pageable, String productName);
}
