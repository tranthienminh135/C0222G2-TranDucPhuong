package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class Bai3ConvertCurrency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USD: ");
        Double usd = sc.nextDouble();

        Double rate = usd * 23000;
        System.out.println(usd + " USD to VND: " + rate);
    }
}