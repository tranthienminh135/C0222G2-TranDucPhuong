package phuong.giai_thuat.galaxy_cinema.service.impl;

import phuong.giai_thuat.galaxy_cinema.common.CheckException;
import phuong.giai_thuat.galaxy_cinema.common.CheckRegex;
import phuong.giai_thuat.galaxy_cinema.common.FileService;
import phuong.giai_thuat.galaxy_cinema.model.GalaxyCinema;
import phuong.giai_thuat.galaxy_cinema.service.IMovieService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieServiceImpl implements IMovieService {
    private static List<GalaxyCinema> galaxyCinemas = new ArrayList<>();
    private final static String PATTERN_TIME = "HH:mm";
    private final static String PATTERN_DATE = "dd-MM-yyyy";
    private static SimpleDateFormat formatTime = new SimpleDateFormat(PATTERN_TIME);
    private static SimpleDateFormat formatDate = new SimpleDateFormat(PATTERN_DATE);
    private static Date now = new Date();
    private static Scanner sc = new Scanner(System.in);
    private final static String FILE_NAME = "src/phuong/giai_thuat/galaxy_cinema/common/data/galaxy_cinema.csv";

    public static List<GalaxyCinema> getGalaxyCinemas() {
        return galaxyCinemas;
    }

    @Override
    public void display() {
        galaxyCinemas = FileService.readGalaxyCinemaListFromFile(FILE_NAME);
        if (galaxyCinemas.isEmpty()) {
            System.out.println("List movie is entry!");
        } else {
            for (GalaxyCinema galaxyCinema : galaxyCinemas) {
                System.out.println("Movie Name: " + galaxyCinema.getMovieName());
                System.out.println("Movie id: " + galaxyCinema.getMovieId());
                System.out.println("Show Time: ");
                for (int i = 0; i < galaxyCinema.getShowtime().size(); i++) {
                    if (i == galaxyCinema.getShowtime().size() - 1) {
                        System.out.print(formatTime.format(galaxyCinema.getShowtime().get(i)));
                        break;
                    }
                    System.out.print(formatTime.format(galaxyCinema.getShowtime().get(i)) + " | ");
                }
                System.out.println();
                System.out.println("-------------------------");
            }
        }
    }

    @Override
    public void addNewMovie() {
        galaxyCinemas = FileService.readGalaxyCinemaListFromFile(FILE_NAME);
        System.out.print("Enter movie id: ");
        String movieId = sc.nextLine();
        movieId = CheckRegex.regexMovieId(movieId);
        while (checkMovieIdExists(movieId)) {
            System.out.println("Movie id is exists!");
            System.out.print("Enter again: ");
            movieId = sc.nextLine();
            movieId = CheckRegex.regexMovieId(movieId);
        }
        System.out.print("Enter movie name: ");
        String movieName = sc.nextLine();
        System.out.print("Enter number of show time: ");
        int count = 0;
        count = CheckException.checkParseIntEx(count);
        count = CheckRegex.regexTicketsNumber(count);
        List<Date> times = new ArrayList<>();
        int temp = 0;
        while (temp < count) {
            System.out.print("Enter showtime " + (temp + 1) + ": ");
            String timeStr = null;
            Date time = CheckException.checkParseDateForTime(timeStr);
            times.add(time);
            temp++;
        }
        System.out.print("Enter movie day: ");
        String movieDayStr = null;
        Date movieDay = CheckException.checkParseDate(movieDayStr);
        while (movieDay.getTime() < now.getTime()) {
            System.out.println("Movie show date must be later than current date!");
            System.out.print("Enter again: ");
            movieDay = CheckException.checkParseDate(movieDayStr);
        }
        System.out.print("Enter tickets number: ");
        int ticketsNumber = Integer.parseInt(sc.nextLine());
        ticketsNumber = CheckRegex.regexTicketsNumber(ticketsNumber);

        GalaxyCinema galaxyCinema = new GalaxyCinema(movieId, movieName, times, movieDay, ticketsNumber);
        galaxyCinemas.add(galaxyCinema);
        FileService.writeCinema(FILE_NAME, galaxyCinemas);
    }

    @Override
    public void addNewShowTime() {
        galaxyCinemas = FileService.readGalaxyCinemaListFromFile(FILE_NAME);
        System.out.print("Enter movie id for add new show time: ");
        String movieId = sc.nextLine();
        movieId = CheckRegex.regexMovieId(movieId);
        if (checkMovieIdExists(movieId)) {
            for (GalaxyCinema galaxyCinema : galaxyCinemas) {
                if (movieId.equals(galaxyCinema.getMovieId())) {
                    List<Date> listTime = galaxyCinema.getShowtime();
                    System.out.print("Enter new show time: ");
                    String timeStr = null;
                    Date time = CheckException.checkParseDateForTime(timeStr);
                    listTime.add(time);
                    galaxyCinema.setShowtime(listTime);
                    break;
                }
            }
            FileService.writeCinema(FILE_NAME, galaxyCinemas);
        } else {
            System.out.println("Movie id is not exists!");
        }
    }

    @Override
    public void deleteShowTime() {
        galaxyCinemas = FileService.readGalaxyCinemaListFromFile(FILE_NAME);
        System.out.print("Enter movie id for add new show time: ");
        String movieId = sc.nextLine();
        movieId = CheckRegex.regexMovieId(movieId);
        if (checkMovieIdExists(movieId)) {
            for (GalaxyCinema galaxyCinema : galaxyCinemas) {
                if (movieId.equals(galaxyCinema.getMovieId())) {
                    List<Date> listTime = galaxyCinema.getShowtime();
                    System.out.print("Enter show time for delete: ");
                    String timeStr = sc.nextLine();
                    boolean flag = false;
                    for (Date time : listTime) {
                        if (timeStr.equals(formatTime.format(time))) {
                            System.out.println("Do you want delete show time " + timeStr + ": \n" +
                                    "1. Yes" + "\n" +
                                    "2. No");
                            System.out.print("Enter your choice: ");
                            int choice = 0;
                            choice = CheckException.checkParseIntEx(choice);
                            switch (choice) {
                                case 1:
                                    listTime.remove(time);
                                    System.out.println("Delete success!");
                                    break;
                                case 2:
                                    System.out.println("You choice no!");
                                    break;
                                default:
                                    System.out.println("Cancel!");
                                    break;
                            }
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("Show time is not exists!");
                    }
                    galaxyCinema.setShowtime(listTime);
                    break;
                }
            }
            FileService.writeCinema(FILE_NAME, galaxyCinemas);
        } else {
            System.out.println("Movie id is not exists!");
        }
    }

    @Override
    public void deleteMovie() {
        galaxyCinemas = FileService.readGalaxyCinemaListFromFile(FILE_NAME);
        System.out.print("Enter movie id for add new show time: ");
        String movieId = sc.nextLine();
        movieId = CheckRegex.regexMovieId(movieId);
        if (checkMovieIdExists(movieId)) {
            for (GalaxyCinema galaxyCinema : galaxyCinemas) {
                if (movieId.equals(galaxyCinema.getMovieId())) {
                    System.out.println("Do you want delete movie " + galaxyCinema.getMovieName() + " : \n" +
                            "1. Yes" + "\n" +
                            "2. No");
                    System.out.print("Enter your choice: ");
                    int choice = 0;
                    choice = CheckException.checkParseIntEx(choice);
                    switch (choice) {
                        case 1:
                            galaxyCinemas.remove(galaxyCinema);
                            System.out.println("Delete success!");
                            break;
                        case 2:
                            System.out.println("You choice no!");
                            break;
                        default:
                            System.out.println("Cancel!");
                            break;
                    }
                    break;
                }
            }
            FileService.writeCinema(FILE_NAME, galaxyCinemas);
        } else {
            System.out.println("Movie id is not exists!");
        }
    }

    private boolean checkMovieIdExists(String movieId) {
        galaxyCinemas = FileService.readGalaxyCinemaListFromFile(FILE_NAME);
        for (GalaxyCinema galaxyCinema : galaxyCinemas) {
            if (movieId.equals(galaxyCinema.getMovieId())) {
                return true;
            }
        }
        return false;
    }
}
