package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();

    void saveProduct(Product product);

    void removeProduct(Product product);
}
