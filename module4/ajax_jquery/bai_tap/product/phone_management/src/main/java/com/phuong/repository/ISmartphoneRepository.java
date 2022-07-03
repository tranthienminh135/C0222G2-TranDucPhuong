package com.phuong.repository;

import com.phuong.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISmartphoneRepository extends JpaRepository<Smartphone, Integer> {

    @Query(value = " select * from smartphone where model like :searchParam " ,nativeQuery = true,
            countQuery = " select count(*) from (select * from smartphone where model like :searchParam) temp_table ")
    Page<Smartphone> getAllSmartphone(@Param("searchParam") String searchParam, Pageable pageable);
}
