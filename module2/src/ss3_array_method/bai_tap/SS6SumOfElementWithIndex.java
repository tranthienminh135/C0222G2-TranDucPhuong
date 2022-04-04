package ss3_array_method.bai_tap;

import java.util.Scanner;

public class SS6SumOfElementWithIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = sc.nextInt();
        System.out.print("Enter array element length : ");
        int m = sc.nextInt();
        float[][] arr = new float[n][m];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (float) (Math.random() * 99);
            }
        }
        System.out.println("My array: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Element in i = " + i + " j = " + j + ": " + arr[i][j]);
            }
        }
        System.out.print("Enter element index for sum: ");
        int index = sc.nextInt();

        System.out.println("Sum of element with index = " + index + ": " + sumOfElement(index, arr));
    }
    public static float sumOfElement(int index, float[][] arr) {
        float sum = 0.0f;

        for (int i = 0; i < arr[index].length; i++) {
            sum += arr[index][i];
        }
        return sum;
    }
}
