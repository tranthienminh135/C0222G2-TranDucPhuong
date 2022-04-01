package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your weight (in kilogram): ");
        Double weight = sc.nextDouble();

        System.out.print("Your height (in meter): ");
        Double height = sc.nextDouble();

        System.out.printf("%-20s%20s", "bmi", "Interpretation\n");

        Double bmi = weight / Math.pow(height, 2);
        if (bmi < 18)
            System.out.printf("%-20.2f%20s", bmi, "Underweight");
        else if (bmi < 25.0)
            System.out.printf("%-20.2f%20s", bmi, "Normal");
        else if (bmi < 30.0)
            System.out.printf("%-20.2f%20s", bmi, "Overweight");
        else
            System.out.printf("%-20.2f%20s", bmi, "Obese");
    }
}