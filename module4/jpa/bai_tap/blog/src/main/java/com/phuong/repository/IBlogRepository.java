package com.phuong.repository;

import com.phuong.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = " select * from blog where title like :searchValue ", nativeQuery = true,
    countQuery = " select count(*) from (select * from blog where title like :searchValue ) temp_table ")
    Page<Blog> getAllBlog(@Param("searchValue") String searchValue ,Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = " delete from blog b " +
            " where b.id = :id ", nativeQuery = true)
    void deleteBlog(@Param("id") int id);

    @Query(value = " select * " +
            " from blog b where b.id = :id", nativeQuery = true)
    Blog getBlog(@Param("id") int id);
}
