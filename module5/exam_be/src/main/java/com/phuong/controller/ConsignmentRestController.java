package com.phuong.controller;

import com.phuong.model.Consignment;
import com.phuong.service.IConsignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class ConsignmentRestController {

    @Autowired
    private IConsignmentService consignmentService;

    public ResponseEntity<Page<Consignment>> getAllConsignment(@PageableDefault(5) Pageable pageable,
                                                               @RequestParam(required = false) String productName) {
        Page<Consignment> consignmentPage = this.consignmentService.findAll(pageable, productName);
    }
}
