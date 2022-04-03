package ss3_array_method.thuc_hanh;

import java.util.Scanner;

public class Bai1DaoNguocCacPhanTuTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1);
        }
        System.out.println("My array: ");
        for (int a : arr) {
            System.out.println(a);
        }

        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        System.out.println("My new array: ");
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
