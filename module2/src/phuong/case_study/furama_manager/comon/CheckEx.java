package phuong.case_study.furama_manager.comon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckEx {
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static Scanner sc = new Scanner(System.in);

    public static Date checkExForDate(Date value) {
        boolean check = true;
        while (check) {
            try {
                value = dateFormat.parse(sc.nextLine());
                check = false;
            } catch (ParseException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println();
                System.out.print("Enter day of birth again! (dd-MM-yyyy): ");
                check = true;
            }
        }
        return value;
    }

    public static double checkExForParseDouble(double value) {
        boolean check = true;
        while (check) {
            try {
                value = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.print("Enter again: ");
                check = true;

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                check = true;
            }
        }
        return value;
    }

    public static long checkExForParseLong(long value) {
        boolean check = true;
        while (check) {
            try {
                value = Long.parseLong(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.print("Enter again: ");
                check = true;

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                check = true;
            }
        }
        return value;
    }

    public static int checkExForParseInt(int value) {
        boolean check = true;
        while (check) {
            try {
                value = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.print("Enter again: ");
                check = true;

            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
                check = true;
            }
        }
        return value;
    }
}
