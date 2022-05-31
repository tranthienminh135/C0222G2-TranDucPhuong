package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Car", 1000d, "Description of Car"));
        products.add(new Product(2, "Truck", 2000d, "Description of Truck"));
        products.add(new Product(3, "Bike", 3000d, "Description of Bike"));
        products.add(new Product(4, "Boat", 4000d, "Description of Boat"));
        products.add(new Product(5, "Ship", 5000d, "Description of Ship"));
    }

    @Override
    public List<Product> getAllProduct() {
        return products;
    }

    @Override
    public void saveProduct(Product product) {
        products.add(product);
    }

    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }
}
