package phuong.giai_thuat.galaxy_cinema.common;

import phuong.giai_thuat.galaxy_cinema.model.GalaxyCinema;
import phuong.giai_thuat.galaxy_cinema.service.impl.MovieServiceImpl;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConvertLine {
    private final static String PATTERN_TIME = "HH:mm";
    private final static String PATTERN_DATE = "dd-MM-yyyy";
    private static SimpleDateFormat formatTime = new SimpleDateFormat(PATTERN_TIME);
    private static SimpleDateFormat formatDate = new SimpleDateFormat(PATTERN_DATE);
    private static List<GalaxyCinema> galaxyCinemas = MovieServiceImpl.getGalaxyCinemas();
    private static final String COMMA = ",";
    private static final String SEMI = ";";

    public static String convertLine(GalaxyCinema galaxyCinema) {
        String timeStr = "";

        for (int i = 0; i < galaxyCinema.getShowtime().size(); i++) {
            if (i == galaxyCinema.getShowtime().size() - 1) {
                timeStr += formatTime.format(galaxyCinema.getShowtime().get(i));
                break;
            }
            timeStr += formatTime.format(galaxyCinema.getShowtime().get(i)) + SEMI;
        }
        return galaxyCinema.getMovieId() + COMMA + galaxyCinema.getMovieName() + COMMA + timeStr + COMMA + formatDate.format(galaxyCinema.getMovieDay()) + COMMA + galaxyCinema.getTicketsNumber();
    }
}
