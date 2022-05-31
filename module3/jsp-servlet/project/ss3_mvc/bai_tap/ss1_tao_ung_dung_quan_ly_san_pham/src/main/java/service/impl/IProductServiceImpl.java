package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class IProductServiceImpl implements IProductService {
    private IProductRepository productRepository = new ProductRepositoryImpl();
    private List<Product> products = this.productRepository.getAllProduct();

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    @Override
    public void deleteProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                productRepository.removeProduct(product);
                break;
            }
        }
    }

    @Override
    public void addNewProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void editProductById(int id, String name, double price,  String description) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
            }
        }
    }

}
