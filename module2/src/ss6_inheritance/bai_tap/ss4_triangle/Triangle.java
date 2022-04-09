package ss6_inheritance.bai_tap.ss4_triangle;

public class Triangle extends Shape {
    private double side1 = 1.0d;
    private double side2 = 1.0d;
    private double side3 = 1.0d;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double perimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    public double area() {
        double p = (this.perimeter() / 2);
        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                ", color=" + super.getColor() +
                '}';
    }
}
