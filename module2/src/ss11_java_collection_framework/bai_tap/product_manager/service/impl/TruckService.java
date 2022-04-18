package ss11_java_collection_framework.bai_tap.product_manager.service.impl;

import ss11_java_collection_framework.bai_tap.product_manager.model.Truck;
import ss11_java_collection_framework.bai_tap.product_manager.service.ITruckService;

import java.util.*;

public class TruckService implements ITruckService {
    private static Scanner sc = new Scanner(System.in);
    private static List<Truck> trucks = new ArrayList<>();

    static {
        trucks.add(new Truck(1,"Huyndai",100000.0));
        trucks.add(new Truck(2,"Toyota",300000.0));
        trucks.add(new Truck(3,"Honda",250000.0));
        trucks.add(new Truck(4,"Yamaha",13000.0));
        trucks.add(new Truck(5,"Suzuki",450000.0));
    }

    @Override
    public void addNewProduct() {
        System.out.print("Enter id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(sc.nextLine());

        Truck truck = new Truck(id, name, price);
        trucks.add(truck);
    }

    @Override
    public void displayProduct() {
        for (Truck truck : trucks) {
            System.out.println(truck);
        }
    }

    @Override
    public void deleteById() {
        System.out.print("Enter id for delete: ");
        int id = Integer.parseInt(sc.nextLine());

        if (checkElementExistsById(id)) {
            for (int i = 0; i < trucks.size(); i++) {
                if (trucks.get(i).getId() == id) {
                    trucks.remove(i);
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

            for (int i = 0; i < trucks.size(); i++) {
                if (trucks.get(i).getId() == id) {
                    trucks.get(i).setId(id);
                    trucks.get(i).setName(name);
                    trucks.get(i).setPrice(price);
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
            for (Truck truck: trucks) {
                if (truck.getName().equals(name)) {
                    System.out.println(truck);
                    break;
                }
            }
        } else {
            System.out.println(name+ " is NOT found!");
        }
    }

    @Override
    public void sortAscendingByPrice() {
        Collections.sort(trucks, new Comparator<Truck>() {
            @Override
            public int compare(Truck o1, Truck o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        });
        displayProduct();
    }

    @Override
    public void sortDescendingByPrice() {
        Collections.sort(trucks, ((o1, o2) -> (int) (o2.getPrice() - o1.getPrice())));
        displayProduct();
    }

    @Override
    public boolean checkElementExistsById(int id) {
        for (Truck truck : trucks) {
            if (truck.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkElementExistsByName(String name) {
        for (Truck truck : trucks) {
            if (truck.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
