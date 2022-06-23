package com.phuong.service;

import com.phuong.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAllBlog(String searchValue, Pageable pageable);

    void deleteBlog(int id);

    void save(Blog blog);

    Blog getBlog(int id);
}
