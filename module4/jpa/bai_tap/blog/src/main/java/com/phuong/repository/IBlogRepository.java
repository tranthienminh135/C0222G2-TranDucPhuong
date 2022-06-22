package com.phuong.repository;

import com.phuong.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = " select * " +
            " from blog ", nativeQuery = true)
    List<Blog> getAllBlog();

    @Modifying
    @Transactional
    @Query(value = " delete from blog b " +
            " where b.id = :id ", nativeQuery = true)
    void deleteBlog(@Param("id") int id);

    @Query(value = " select * " +
            " from blog b where b.id = :id", nativeQuery = true)
    Blog getBlog(@Param("id") int id);
}
