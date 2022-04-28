package phuong.case_study.furama_manager.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckEx {
    private final static String PATTERN = "dd-MM-yyyy";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
    private static Scanner sc = new Scanner(System.in);
    private static Date now = new Date();
    private final static Long age18Milisecond = 567648000000L;
    private final static Long age100Milisecond = 3153600000000L;

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

    public static Date checkExForDayOfBirth(Date value) {
        boolean check = true;
        while (check) {
            try {
                value = dateFormat.parse(sc.nextLine());
                checkDateEx(value);
                check = false;
            } catch (ParseException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println();
                System.out.print("Enter day of birth again! (dd-MM-yyyy): ");
                check = true;
            } catch (DateException e) {
                System.err.println(e.getMessage());
                System.out.println();
                System.out.print("Enter day of birth again! (dd-MM-yyyy): ");
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

    public static int checkExForChoice(int choice) {
        boolean check = true;
        while (check) {
            try {
                choice = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.err.println("Error: " + e.getMessage());
                System.out.println();
                System.out.print("Choice again! Your choice: ");
                check = true;
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return choice;
    }

    public static void checkDateEx(Date date) throws DateException {
        if (!((now.getTime() - date.getTime() > age18Milisecond) && (now.getTime() - date.getTime()) < age100Milisecond)) {
            throw new DateException("Day of birth must be older than 18, younger than 100 years old!");
        }
    }
}
