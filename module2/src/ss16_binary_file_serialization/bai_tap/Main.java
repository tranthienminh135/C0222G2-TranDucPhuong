package ss16_binary_file_serialization.bai_tap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static FileService fileService = new FileService();
    private final static String PATH_NAME = "src/ss16_binary_file_serialization/bai_tap/product.csv";
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Hoan", "Trung Quoc", 10000d, "ok"));
        productList.add(new Product(2,"Hau", "Thai Lan", 20000d, "ok luon"));
        productList.add(new Product(3,"Luan", "My", 30000d, "ok con de"));
        productList.add(new Product(4,"Tai", "Han Xeng", 40000d, "khong ok"));
        productList.add(new Product(5,"Binh", "Lao", 50000d, "ok vua vua"));

        fileService.writeToFile(PATH_NAME,productList);

        List<Product> productListFromFile = fileService.readFormFile(PATH_NAME);

        for (Product p: productListFromFile) {
            System.out.println(p);
        }
    }
}
