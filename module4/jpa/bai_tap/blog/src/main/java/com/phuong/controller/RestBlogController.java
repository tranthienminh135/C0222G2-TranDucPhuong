package com.phuong.controller;

import com.phuong.model.Blog;
import com.phuong.model.Category;
import com.phuong.service.IBlogService;
import com.phuong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest-blog")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogs = this.blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/category")
        public ResponseEntity<List<Category>> getListCategory(){
        List<Category> categories = this.categoryService.getAllCategory();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    @GetMapping("/blog-category/{id}")
    public ResponseEntity<List<Blog>> getBlogOfCategory(@PathVariable int id){
        List<Blog> blogs = this.categoryService.findById(id).getBlogs();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> getBlog(@PathVariable int id){
        Blog blog = this.blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
