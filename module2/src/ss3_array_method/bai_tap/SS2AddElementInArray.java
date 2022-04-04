package ss3_array_method.bai_tap;

import java.util.Scanner;

public class SS2AddElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[9] = 15;
        System.out.println("My array");
        for (int a : arr) {
            System.out.println(a);
        }
        System.out.print("Enter x: ");
        int x = sc.nextInt();
        System.out.print("Enter index: ");
        int index = sc.nextInt();

        addXToArray(x,index,arr);
    }
    public static void addXToArray(int x, int index, int[] arr) {
        if (index < 0 || index >= arr.length - 1) {
            System.out.println("Index is out of ability");
        } else {
            for (int i = arr.length-1; i > index ; i--) {
                arr[i] = arr[i-1];
            }
            arr[index] = x;
            System.out.println("New array");
            for (int a : arr) {
                System.out.println(a);
            }
        }
    }
}
