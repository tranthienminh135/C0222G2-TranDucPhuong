package com.phuong.service.contract_detail;

import com.phuong.model.contract.ContractDetail;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();
}
