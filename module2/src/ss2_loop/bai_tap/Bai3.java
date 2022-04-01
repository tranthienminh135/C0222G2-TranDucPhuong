package ss2_loop.bai_tap;

public class Bai3 {
    public static void main(String[] args) {
        int n = 0;
        while (n < 100) {
            boolean flag = true;
            if (n < 2) {
                flag = false;
            } else if (n > 2) {
                if (n % 2 == 0) {
                    flag = false;
                }
            }
            for (int i = 3; i < n; i += 2) {
                if (n % i == 0) {
                    flag = false;
                }
            }
            if (flag == true) {
                System.out.println(n);
            }
            n++;
        }
    }
}
