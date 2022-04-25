package ss16_binary_file_serialization.bai_tap.product_manager.service;

import ss16_binary_file_serialization.bai_tap.product_manager.model.Product;

public interface ProductService extends IService<Product> {
    void displayProduct();

    void addNewProduct();

    void deleteProduct();

    void searchProductByName();

    void editProductByName();

    void ascendingSortProductByPrice();

    void descendingSortProductByPrice();
}
