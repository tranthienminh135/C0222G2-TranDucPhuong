package com.phuong.controller.contract;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phuong.model.contract.*;
import com.phuong.service.attach_facility.IAttachFacilityService;
import com.phuong.service.contract.IContractService;
import com.phuong.service.contract_detail.IContractDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ContractPageAndAttachFacilityListDto> getAllContract(@PageableDefault(20) Pageable pageable,
                                                                               Optional<String> startDateValue, Optional<String> endDateValue) {
        String startDate = startDateValue.orElse("1000-01-01");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = endDateValue.orElse("3000-01-01");
        Page<Contract> contractPage = this.contractService.getAllContract(pageable, startDate, endDate);
        List<AttachFacility> attachFacilityList = this.attachFacilityService.findAll();
        ContractPageAndAttachFacilityListDto contractPageAndAttachFacilityListDTO = new ContractPageAndAttachFacilityListDto();
        contractPageAndAttachFacilityListDTO.setContractPageDto(contractPage);
        contractPageAndAttachFacilityListDTO.setAttachFacilityListDto(attachFacilityList);
        return new ResponseEntity<>(contractPageAndAttachFacilityListDTO, HttpStatus.OK);
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
    @GetMapping("/attach-facility/{id}")
    public ResponseEntity<AttachFacility> findAttachFacilityById(@PathVariable String id) {
        AttachFacility attachFacility = this.attachFacilityService.findById(id);
        return new ResponseEntity<>(attachFacility, HttpStatus.OK);
    }

    @PostMapping("/alter-attach-facility")
    public ResponseEntity<Void> alterAttachFacility (@RequestBody ContractDetailDto contractDetailDto) {
        Contract contract = this.contractService.findByAttachFacilityIdAndContractId(contractDetailDto.getContract().getId(),
                contractDetailDto.getAttachFacility().getId());
        if (contract == null) {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            this.contractDetailService.save(contractDetail);
        } else {
            this.contractDetailService.updateQuantity(contractDetailDto.getQuantity(),
                    contractDetailDto.getContract().getId(), contractDetailDto.getAttachFacility().getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
        return new ResponseEntity<>(this.contractService.save(contract), HttpStatus.OK);
    }

    @PostMapping("/create-contract-detail")
    public ResponseEntity<Void> createContractDetail(@RequestBody ContractDetail contractDetail) {
        this.contractDetailService.save(contractDetail);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
