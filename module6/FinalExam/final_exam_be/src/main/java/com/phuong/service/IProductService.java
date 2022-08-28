package com.phuong.service;

import com.phuong.model.Product;
import com.phuong.model.ProductType;

import java.util.List;

public interface IProductService {
    List<Product> findAllProduct();

    List<ProductType> findAllProductType();

    void save(Product product);

    void delete(Integer id);
}
