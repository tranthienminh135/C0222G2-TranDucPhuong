package com.phuong.service;

import com.phuong.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getAllBlog();

    void deleteBlog(int id);

    void save(Blog blog);

    Blog getBlog(int id);
}
