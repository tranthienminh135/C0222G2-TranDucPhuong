package ss5_access_modifier_static_method_static_property.bai_tap.ss1_circle.test_circle;

import ss5_access_modifier_static_method_static_property.bai_tap.ss1_circle.circle.Circle;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();

        System.out.println("Area: " + circle.getArea());
        System.out.println("Radius: " + circle.getRadius());
    }
}
