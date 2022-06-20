package com.phuong.repository.impl;

import com.phuong.model.Product;
import com.phuong.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product("P123", "Iphone 5", 100000d, "128GB", "Apple"));
        products.add(new Product("P124", "Iphone 6", 100000d, "256GB", "Apple"));
        products.add(new Product("P125", "Iphone 7", 100000d, "64GB", "Apple"));
        products.add(new Product("P126", "Iphone 8", 100000d, "32GB", "Apple"));
        products.add(new Product("P127", "Iphone X", 100000d, "1TB", "Apple"));
    }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(String id) {
        for (Product product: products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        for (Product product: products) {
            if (product.getId().equals(id)) {
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public void edit(Product product) {
        for (Product p: products) {
            if (p.getId().equals(product.getId())) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDescription(product.getDescription());
                p.setManufacturer(product.getManufacturer());
                break;
            }
        }
    }

    @Override
    public List<Product> getProductByName(String search) {
        List<Product> productList = new ArrayList<>();
        for (Product product: products) {
            if (product.getName().contains(search)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
