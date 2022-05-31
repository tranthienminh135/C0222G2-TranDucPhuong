package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void deleteProductById(int id);

    void addNewProduct(Product product);

    void editProductById(int id, String name, double price, String description);
}
