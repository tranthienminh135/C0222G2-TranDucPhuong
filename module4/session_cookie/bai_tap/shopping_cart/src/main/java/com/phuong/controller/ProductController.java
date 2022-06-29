package com.phuong.controller;

import com.phuong.model.Product;
import com.phuong.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes(value = "listProductCart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("listProductCart")
    public List<Product> listProductCart() {
        return new ArrayList<>();
    }

    @GetMapping("")
    public String goHome(Model model) {
        List<Product> products = this.productService.findAll();
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "home";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("product") Product product) {
        this.productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@SessionAttribute("listProductCart") List<Product> listProductCart,
                            RedirectAttributes redirectAttributes,
                            @RequestParam("id") int id) {
        Product product = this.productService.getById(id);
        listProductCart.add(product);
        redirectAttributes.addFlashAttribute("msg", "Add product " + product.getName() + " success!");
        return "redirect:/";
    }

    @GetMapping("/show-cart")
    public String showCart(@SessionAttribute("listProductCart") List<Product> listProductCart, Model model) {
        model.addAttribute("products", listProductCart);
        return "cart-list";
    }

    @GetMapping("/buy")
    public String buyProduct(@SessionAttribute("listProductCart") List<Product> listProductCart){
        listProductCart.clear();
        return "redirect:/show-cart";
    }

}
