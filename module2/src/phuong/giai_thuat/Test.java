package phuong.giai_thuat;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String a = "abcdbcef";
        String b = "abcef";

        String[] strings = findChar(a);

        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i]);
        }
    }

    public static String[] findChar(String arg1) {
        String[] strings;
        strings = arg1.split("");
        String temp = "";
        int count;
        for (int i = 0; i < strings.length; i++) {
            count = 0;
            for (int j = i; j < strings.length; j++) {
                if (strings[i].equals(strings[j])) {
                    count++;
                }
            }
            if (count > 1) {
                temp += strings[i];
            }
        }
        if (!temp.equals("")) {
            strings = temp.split("");
        } else {
            strings = new String[0];
        }
        return strings;
    }
}
