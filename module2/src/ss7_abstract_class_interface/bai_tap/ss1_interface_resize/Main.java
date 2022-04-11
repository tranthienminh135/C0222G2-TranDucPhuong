package ss7_abstract_class_interface.bai_tap.ss1_interface_resize;

public class Main {
    public static void main(String[] args) {
        int random = (int) (Math.random()*100);
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(5.3);
        shapes[1] = new Rectangle(10,3);
        shapes[2] = new Square(((Rectangle) shapes[1]).getWidth());

        System.out.println("----------- Before -----------");
        for (Shape s : shapes) {
            System.out.println(s.toString());
        }
        System.out.println("----------- After -----------");

        for (Shape s : shapes) {
            if (s instanceof Circle) {
                ((Circle) s).resize(random);
            } else if (s instanceof Square){
                ((Square) s).resize(random);
            } else if (s instanceof Rectangle) {
                ((Rectangle) s).resize(random);
            }
        }
        for (Shape s : shapes) {
            System.out.println(s.toString());
        }
    }
}
