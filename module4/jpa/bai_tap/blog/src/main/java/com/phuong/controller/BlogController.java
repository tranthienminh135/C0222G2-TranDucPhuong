package com.phuong.controller;

import com.phuong.model.Blog;
import com.phuong.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/home")
    public String goHome(Model model){
        List<Blog> blogs = this.blogService.getAllBlog();
        model.addAttribute("blogs", blogs);
        return "home";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        this.blogService.deleteBlog(id);
        return "redirect:/blog/home";
    }
    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/blog/home";
    }
    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model){
        Blog blog = this.blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog){
        this.blogService.save(blog);
        return "redirect:/blog/home";
    }
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model){
        Blog blog = this.blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
}
