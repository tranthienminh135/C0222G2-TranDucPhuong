package ss6_inheritance.bai_tap.ss2_moveable_point;

public class Main {
    public static void main(String[] args) {
        MoveablePoint mp = new MoveablePoint();

        mp.setXY(5.5f, 6.6f);
        mp.setSpeed(1.1f, 2.2f);

        for (int i = 0; i < mp.getSpeed().length; i++) {
            System.out.println(mp.getSpeed()[i]);
        }

        System.out.println(mp.toString());
        System.out.println(mp.move());

    }
}
