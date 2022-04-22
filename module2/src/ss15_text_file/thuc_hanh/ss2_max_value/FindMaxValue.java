package ss15_text_file.thuc_hanh.ss2_max_value;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("src/ss15_text_file/thuc_hanh/ss2_max_value/numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("src/ss15_text_file/thuc_hanh/ss2_max_value/result.txt", maxValue);
    }
}
