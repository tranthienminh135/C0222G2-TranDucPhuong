package ss3_array_method.bai_tap;

import java.util.Scanner;

public class Bai7TinhTongSoDuongCheoChinhCuaMaTranVuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 99);
            }
        }
        System.out.println("My array: ");
        String strArray = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                strArray += arr[i][j] + "\t";
            }
            strArray += "\n";
        }
        System.out.println(strArray);

        int sum1 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 += arr[i][i];
        }
        System.out.println("Sum of upper diagonal: " + sum1);

        int sum2 = 0;
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum2 += arr[i][j];
            j++;
        }
        System.out.println("Sum of bottom diagonal: " + sum2);
    }
}
