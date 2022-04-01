package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rate = 23000;
        System.out.print("Enter USD: ");
        int usd = sc.nextInt();
        int vnd = usd * rate;
        System.out.print(usd + " USD = " + vnd + " VND");
    }
}
