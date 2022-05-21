package phuong.giai_thuat;

public class Demo {
    public static void main(String[] args) {
        int i = 0;
        int count = 1;
        while (count <= 100) {
            if (isPrime(i)) {
                System.out.println("Số thứ "+ count + ": " + i);
                count++;
            }
            i++;
        }
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        } else if (number <= 3) {
            return true;
        } else {
            int temp = 2;
            while (temp < number) {
                if (number % temp == 0) {
                    return false;
                }
                temp++;
            }
        }
        return true;
    }
}
