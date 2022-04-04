package ss3_array_method.bai_tap;

import java.util.Scanner;

public class SS1RemoveElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1);
        }
        arr[4] = 4;
        arr[5] = 4;
        System.out.println("My array");
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.print("Enter x: ");
        int x = sc.nextInt();

        findXInArray(x, arr);
    }

    public static void findXInArray(int x, int[] arr) {
        int temp = 0;
        boolean flag = false;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                count++;
            }
        }
        System.out.println("count:" + count);
        for (int i = 0; i < arr.length; i++) {
            if (x == arr[i]) {
                temp = i;
                flag = true;
                break;
            }

        }
        if (flag) {
            while (count > 0) {
                System.out.println("Index of X: " + temp);
                for (int i = temp; i < arr.length - 1; i++) {
                    arr[i] = arr[i + 1];
                }
                arr[arr.length - 1] = 0;
                count--;
                System.out.println("New array");
                for (int a : arr) {
                    System.out.println(a);
                }
            }
        } else {
            System.out.println("X not found!");
        }
    }
}
