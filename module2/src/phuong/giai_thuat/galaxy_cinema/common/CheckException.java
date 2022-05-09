package phuong.giai_thuat.galaxy_cinema.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CheckException {
    private static Scanner sc = new Scanner(System.in);
    private final static String PATTERN_TIME = "HH:mm";
    private final static String PATTERN_DATE = "dd-MM-yyyy";
    private static SimpleDateFormat formatTime = new SimpleDateFormat(PATTERN_TIME);
    private static SimpleDateFormat formatDate = new SimpleDateFormat(PATTERN_DATE);

    public static int checkParseIntEx(int value) {
        boolean flag = true;
        while (flag) {
            try {
                value = Integer.parseInt(sc.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter again: ");
            }
        }
        return value;
    }

    public static Date checkParseDate(String dateStr) {
        Date date = null;
        boolean flag = true;
        while (flag) {
            try {
                dateStr = sc.nextLine();
                date = formatDate.parse(dateStr);
                flag = false;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter again (dd-MM-yyyy): ");
            }
        }
        return date;
    }
    public static Date checkParseDateForTime(String timeStr) {
        Date time = null;
        boolean flag = true;
        while (flag) {
            try {
                timeStr = sc.nextLine();
                time = formatTime.parse(timeStr);
                flag = false;
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                System.out.print("Enter again (HH:mm): ");
            }
        }
        return time;
    }
}
