package ss15_text_file.bai_tap.ss1_copy_file;

import java.io.*;
import java.util.Scanner;

public class FileService {
    private static Scanner sc = new Scanner(System.in);
    public static String readFile(String filePath) {
        String str = "";
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            FileInputStream fileInputStream = new FileInputStream(file);

            int count = 0;
            int c = fileInputStream.read();

            while (c != -1) {
                str += (char) c;
                c = fileInputStream.read();
                count++;
            }
            System.out.println("Count of characters: " + count);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not exists!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return str;
    }

    public static void writeFile(String filepath, String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filepath);
            fileOutputStream.write(str.getBytes());

            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not exists!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter link of file source: ");
        String fileSourceName = sc.nextLine();
        System.out.print("Enter link of file target: ");
        String fileTargetName = sc.nextLine();
        String str = FileService.readFile(fileSourceName);
        FileService.writeFile(fileTargetName,str);
    }
}
