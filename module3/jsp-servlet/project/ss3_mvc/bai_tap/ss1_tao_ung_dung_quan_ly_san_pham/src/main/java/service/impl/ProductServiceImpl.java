package service.impl;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
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
    public void deleteProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public void addNewProduct(int id, String name, double price, String description) {
        products.add(new Product(id, name, price,description));
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
