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
    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);
    }

    @Override
    public void edit(Product product) {
        productRepository.edit(product);
    }

    @Override
    public List<Product> getProductByName(String search) {
        return productRepository.getProductByName(search);
    }
}
