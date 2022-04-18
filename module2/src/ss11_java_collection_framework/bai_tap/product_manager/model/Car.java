package ss11_java_collection_framework.bai_tap.product_manager.model;

public class Car extends Vehicle {

    public Car() {
    }

    public Car(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "Car {" + super.toString() + "}";
    }
}
