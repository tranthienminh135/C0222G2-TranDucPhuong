package ss14_exception_and_debug.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            int a;
            int b;
            int c;
            System.out.println();
            System.out.print("Enter a: ");
            a = Integer.parseInt(sc.nextLine());
            System.out.print("Enter b: ");
            b = Integer.parseInt(sc.nextLine());
            System.out.print("Enter c: ");
            c = Integer.parseInt(sc.nextLine());
            try {
                Triangle triangle = new Triangle(a, b, c);
                System.out.println(triangle);
                flag = false;
            } catch (IllegalTriangleException e) {
                flag = true;
                System.err.println("Exception: " + e.getMessage());
            }
        }
    }
}
