package ss3_array_method.bai_tap;

import java.util.Scanner;

public class SS3CombineArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr1 = new int[7];
        int[] arr2 = new int[5];
        int[] arr3 = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (i + 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (i + 10);
        }
        System.out.println("My array 1");
        for (int a : arr1) {
            System.out.println(a);
        }
        System.out.println("My array 2");
        for (int a : arr2) {
            System.out.println(a);
        }
        int j = 0;
        for (int i = 0; i < arr3.length; i++) {
            if (i < arr1.length) {
                arr3[i] = arr1[i];
            } else {
                if (j<arr2.length) {
                    arr3[i] = arr2[j];
                    j++;
                }
            }
        }
        System.out.println("My array 3");
        for (int a : arr3) {
            System.out.println(a);
        }
    }
}
