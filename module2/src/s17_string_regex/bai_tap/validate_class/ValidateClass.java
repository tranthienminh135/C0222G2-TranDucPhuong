package s17_string_regex.bai_tap.validate_class;

import java.util.Scanner;

public class ValidateClass {
    private static Scanner sc = new Scanner(System.in);
    private final static String REGEX_CLASS = "^[CAP][0-9]{4}[GHIKLM]$";
    public static void main(String[] args) {
        System.out.print("Enter class name: ");
        String name = sc.nextLine();

        System.out.println(name.matches(REGEX_CLASS));
    }
}
