package com.phuong.service;

import com.phuong.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void save(Product product);

    Product findById(int id);

    void delete(int id);

    void edit(Product product);

    List<Product> getProductByName(String search);
}
