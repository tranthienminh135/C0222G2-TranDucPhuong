package ss7_abstract_class_interface.thuc_hanh.ss1.animal;

import ss7_abstract_class_interface.thuc_hanh.ss1.edible.Edible;

public class Chicken extends Animal implements Edible {

    @Override
    public String makeSound() {
        return "Chicken sound";
    }

    @Override
    public String howToEat() {
        return "Tiger could be fried";
    }

    @Override
    public void info() {
        System.out.println("Chiken");
    }
}
