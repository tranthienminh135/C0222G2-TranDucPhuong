package com.phuong.repository.facility;

import com.phuong.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = " select * from facility where name like :searchParam ", nativeQuery = true,
    countQuery = " select * from (select * from facility where name like :searchParam) temp_table ")
    Page<Facility> getAllFacility(Pageable pageable,@Param("searchParam") String searchParam);
}
