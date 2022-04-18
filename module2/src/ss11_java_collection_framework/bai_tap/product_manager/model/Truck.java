package ss11_java_collection_framework.bai_tap.product_manager.model;

public class Truck extends Vehicle{
    public Truck() {
    }

    public Truck(Integer id, String name, Double price) {
        super(id, name, price);
    }

    @Override
    public String toString() {
        return "Truck {" + super.toString() + "}";
    }
}
