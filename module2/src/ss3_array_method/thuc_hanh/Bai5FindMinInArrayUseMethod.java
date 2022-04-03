package ss3_array_method.thuc_hanh;

import java.util.Scanner;

public class Bai5FindMinInArrayUseMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 99);
        }
        System.out.println("My array");
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.println("Min: " + minValue(arr));
    }
    public static int minValue(int[] array){
        int min = array[0];
        for (int a: array) {
            if (a < min) {
                min = a;
            }
        }
        return min;
    }
}
