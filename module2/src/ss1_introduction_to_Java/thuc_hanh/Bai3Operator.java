package ss1_introduction_to_Java.thuc_hanh;

import java.util.Scanner;

public class Bai3Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter width: ");
        float width = sc.nextFloat();
        System.out.print("Enter height: ");
        float height = sc.nextFloat();

        float area = width * height;
        System.out.print("Area: " + area);
    }
}
