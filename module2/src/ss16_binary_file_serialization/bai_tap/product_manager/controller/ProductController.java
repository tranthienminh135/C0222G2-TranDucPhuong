package ss16_binary_file_serialization.bai_tap.product_manager.controller;

import ss16_binary_file_serialization.bai_tap.product_manager.service.ProductService;
import ss16_binary_file_serialization.bai_tap.product_manager.service.impl.ProductServiceImpl;

import java.util.Scanner;

public class ProductController {
    private static Scanner sc = new Scanner(System.in);
    private static ProductService productService = new ProductServiceImpl();

    public static void display() {
        boolean flag = true;
        while (flag) {
            System.out.println("Product menu" + "\n" +
                    "1. Display product" + "\n" +
                    "2. Add new product" + "\n" +
                    "3. Delete product" + "\n" +
                    "4. Search product" + "\n" +
                    "5. Edit product" + "\n" +
                    "6. Ascending sort product" + "\n" +
                    "7. Descending sort product" + "\n" +
                    "0. Exit" + "\n");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Display list products");
                    productService.displayProduct();
                    break;
                case 2:
                    System.out.println("Add new product");
                    productService.addNewProduct();
                    break;
                case 3:
                    System.out.println("Delete product");
                    productService.deleteProduct();
                    break;
                case 4:
                    System.out.println("Search product");
                    productService.searchProductByName();
                    break;
                case 5:
                    productService.editProductByName();
                    break;
                case 6:
                    productService.ascendingSortProductByPrice();
                    break;
                case 7:
                    productService.descendingSortProductByPrice();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
            }
        }
    }
}
