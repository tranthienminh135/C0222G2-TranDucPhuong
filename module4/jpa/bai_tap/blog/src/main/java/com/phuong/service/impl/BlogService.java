package com.phuong.service.impl;

import com.phuong.model.Blog;
import com.phuong.repository.IBlogRepository;
import com.phuong.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public Page<Blog> getAllBlog(String searchValue ,Pageable pageable) {
        return this.blogRepository.getAllBlog("%" + searchValue + "%" ,pageable);
    }

    @Override
    public void deleteBlog(int id) {
        this.blogRepository.deleteBlog(id);
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Blog getBlog(int id) {
        return this.blogRepository.getBlog(id);
    }
}
