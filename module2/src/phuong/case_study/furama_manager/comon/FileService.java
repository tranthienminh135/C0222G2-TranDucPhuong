package phuong.case_study.furama_manager.comon;

import phuong.case_study.furama_manager.model.person.Employee;
import phuong.case_study.furama_manager.model.person.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    private static void writeToFile(String pathFile, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = null;
            for (String s: list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeEmployee(String pathFile, List<Employee> employees) {
        List<String> list = new ArrayList<>();
        for (Employee e: employees) {
            list.add(e.convertLine());
        }
        writeToFile(pathFile,list);
    }
}
