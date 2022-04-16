package ss10_stack_queue.bai_tap.ss4_palindrome;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        boolean flag = false;

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i) + "");
            queue.offer(str.charAt(i)+ "");
        }

        for (int i = 0; i < str.length(); i++) {
            if (stack.pop().equalsIgnoreCase(queue.poll())) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("\"" + str + "\" is palindrome!");
        } else {
            System.out.println("\"" + str + "\" is NOT palindrome!");
        }
    }
}
