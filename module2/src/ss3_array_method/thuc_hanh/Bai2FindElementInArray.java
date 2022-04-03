package ss3_array_method.thuc_hanh;

import java.util.Scanner;

public class Bai2FindElementInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};

        System.out.print("Enter element for find: ");
        String x = sc.nextLine();

        boolean flag = false;
        for (int i = 0; i < students.length ; i++) {
            if (students[i].equals(x)) {
                System.out.println(students[i] + " found at position: " + i + " in array!");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(x + " not found!");
        }
    }
}
