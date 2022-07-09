package com.phuong.repository.contract;

import com.phuong.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = " SELECT * FROM contract where end_date between :startDateValue and :endDateValue ",
            nativeQuery = true, countQuery = " SELECT * FROM contract where end_date between :startDateValue and :endDateValue ")
    Page<Contract> getAllContract(Pageable pageable, @Param("startDateValue") String startDateValue, @Param("endDateValue") String endDateValue);
}
