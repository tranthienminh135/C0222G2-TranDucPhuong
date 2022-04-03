package ss2_loop.bai_tap;

public class Bai2TheFirst20Prime {
    public static void main(String[] args) {
        int count = 0;
        int n = 0;
        while (count < 20) {
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
            if (flag) {
                System.out.println(n);
                count++;
            }
            n++;
        }
//            int i = 0;
//            int count = 0;
//            while (count<20) {
//                boolean flag = true;
//                if (i < 2) {
//                    flag = false;
//                } else {
//                    int j = 2;
//                    while (j <= Math.sqrt(i)) {
//                        if (i % j == 0) {
//                            flag = false;
//                            break;
//                        }
//                        j++;
//                    }
//                    if (flag) {
//                        System.out.println(i + " is a prime");
//                        count++;
//                    }
//                }
//                i++;
//            }


    }
}
