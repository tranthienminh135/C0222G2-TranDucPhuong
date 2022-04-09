package ss6_inheritance.bai_tap.ss4_triangle;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        triangle.setSide1(10);
        triangle.setSide2(20);
        triangle.setSide3(30);
        triangle.setColor("Blue");

        System.out.println(triangle.toString());

        System.out.println("Perimeter: " + triangle.perimeter());
        System.out.println("Area: " + triangle.area());

    }
}
