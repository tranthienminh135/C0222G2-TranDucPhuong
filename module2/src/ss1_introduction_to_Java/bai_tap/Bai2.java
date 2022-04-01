package ss1_introduction_to_Java.bai_tap;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        String number = sc.nextLine();

        String[] arrNumber = number.split("");

        if (Integer.parseInt(number) < 10) {
            if (number.equals("0")) {
                System.out.println("Zero");
            } else {
                System.out.println(letThanTen(number));
            }
        } else if (Integer.parseInt(number) < 100) {
            System.out.println(greaterThanTen(arrNumber[0], letThanTen(arrNumber[1])));
        } else if (Integer.parseInt(number) < 1000){
            System.out.println(greaterThanOneHundred(arrNumber[0], arrNumber[1], letThanTen(arrNumber[2])));
        }

    }


    public static String letThanTen(String number) {
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
                        return letThanTen(number) + "ty";
                    default:
                        return letThanTen(number) + "ty-" + value.toLowerCase();
                }
        }
    }
    public static String greaterThanOneHundred(String number, String value1, String value2) {
        switch (number) {
            default:
                switch (value1) {
                    case "":
                        switch (value2) {
                            case "":
                            return letThanTen(number) + " hundress";
                        }
                    default:
                        switch (value1) {
                            case "0":
                                return letThanTen(number) + " hundress and " + value2.toLowerCase();
                            default:
                                return letThanTen(number) + " hundress and " + greaterThanTen(value1,value2).toLowerCase();
                        }
                }
        }
    }
}
