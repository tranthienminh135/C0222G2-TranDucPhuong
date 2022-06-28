package com.phuong.controller;

import com.phuong.model.Book;
import com.phuong.model.DetailBook;
import com.phuong.service.IBookService;
import com.phuong.service.IDetailBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IDetailBookService detailBookService;

    @GetMapping("")
    public String goHome(Model model){
        List<Book> bookList = this.bookService.findAll();
        model.addAttribute("books", bookList);
        return "home";
    }

    @GetMapping("/create")
    public String goCreate(Model model){
        model.addAttribute("book", new Book());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("book") Book book, Model model){
        this.bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/show-detail")
    public String showDetail(@RequestParam Optional<Integer> id, Model model){
        if (id.isPresent()) {
            this.bookService.borrowBook(id.get());
        }
        List<DetailBook> detailBooks = this.detailBookService.findAll();
        model.addAttribute("detailBooks", detailBooks);
        return "borrow";
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam Integer id, Model model){
        this.bookService.setQuantity(id);
        this.detailBookService.setStatus(id);
        return "redirect:/show-detail";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam Integer bookCode) throws Exception {
        this.detailBookService.returnBook(bookCode);
        return "redirect:/";
    }
}
