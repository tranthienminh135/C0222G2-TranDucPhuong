package ss10_stack_queue.bai_tap.ss3_decimal_to_binary;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {

        System.out.print("Enter decimal: ");
        int decimal = Integer.parseInt((new Scanner(System.in)).nextLine());
        int temp = decimal;
        StringBuilder binary = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }
        for (Integer e: stack) {
            System.out.println(e);
        }
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }
        System.out.println(temp + " Decimal = " + binary + " Binary");
    }
}
