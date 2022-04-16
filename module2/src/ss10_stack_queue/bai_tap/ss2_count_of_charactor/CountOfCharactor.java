package ss10_stack_queue.bai_tap.ss2_count_of_charactor;

import java.util.Map;
import java.util.TreeMap;

public class CountOfCharactor {
    public static void main(String[] args) {
        String str = "abcDefabcFQzclAcFa";
        str = str.toUpperCase();

        Map<Character, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!treeMap.containsKey(str.charAt(i))) {
                treeMap.put(str.charAt(i), 1);
            } else {
                treeMap.put(str.charAt(i), (treeMap.get(str.charAt(i))+1));
            }
        }

        for (Map.Entry<Character,Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
