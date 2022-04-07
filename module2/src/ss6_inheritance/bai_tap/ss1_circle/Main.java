package ss6_inheritance.bai_tap.ss1_circle;

public class Main {
    public static void main(String[] args) {
        Cylinder cl = new Cylinder();

        cl.setRadius(5.6f);
        cl.setColor("red");
        cl.setHeight(5);

        System.out.println(cl.toString());

        System.out.println("Circle area: " + cl.area());
        System.out.println("Circle perimeter: " + cl.perimeter());
        System.out.println("Cylinder volume: " + cl.volume());
    }
}
