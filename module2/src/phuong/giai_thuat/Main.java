package phuong.giai_thuat;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Số lượng sinh viên: ");
        int n1 = Integer.parseInt((new Scanner(System.in).nextLine()));
        System.out.print("Số lượng kỳ thi: ");
        int n2 = Integer.parseInt((new Scanner(System.in).nextLine()));
        System.out.print("Số lượng mã đề: ");
        int n3 = Integer.parseInt((new Scanner(System.in).nextLine()));

        int[][][] arr = new int[n1][n2][n3];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print("Nhập điểm cho sinh viên thứ " + (i + 1) + " kỳ thi thứ " + (j + 1) + " mã đề " + (k + 1) + ": ");
                    arr[i][j][k] = Integer.parseInt((new Scanner(System.in).nextLine()));
                }
            }
        }
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print("Điểm cho sinh viên thứ " + i + " kỳ thi thứ " + j + " mã đề " + k + ": ");
                    System.out.println(arr[i][j][k]);
                }
            }
        }

        while (true) {
            System.out.println("Menu\n" +
                    "1. Tính điểm học sinh theo đề thi\n" +
                    "2. Tính điểm học sinh theo kỳ thi\n" +
                    "3. Tính điểm theo sinh viên\n" +
                    "0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt((new Scanner(System.in).nextLine()));
            switch (choice) {
                case 1:
                    tinhDiemTheoDeThi(arr);
                    break;
                case 2:
                    tinhDiemTheoKyThi(arr);
                    break;
                case 3:
                    tinhDiemTheoSinhVien(arr);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Nhập sai!");
                    break;
            }
        }
    }

    private static void tinhDiemTheoDeThi(int[][][] arr) {
        System.out.print("Nhập mã đề thi: ");
        int maDT = Integer.parseInt((new Scanner(System.in).nextLine()));
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j][maDT];
            }
        }
        System.out.println("Sum: " + sum);
    }

    private static void tinhDiemTheoSinhVien(int[][][] arr) {
        System.out.println("Nhập thông tin sinh viên cần tính điểm");
        System.out.print("Nhập mã học sinh: ");
        int maHS = Integer.parseInt((new Scanner(System.in).nextLine()));
        int sum = 0;
        for (int i = 0; i < arr[maHS].length; i++) {
            for (int j = 0; j < arr[maHS][i].length; j++) {
                sum += arr[maHS][i][j];
            }
        }
        System.out.println("Sum: " + sum);
    }

    private static void tinhDiemTheoKyThi(int[][][] arr) {
        System.out.println("Nhập thông tin sinh viên cần tính điểm");
        System.out.print("Nhập mã học sinh: ");
        int maHS = Integer.parseInt((new Scanner(System.in).nextLine()));
        System.out.print("Nhập mã kỳ thi: ");
        int maKT = Integer.parseInt((new Scanner(System.in).nextLine()));
        int sum = 0;
        for (int i = 0; i < arr[maHS][maKT].length; i++) {
            sum += arr[maHS][maKT][i];
        }
        System.out.println("Tổng điểm: " + sum);
    }
}
