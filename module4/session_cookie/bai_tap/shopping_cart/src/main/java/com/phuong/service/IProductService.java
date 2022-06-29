package com.phuong.service;

import com.phuong.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product getById(int id);
}
