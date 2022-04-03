package ss3_array_method.bai_tap;

import java.util.Scanner;

public class Bai8CountOfCharactorInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "abcacbaacc";

        System.out.print("Enter charactor for find: ");
        String x = sc.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (x.equals(String.valueOf(str.charAt(i)))) {
                count++;
            }
        }
        System.out.println("Count: " + count);
    }
}
