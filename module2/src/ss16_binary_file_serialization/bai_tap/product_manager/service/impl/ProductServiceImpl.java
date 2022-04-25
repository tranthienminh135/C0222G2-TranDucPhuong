package ss16_binary_file_serialization.bai_tap.product_manager.service.impl;


import ss16_binary_file_serialization.bai_tap.product_manager.common.FileService;
import ss16_binary_file_serialization.bai_tap.product_manager.model.Product;
import ss16_binary_file_serialization.bai_tap.product_manager.service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    private final static String FILE_NAME = "src/ss16_binary_file_serialization/bai_tap/product.csv";
    private static FileService fileService = new FileService();
    private static List<Product> productList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    static {
        productList.add(new Product(1, "Hoan", "Trung Quoc", 60000d, "ok"));
        productList.add(new Product(2, "Hau", "Thai Lan", 20000d, "ok luon"));
        productList.add(new Product(3, "Luan", "My", 80000d, "ok con de"));
        productList.add(new Product(4, "Tai", "Han Xeng", 100000d, "khong ok"));
        productList.add(new Product(5, "Binh", "Lao", 50000d, "ok vua vua"));


        fileService.writeToFile(FILE_NAME, productList);
    }

    @Override
    public void displayProduct() {
        productList = fileService.readFormFile(FILE_NAME);

        if (!productList.isEmpty()) {
            for (Product productForDisplay : productList) {
                System.out.println(productForDisplay);
            }
        } else {
            System.err.println("Product list is empty!");
        }
    }

    @Override
    public void addNewProduct() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter manufacturer: ");
        String manufacturer = sc.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Enter description: ");
        String description = sc.nextLine();
        Product productAddNew = new Product(id, name, manufacturer, price, description);
        productList.add(productAddNew);
        fileService.writeToFile(FILE_NAME, productList);
        System.err.println("Add new product is success!");
    }

    @Override
    public void deleteProduct() {
        productList = fileService.readFormFile(FILE_NAME);
        System.out.print("Enter name for delete: ");
        String nameForDelete = sc.nextLine();

        if (checkProductExistsByName(nameForDelete)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equalsIgnoreCase(nameForDelete)) {
                    productList.remove(i);
                    break;
                }
            }
            fileService.writeToFile(FILE_NAME, productList);
        } else {
            System.err.println("Product is not found!");
        }
    }

    @Override
    public void searchProductByName() {
        productList = fileService.readFormFile(FILE_NAME);
        System.out.print("Enter name for search: ");
        String nameForSearch = sc.nextLine();

        if (checkProductExistsByName(nameForSearch)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equalsIgnoreCase(nameForSearch)) {
                    System.out.println(productList.get(i));
                }
            }
        } else {
            System.err.println("Product is not found!");
        }
    }

    @Override
    public void editProductByName() {
        productList = fileService.readFormFile(FILE_NAME);
        System.out.print("Enter name for search: ");
        String nameForEdit = sc.nextLine();

        if (checkProductExistsByName(nameForEdit)) {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getName().equalsIgnoreCase(nameForEdit)) {
                    System.out.print("Enter id: ");
                    productList.get(i).setId(Integer.valueOf(sc.nextLine()));
                    productList.get(i).setName(nameForEdit);
                    System.out.print("Enter manufacturer: ");
                    productList.get(i).setManufacturer(sc.nextLine());
                    System.out.print("Enter price: ");
                    productList.get(i).setPrice(Double.valueOf(sc.nextLine()));
                    System.out.print("Enter description: ");
                    productList.get(i).setDescription(sc.nextLine());
                    fileService.writeToFile(FILE_NAME, productList);
                    System.err.println("Edit new product is success!");
                }
            }
        }
    }

    @Override
    public void ascendingSortProductByPrice() {
        productList = fileService.readFormFile(FILE_NAME);

        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });

        for (Product productSortAscending: productList) {
            System.out.println(productSortAscending);
        }
    }

    @Override
    public void descendingSortProductByPrice() {
        productList = fileService.readFormFile(FILE_NAME);

        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        });

        for (Product productSortAscending: productList) {
            System.out.println(productSortAscending);
        }
    }

    private static boolean checkProductExistsByName(String nameForDelete) {
        productList = fileService.readFormFile(FILE_NAME);
        for (Product productDelete : productList) {
            if (productDelete.getName().equalsIgnoreCase(nameForDelete)) {
                return true;
            }
        }
        return false;
    }
}
