package com.phuong.controller.contract;

import com.phuong.model.contract.AttachFacility;
import com.phuong.model.contract.Contract;
import com.phuong.model.contract.ContractDetail;
import com.phuong.service.attach_facility.IAttachFacilityService;
import com.phuong.service.contract.IContractService;
import com.phuong.service.contract_detail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/rest")
public class ContractRestController {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachFacilityService attachFacilityService;

    @GetMapping("/contract")
    public ResponseEntity<Page<Contract>> getAllContract(@PageableDefault(5) Pageable pageable,
                                                         Optional<String> startDateValue, Optional<String> endDateValue) {
        String startDate = startDateValue.orElse("1970-01-01");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = endDateValue.orElse(simpleDateFormat.format(new Date()));
        Page<Contract> contractPage = this.contractService.getAllContract(pageable, startDate, endDate);
        return new ResponseEntity<>(contractPage, HttpStatus.OK);
    }


    @GetMapping("/contract-detail")
    public ResponseEntity<List<ContractDetail>> getAllContractDetail() {
        List<ContractDetail> contractDetailPage = this.contractDetailService.findAll();
        return new ResponseEntity<>(contractDetailPage, HttpStatus.OK);
    }

    @GetMapping("/attach-facility")
    public ResponseEntity<List<AttachFacility>> getAllAttachFacility() {
        List<AttachFacility> attachFacilityList = this.attachFacilityService.findAll();
        return new ResponseEntity<>(attachFacilityList, HttpStatus.OK);
    }
}
