package phuong.giai_thuat.galaxy_cinema.common;

import java.util.Scanner;

public class CheckRegex {
    private static Scanner sc = new Scanner(System.in);
    private final static String MOVIE_ID = "^CL\\-[0-9]{4}$";
    private final static String GREATER_THAN_ZERO = "^[0-9]+$";

    public static String regexMovieId(String movieId) {
        while (!movieId.matches(MOVIE_ID)) {
            System.out.print("Enter movie id again (CL-XXXX): ");
            movieId = sc.nextLine();
        }
        return movieId;
    }
    public static Integer regexTicketsNumber(int ticketsNumber) {
        while (!String.valueOf(ticketsNumber).matches(GREATER_THAN_ZERO)) {
            System.out.print("Enter again ( value must be greater than zero ): ");
            ticketsNumber = CheckException.checkParseIntEx(ticketsNumber);
        }
        return ticketsNumber;
    }
}
