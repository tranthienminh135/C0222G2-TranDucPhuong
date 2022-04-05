package ss4_class_and_object.thuc_hanh;

import java.util.Scanner;

public class SS1Rectangle {
    double width;
    double height;

    public SS1Rectangle() {
    }

    public SS1Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle{" +
                "width= " + width +
                ", height= " + height +
                '}';
    }

    public static void main(String[] args) {
        SS1Rectangle rec = new SS1Rectangle();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter width: ");
        double width = sc.nextDouble();
        System.out.print("Enter height: ");
        double height = sc.nextDouble();

        rec.setWidth(width);
        rec.setHeight(height);

        System.out.println(rec.display());
        System.out.println("Area: " + rec.getArea());
        System.out.println("Perimeter: " + rec.getPerimeter());
    }
}
