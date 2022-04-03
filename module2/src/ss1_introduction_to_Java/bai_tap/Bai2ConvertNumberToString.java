package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class Bai2ConvertNumberToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        String number = sc.nextLine();

        int temp = Integer.parseInt(number);
        number = temp + "";

        String[] arrNumber = number.split("");

        if (Integer.parseInt(number) < 10) {
            if (number.equals("0")) {
                System.out.println("Zero");
            } else {
                System.out.println(lessThanTen(number));
            }
        } else if (Integer.parseInt(number) < 100) {
            System.out.println(greaterThanTen(arrNumber[0], lessThanTen(arrNumber[1])));
        } else if (Integer.parseInt(number) < 1000){
            System.out.println(greaterThanOneHundred(arrNumber[0], arrNumber[1], lessThanTen(arrNumber[2])));
        }

    }


    public static String lessThanTen(String number) {
        switch (number) {
            case "0":
                return "";
            case "1":
                return "One";
            case "2":
                return "Two";
            case "3":
                return "Three";
            case "4":
                return "Four";
            case "5":
                return "Five";
            case "6":
                return "Six";
            case "7":
                return "Seven";
            case "8":
                return "Eight";
            case "9":
                return "Nine";
            default:
                return "Out of ability";
        }
    }

    public static String greaterThanTen(String number, String value) {
        switch (number) {
            case "1":
                switch (value) {
                    case "":
                        return "Ten";
                    case "One":
                        return "Eleven";
                    case "Two":
                        return "Twelve";
                    case "Three":
                        return "Thirteen";
                    case "Five":
                        return "Fifteen";
                    default:
                        return value + "teen";
                }
            case "2":
                switch (value) {
                    case "":
                        return "Twenty";
                    default:
                        return "Twenty-" + value.toLowerCase();
                }
            case "3":
                switch (value) {
                    case "":
                        return "Thirty";
                    default:
                        return "Thirty-" + value.toLowerCase();
                }
            case "5":
                switch (value) {
                    case "":
                        return "Fifty";
                    default:
                        return "Fifty-" + value.toLowerCase();
                }
            default:
                switch (value) {
                    case "":
                        return lessThanTen(number) + "ty";
                    default:
                        return lessThanTen(number) + "ty-" + value.toLowerCase();
                }
        }
    }
    public static String greaterThanOneHundred(String number, String value1, String value2) {
        switch (number) {
            default:
                switch (value1) {
                    case "0":
                        switch (value2) {
                            case "":
                            return lessThanTen(number) + " hundress";
                        }
                    default:
                        switch (value1) {
                            case "0":
                                return lessThanTen(number) + " hundress and " + value2.toLowerCase();
                            default:
                                return lessThanTen(number) + " hundress and " + greaterThanTen(value1,value2).toLowerCase();
                        }
                }
        }
    }
}
