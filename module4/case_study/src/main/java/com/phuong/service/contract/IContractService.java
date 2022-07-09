package com.phuong.service.contract;

import com.phuong.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> getAllContract(Pageable pageable, String startDate, String endDate);
}
