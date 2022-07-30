package com.phuong.repository;

import com.phuong.model.Consignment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IConsignmentRepository extends JpaRepository<Consignment, Integer> {

    @Query(value = " select consignment.* from consignment " +
            " join product on product.id = consignment.product_id " +
            " where product.name like :productName and date_end like :endDate and date_in between :dateInStart and :dateInEnd ", nativeQuery = true,
            countQuery = " select count(*) from (select consignment.* from consignment " +
                    " join product on product.id = consignment.product_id " +
                    " where product.name like :productName and date_end like :endDate and date_in between :dateInStart and :dateInEnd ) temp_table ")
    Page<Consignment> findAll(Pageable pageable, @Param("productName") String productName,
                              @Param("endDate") String endDate, String dateInStart, String dateInEnd);
}
