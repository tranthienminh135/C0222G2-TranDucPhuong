package ss3_array_method.thuc_hanh;

import java.util.Scanner;

public class Bai3TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = sc.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);

        int[] arr = new int[size];
        int i = 0;
        while (i < arr.length) {
            arr[i] = (int) (Math.random() * 99);
            i++;
        }
        System.out.println("Property list: ");
        for (int k : arr) {
            System.out.println(k);
        }
        int min = arr[0];
        for (int k : arr) {
            if (k < min) {
                min = k;
            }
        }
        System.out.println("Min: " + min);
    }
}
