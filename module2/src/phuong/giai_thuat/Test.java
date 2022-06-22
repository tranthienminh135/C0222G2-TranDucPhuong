package phuong.giai_thuat;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 1, 2, 6};
        System.out.println(solution(arr));
    }

    public static boolean solution(int[] arr) {

        if (arr.length < 3) {
            return false;
        } else {
            int firstSum = 0;
            for (int i = 1; i < arr.length; i++) {
                firstSum += arr[i - 1];
                int secondSum = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    secondSum += arr[j];
                }
                if (firstSum == secondSum) {
                    return true;
                }
            }

        }

        return false;
    }
}
