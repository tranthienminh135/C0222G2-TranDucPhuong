package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class Bai1SayHello {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello: " + name);
    }
}
