package phuong.giai_thuat.galaxy_cinema.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GalaxyCinema {
    private String movieId;
    private String movieName;
    private List<Date> showtime;
    private Date movieDay;
    private Integer ticketsNumber;

    public GalaxyCinema() {
    }

    public GalaxyCinema(String movieId, String movieName, List<Date> showtime, Date movieDay, Integer ticketsNumber) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.showtime = showtime;
        this.movieDay = movieDay;
        this.ticketsNumber = ticketsNumber;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public List<Date> getShowtime() {
        return showtime;
    }

    public void setShowtime(List<Date> showtime) {
        this.showtime = showtime;
    }

    public Date getMovieDay() {
        return movieDay;
    }

    public void setMovieDay(Date movieDay) {
        this.movieDay = movieDay;
    }

    public Integer getTicketsNumber() {
        return ticketsNumber;
    }

    public void setTicketsNumber(Integer ticketsNumber) {
        this.ticketsNumber = ticketsNumber;
    }

    @Override
    public String toString() {
        String PATTERN_DAY = "dd-MM-yyyy";
        SimpleDateFormat formatDate = new SimpleDateFormat(PATTERN_DAY);
        return "GalaxyCinema{" +
                "movieId='" + movieId + '\'' +
                ", movieName='" + movieName + '\'' +
                ", showtime=" + showtime +
                ", movieDay=" + formatDate.format(movieDay) +
                ", ticketsNumber='" + ticketsNumber + '\'' +
                '}';
    }
}
