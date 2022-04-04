package ss4_class_and_object.bai_tap;

public class SS1Fan {
    public static final byte SLOW = 1;
    public static final byte MEDIUM = 2;
    public static final byte FAST = 3;

    private static int speed = SLOW;
    private static boolean on = false;
    private static double radius = 5.0;
    private static String color = "blue";

    public SS1Fan() {
    }

    public static int getSpeed() {
        return speed;
    }

    public static void setSpeed(int speed) {
        SS1Fan.speed = speed;
    }

    public static boolean isOn() {
        return on;
    }

    public static void setOn(boolean on) {
        SS1Fan.on = on;
    }

    public static double getRadius() {
        return radius;
    }

    public static void setRadius(double radius) {
        SS1Fan.radius = radius;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        SS1Fan.color = color;
    }

    public String toString() {
        if (this.on) {
            return "Fan is on \n" +
                    "Speed: " + this.speed + "\n" +
                    "Color: " + this.color + "\n" +
                    "Radius: " + this.radius;
        } else {
            return "Fan is off \n" +
                    "Color: " + this.color + "\n" +
                    "Radius: " + this.radius;
        }
    }

    public static void main(String[] args) {
        SS1Fan fan1 = new SS1Fan();
        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());

        SS1Fan fan2 = new SS1Fan();
        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("Blue");
        fan2.setOn(false);
        System.out.println(fan2.toString());
    }
}
