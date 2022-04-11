package ss6_inheritance.bai_tap.ss1_circle;

public class Circle {
    private float radius;
    private String color = "red";

    public Circle() {
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    public Circle(float radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float area() {
        return (float) (Math.PI * Math.pow(this.radius, 2));
    }

    public float perimeter() {
        return (float) (2 * Math.PI * this.radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Radius=" + this.radius +
                ", Color = " + this.color +
                ", Area = " + this.area() +
                ", Perimeter = " + this.perimeter() +
                '}';
    }
}
