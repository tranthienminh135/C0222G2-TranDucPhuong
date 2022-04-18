package ss11_java_collection_framework.bai_tap.product_manager.view;

import ss11_java_collection_framework.bai_tap.product_manager.controller.ProductController;

public class ProductView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.display();
    }
}
