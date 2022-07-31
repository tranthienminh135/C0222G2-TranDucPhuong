package com.phuong.controller;

import com.phuong.model.Consignment;
import com.phuong.service.IConsignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest/consignment")
public class ConsignmentRestController {

    @Autowired
    private IConsignmentService consignmentService;

    @GetMapping("/page")
    public ResponseEntity<Page<Consignment>> getAllConsignment(@PageableDefault(8) Pageable pageable,
                                                               Optional<String> productNameSearch,
                                                               Optional<String> endDateSearch,
                                                               Optional<String> dateInStartSearch,
                                                               Optional<String> dateInEndSearch) {

        String productName = productNameSearch.orElse("");
        String endDate = endDateSearch.orElse("");
        String dateInStart = dateInStartSearch.orElse("0001-01-01");
        String dateInEnd = dateInEndSearch.orElse("8000-01-01");

        if (productName.equals("null")) {
            productName = "";
        }
        if (endDate.equals("null")) {
            endDate = "";
        }
        if (dateInStart.equals("null")) {
            dateInStart = "0001-01-01";
        }
        if (dateInEnd.equals("null")) {
            dateInEnd = "8000-01-01";
        }
        Page<Consignment> consignmentPage = this.consignmentService.findAll(pageable, productName, endDate, dateInStart, dateInEnd);
        if (consignmentPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(consignmentPage, HttpStatus.OK);
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Consignment> findByName(@PathVariable Integer id) {
        Consignment consignment = this.consignmentService.findById(id);
        return new ResponseEntity<>(consignment, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createConsignment(@RequestBody Consignment consignment) {
        this.consignmentService.save(consignment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{idDelete}")
    public ResponseEntity<Void> deleteConsignment(@PathVariable Integer idDelete) {
        this.consignmentService.delete(idDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateConsignment(@RequestBody Consignment consignment) {
        this.consignmentService.save(consignment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
