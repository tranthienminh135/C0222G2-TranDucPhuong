package ss9_list.bai_tap.ss1_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        System.out.println("Size before: " + myList.size());

        List<Integer> list = new ArrayList<>(10);
        System.out.println("size: " + list.size());

        List<Integer> integerList = new LinkedList<>();


        myList.add(100);
        myList.add(200);
        myList.add(300);
        myList.add(400);
        myList.add(1, 12);

        myList.remove(2);

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
