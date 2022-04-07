package ss6_inheritance.bai_tap.ss2_point;

public class Main {
    public static void main(String[] args) {
        Point3D p = new Point3D();

        p.setXYZ(5.8f, 6.3f, 7.5f);

        for (int i = 0; i < p.getXYZ().length; i++) {
            System.out.println(p.getXYZ()[i]);
        }
        System.out.println(p.toString());
    }
}
