package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class Bai1IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        if (number < 2)
            System.out.println(number + " is not a prime");
         else {
            int i = 2;
            boolean flag = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    flag = false;
                    break;
                }
                i++;
            }
            if (flag)
                System.out.println(number + " is a prime");
            else
                System.out.println(number + " is not a prime");
        }
    }
}
