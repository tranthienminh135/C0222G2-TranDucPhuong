package phuong.giai_thuat.galaxy_cinema.common;

import phuong.giai_thuat.galaxy_cinema.model.GalaxyCinema;

import java.io.*;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private final static String FILE_NAME = "src/phuong/giai_thuat/galaxy_cinema/common/data/galaxy_cinema.csv";
    private static final String COMMA = ",";
    private static final String SEMI = ";";
    private final static String PATTERN_TIME = "HH:mm";
    private final static String PATTERN_DATE = "dd-MM-yyyy";
    private static SimpleDateFormat formatTime = new SimpleDateFormat(PATTERN_TIME);
    private static SimpleDateFormat formatDate = new SimpleDateFormat(PATTERN_DATE);

    private static void writeToFile(String pathFile, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeCinema(String pathFile, List<GalaxyCinema> galaxyCinemas) {
        List<String> strings = new ArrayList<>();

        for (GalaxyCinema galaxyCinema : galaxyCinemas) {
            strings.add(ConvertLine.convertLine(galaxyCinema));
        }

        writeToFile(pathFile, strings);
    }

    public static List<GalaxyCinema> readGalaxyCinemaListFromFile(String pathFile) {
        List<GalaxyCinema> galaxyCinemas = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String[] lines = null;
            String line;

            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                lines = line.split(COMMA);

                List<Date> listTime = new ArrayList<>();
                String[] times;
                times = lines[2].split(SEMI);
                for (String s : times) {
                    listTime.add(formatTime.parse(s));
                }


                GalaxyCinema galaxyCinema = new GalaxyCinema(lines[0], lines[1], listTime, formatDate.parse(lines[3]), Integer.parseInt(lines[4]));
                galaxyCinemas.add(galaxyCinema);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return galaxyCinemas;
    }
}
