package com.phuong.controller;

import com.phuong.model.Blog;
import com.phuong.service.IBlogService;
import com.phuong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/home")
    public String goHome
            (@PageableDefault(value = 5) Pageable pageable,
             Model model,
             @RequestParam Optional<String> searchParam
             ) {
        String searchValue = searchParam.orElse("");
        Page<Blog> blogs = this.blogService.getAllBlog(searchValue ,pageable);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("blogs", blogs);
        return "home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        this.blogService.deleteBlog(id);
        return "redirect:/blog/home";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog) {
        this.blogService.save(blog);
        return "redirect:/blog/home";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Blog blog = this.blogService.getBlog(id);
        model.addAttribute("blog", blog);
        model.addAttribute("categories", this.categoryService.getAllCategory());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog) {
        this.blogService.save(blog);
        return "redirect:/blog/home";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable int id, Model model) {
        Blog blog = this.blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "detail";
    }
}
