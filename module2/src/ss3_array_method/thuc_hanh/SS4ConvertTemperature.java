package ss3_array_method.thuc_hanh;

import java.util.Scanner;

public class SS4ConvertTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("You choice 1 please enter Fahrenheit: ");
                    float f = sc.nextFloat();
                    System.out.println( f + " Fahrenheit = " + ((5.0 / 9) * (f - 32)) + " Celsius");
                    break;
                case 2:
                    System.out.print("You choice 2 please enter Celsius: ");
                    float c = sc.nextFloat();
                    System.out.println( c + " Celsius = " + ((9.0 / 5) * c + 32) + " Fahrenheit");
                    break;
                case 0:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Please choice!");
                    break;
            }
        }
        while (choice != 0);
    }
}
