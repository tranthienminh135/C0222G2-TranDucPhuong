package phuong.giai_thuat;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<Integer> integerSet = new LinkedHashSet<>();

        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        integerSet.add(5);

        int i = 0;
        for (Integer integer : integerSet) {
            System.out.println(i + ": " + integer);
            i++;
        }
        int temp = 0;
        System.out.print("Your choice: ");
        int choice = Integer.parseInt((new Scanner(System.in)).nextLine());
        for (Integer integer : integerSet) {
            if (temp == choice) {
                System.out.println(integer);
                break;
            }
            temp++;
        }
    }
}
