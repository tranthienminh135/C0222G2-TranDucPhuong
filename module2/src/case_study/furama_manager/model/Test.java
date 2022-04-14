package case_study.furama_manager.model;

public class Test {
    public static void main(String[] args) {
        FurumaRentalService villa = new Villa();
        FurumaRentalService house = new House();

        ((Villa) villa).setServiceName("The Continental");
        ((Villa) villa).setUsableArea(5.5);
    }
}
