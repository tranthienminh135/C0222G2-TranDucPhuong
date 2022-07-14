package com.examination.repository;

import com.examination.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = " select * from contract where contract_code = :contractCode ", nativeQuery = true)
    Contract findById(@Param("contractCode") String contractCode);
}
