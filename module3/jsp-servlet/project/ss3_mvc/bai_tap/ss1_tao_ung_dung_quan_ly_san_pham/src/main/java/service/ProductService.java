package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();

    void deleteProductById(int id);

    void addNewProduct(int id, String name, double price, String description);

    void editProductById(int id, String name, double price, String description);
}
