package com.phuong.service.impl;

import com.phuong.model.Product;
import com.phuong.repository.IProductRepository;
import com.phuong.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product getById(int id) {
        return this.productRepository.getById(id);
    }
}
