package com.phuong.service.impl;

import com.phuong.model.Product;
import com.phuong.model.ProductType;
import com.phuong.repository.IProductRepository;
import com.phuong.repository.IProductTypeRepository;
import com.phuong.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IProductTypeRepository productTypeRepository;

    @Override
    public List<Product> findAllProduct() {
        return this.productRepository.findAll();
    }

    @Override
    public List<ProductType> findAllProductType() {
        return this.productTypeRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        this.productRepository.delete(this.productRepository.getById(id));
    }
}
