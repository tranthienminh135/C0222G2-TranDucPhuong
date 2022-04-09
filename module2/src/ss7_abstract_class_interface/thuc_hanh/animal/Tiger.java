package ss7_abstract_class_interface.thuc_hanh.animal;

import ss7_abstract_class_interface.thuc_hanh.edible.Edible;

public class Tiger extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Tiger sound";
    }

    @Override
    public String howToEat() {
        return "Tiger could be fried";
    }

    @Override
    public void info() {
        System.out.println("Tiger");
    }
}
