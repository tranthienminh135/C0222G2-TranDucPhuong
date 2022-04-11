package ss7_abstract_class_interface.thuc_hanh.ss1.edible;

public class Orange extends Fruit{
    @Override
    public String howToEat() {
        return "Orange could be slided";
    }

    @Override
    public void info() {
        System.out.println("Orange");
    }
}
