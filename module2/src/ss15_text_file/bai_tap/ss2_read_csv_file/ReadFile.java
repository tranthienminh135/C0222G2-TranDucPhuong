package ss15_text_file.bai_tap.ss2_read_csv_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    private final static String COMMA = ",";

    public static List<Country> readFromFile(String pathFile) {
        List<Country> countryList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String[] listLine = null;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                listLine = line.split(COMMA);

                countryList.add(new Country(Integer.parseInt(listLine[0]), listLine[1], listLine[2]));
            }

            for (Country c : countryList) {
                System.out.println(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return countryList;
    }

    public static void main(String[] args) {
        ReadFile.readFromFile("src/ss15_text_file/bai_tap/ss2_read_csv_file/county.csv");
    }
}
