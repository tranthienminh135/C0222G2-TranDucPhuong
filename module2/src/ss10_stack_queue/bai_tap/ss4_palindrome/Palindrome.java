package ss10_stack_queue.bai_tap.ss4_palindrome;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";

        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i) + "");
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(stack.pop());
        }

        System.out.println();

        for (int i = 0; i < str.length(); i++) {
            queue.offer(str.charAt(i)+ "");
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(queue.poll());
        }
    }
}
