package ss7_abstract_class_interface.bai_tap.ss2_interface_colorable;

public class Main {
    public static void main(String[] args) {
        int random = (int) (Math.random()*100);
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5.3);
        shapes[1] = new Rectangle(10,3);
        shapes[2] = new Square(10);

        for (Shape s : shapes) {
             if (s instanceof Square) {
                 ((Square) s).howToColor();
             }
            System.out.println(s.toString());
        }
    }
}
