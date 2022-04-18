package ss11_java_collection_framework.bai_tap.product_manager.model;

public abstract class Vehicle {
    private Integer id;
    private String name;
    private Double price;

    public Vehicle() {
    }

    public Vehicle(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id = " + id +
                ", name = '" + name + '\'' +
                ", price = " + price;
    }
}
