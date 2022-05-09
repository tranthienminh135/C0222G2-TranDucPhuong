package phuong.giai_thuat.galaxy_cinema.controllers;

import phuong.giai_thuat.galaxy_cinema.common.CheckException;
import phuong.giai_thuat.galaxy_cinema.service.IMovieService;
import phuong.giai_thuat.galaxy_cinema.service.impl.MovieServiceImpl;

import java.util.Scanner;

public class GalaxyCinemaController {
    private static IMovieService movieService = new MovieServiceImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void displayGalaxyCinemaManagement() {
        boolean flag = true;
        do {
            System.out.println("Galaxy cinema management" + "\n" +
                    "1. Display movie" + "\n" +
                    "2. Add new movie" + "\n" +
                    "3. Add new show time" + "\n" +
                    "4. Delete show time" + "\n" +
                    "5. Delete movie" + "\n" +
                    "0. Exit");
            System.out.print("Your choice: ");
            int choice = 0;
            choice = CheckException.checkParseIntEx(choice);
            switch (choice) {
                case 1:
                    movieService.display();
                    break;
                case 2:
                    movieService.addNewMovie();
                    break;
                case 3:
                    movieService.addNewShowTime();
                    break;
                case 4:
                    movieService.deleteShowTime();
                    break;
                case 5:
                    movieService.deleteMovie();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Choice again!");
                    break;
            }
        } while (flag);
    }
}
