package ss11_java_collection_framework.bai_tap.product_manager.service.impl;

import ss11_java_collection_framework.bai_tap.product_manager.model.Car;
import ss11_java_collection_framework.bai_tap.product_manager.service.ICarService;

import java.util.*;

public class CarService implements ICarService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(1,"Huyndai",100000.0));
        cars.add(new Car(2,"Toyota",300000.0));
        cars.add(new Car(3,"Honda",250000.0));
        cars.add(new Car(4,"Yamaha",13000.0));
        cars.add(new Car(5,"Suzuki",450000.0));
    }

    @Override
    public void addNewProduct() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());

        Car car = new Car(id, name, price);
        cars.add(car);
    }

    @Override
    public void displayProduct() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void deleteById() {
        System.out.print("Enter id for delete: ");
        int id = Integer.parseInt(sc.nextLine());

        if (checkElementExistsById(id)) {
            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getId() == id) {
                    cars.remove(i);
                    break;
                }
            }
        } else {
            System.out.println("Element with id = " + id + " is NOT found");
        }
    }

    @Override
    public void updateById() {
        System.out.print("Enter id for delete: ");
        int id = Integer.parseInt(sc.nextLine());

        if (checkElementExistsById(id)) {
            System.out.print("Enter name for update: ");
            String name = sc.nextLine();
            System.out.print("Enter price for update: ");
            double price = Double.parseDouble(sc.nextLine());

            for (int i = 0; i < cars.size(); i++) {
                if (cars.get(i).getId() == id) {
                    cars.get(i).setId(id);
                    cars.get(i).setName(name);
                    cars.get(i).setPrice(price);
                    break;
                }
            }
        } else {
            System.out.println("Element with id = " + id + " is NOT found!");
        }
    }

    @Override
    public void searchByName() {
        System.out.print("Enter name for search: ");
        String name = sc.nextLine();

        if (checkElementExistsByName(name)) {
            for (Car car: cars) {
                if (car.getName().equals(name)) {
                    System.out.println(car);
                    break;
                }
            }
        } else {
            System.out.println(name+ " is NOT found!");
        }
    }

    @Override
    public void sortAscendingByPrice() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        displayProduct();
    }

    @Override
    public void sortDescendingByPrice() {
        Collections.sort(cars, ((o1, o2) -> (int) (o2.getPrice() - o1.getPrice())));
        displayProduct();
    }

    @Override
    public boolean checkElementExistsById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkElementExistsByName(String name) {
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
