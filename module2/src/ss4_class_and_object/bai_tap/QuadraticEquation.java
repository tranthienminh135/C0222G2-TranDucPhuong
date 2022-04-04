package ss4_class_and_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public String display() {
        return "QuadraticEquation: " + this.a + "x^2" + " + " + this.b + "x" + " + " + this.c + " = 0" ;
    }

    private double getDiscriminant() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    private double getRoot1() {
        return (-this.b + Math.pow(this.getDiscriminant(), 0.5)) / 2 * this.a;
    }

    private double getRoot2() {
        return (-this.b - Math.pow(this.getDiscriminant(), 0.5)) / 2 * this.a;
    }

    public static void main(String[] args) {
        QuadraticEquation qe = new QuadraticEquation();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = sc.nextDouble();
        System.out.print("Enter b: ");
        double b = sc.nextDouble();
        System.out.print("Enter c: ");
        double c = sc.nextDouble();

        qe.setA(a);
        qe.setB(b);
        qe.setC(c);

        System.out.println(qe.display());

        if (qe.getDiscriminant() > 0) {
            System.out.println("The quation has tow roots: \n Root 1: " + qe.getRoot1() + "\t" + "Root 2: " + qe.getRoot2());
        } else if (qe.getDiscriminant() == 0) {
            System.out.println("The quation has one roots: \n Root : " + qe.getRoot1());
        } else {
            System.out.println("The quation has no real roots");
        }
    }
}
