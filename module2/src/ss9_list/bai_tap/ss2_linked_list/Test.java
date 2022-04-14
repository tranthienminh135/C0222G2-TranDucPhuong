package ss9_list.bai_tap.ss2_linked_list;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.addFirst(100);
        myLinkedList.addFirst(200);
        myLinkedList.addFirst(300);
        myLinkedList.addFirst(400);
        myLinkedList.addFirst(500);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }

        myLinkedList.remove(2);
        System.out.println("------------");

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
        System.out.println("------------");

        System.out.println("First: " + myLinkedList.getFirst());
        System.out.println("Last: " + myLinkedList.getLast());

        System.out.println("------------");

        myLinkedList.clear();

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println(myLinkedList.get(i));
        }
    }
}
