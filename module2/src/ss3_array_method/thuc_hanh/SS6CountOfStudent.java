package ss3_array_method.thuc_hanh;

import java.util.Scanner;

public class SS6CountOfStudent {
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        int count = 0;
        for (int a : arr) {
            System.out.println("Mark: " + a);
            if (a >= 5 && a <= 10) {
                count++;
            }
        }
        System.out.println("The number of students passing the exam is: " + count);
    }
}
