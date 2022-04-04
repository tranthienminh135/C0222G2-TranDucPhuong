package ss2_loop.bai_tap;

import java.util.Scanner;

public class SS3PrimeNumbersLessThan100 {
    public static void main(String[] args) {
        int n = 0;
        while (n < 100) {
            boolean flag = true;
            if (n < 2) {
                flag = false;
            } else {
                int j = 2;
                while (j <= Math.sqrt(n)) {
                    if (n % j == 0) {
                        flag = false;
                        break;
                    }
                    j++;
                }
                if (flag) {
                    System.out.println(n);
                }
            }
            n++;
        }
    }
}
