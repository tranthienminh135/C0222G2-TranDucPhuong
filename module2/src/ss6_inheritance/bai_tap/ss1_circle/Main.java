package ss6_inheritance.bai_tap.ss1_circle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Cylinder();

        System.out.print("Enter radius: ");
        circle.setRadius(Float.parseFloat((new Scanner(System.in)).nextLine()));
        System.out.print("Enter height: ");
        ((Cylinder) circle).setHeight(Float.parseFloat((new Scanner(System.in)).nextLine()));
        System.out.println(circle.toString());
    }
}
