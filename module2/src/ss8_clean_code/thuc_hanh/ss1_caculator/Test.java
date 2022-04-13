package ss8_clean_code.thuc_hanh.ss1_caculator;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test {
    public static void main(String[] args) {
        testCalculateAdd();
        testCalculateSub();
        testCalculateDiv();
        testCalculateMul();
        testCalculateDivByZero();
        testCalculateWrongOperator();

    }

    static void testCalculateAdd() {
        int firstOperand = 1;
        int secondOperand = 1;
        char operator = '+';

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        System.out.println(result);
    }

    static void testCalculateSub() {
        int firstOperand = 2;
        int secondOperand = 1;
        char operator = '-';

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        System.out.println(result);
    }

    static void testCalculateMul() {
        int firstOperand = 2;
        int secondOperand = 2;
        char operator = '*';

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        System.out.println(result);
    }

    static void testCalculateDiv() {
        int firstOperand = 6;
        int secondOperand = 3;
        char operator = '/';

        int result = Calculator.calculate(firstOperand, secondOperand, operator);
        System.out.println(result);
    }

    static void testCalculateDivByZero() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operator = '/';

        try {
            int result = Calculator.calculate(firstOperand, secondOperand, operator);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    static void testCalculateWrongOperator() {
        int firstOperand = 2;
        int secondOperand = 0;
        char operator = '=';

        try {
            int result = Calculator.calculate(firstOperand, secondOperand, operator);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
