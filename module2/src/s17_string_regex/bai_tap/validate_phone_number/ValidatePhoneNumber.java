package s17_string_regex.bai_tap.validate_phone_number;

import java.util.Scanner;

public class ValidatePhoneNumber {
    private static Scanner sc = new Scanner(System.in);
    private final static String REGEX_PHONE_NUMBER = "^\\([0-9]{2}\\)\\-\\(0[0-9]{9}\\)$";

    public static void main(String[] args) {
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.println(phoneNumber.matches(REGEX_PHONE_NUMBER));
    }
}
