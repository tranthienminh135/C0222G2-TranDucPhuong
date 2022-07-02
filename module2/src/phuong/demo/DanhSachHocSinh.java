package phuong.demo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DanhSachHocSinh {
    private static Scanner scanner = new Scanner(System.in);
    private final static String COMMA = ",";
    private final static String FILE_NAME_BAN_A = "src/phuong/demo/bana.text";
    private final static String FILE_NAME_BAN_B = "src/phuong/demo/banb.text";

    public static void main(String[] args) {
        while (true) {
            System.out.println("Danh Sach Hoc Sinh\n" +
                    "1. Danh sach\n" +
                    "2. Them moi\n" +
                    "3. Tim kiem\n" +
                    "4. Tinh diem trung binh\n" +
                    "0. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    chonBanHienThi();
                    break;
                case 2:
                    chonBanThemMoi();
                    break;
                case 3:
                    chonBanTimKiem();
                    break;
                case 4:
                    diemTrungBinhBanA();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chon lai");
                    break;
            }
        }
    }

    private static void chonBanThemMoi() {
        while (true) {
            System.out.println("Danh Sach Ban\n" +
                    "1. Ban A\n" +
                    "2. Ban B\n" +
                    "0. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    themMoiBanA();
                    break;
                case 2:
                    themMoiBanB();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chon lai");
                    break;
            }
        }
    }

    private static void chonBanHienThi() {
        while (true) {
            System.out.println("Danh Sach Ban\n" +
                    "1. Ban A\n" +
                    "2. Ban B\n" +
                    "0. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    danhSachBanA();
                    break;
                case 2:
                    danhSachBanB();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chon lai");
                    break;
            }
        }
    }

    private static void chonBanTimKiem() {
        while (true) {
            System.out.println("Danh Sach Ban\n" +
                    "1. Ban A\n" +
                    "2. Ban B\n" +
                    "0. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    timKiemBanA();
                    break;
                case 2:
                    timKiemBanB();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Chon lai");
                    break;
            }
        }
    }

    private static void timKiemBanA() {
        List<BanA> banAList = readBanA(FILE_NAME_BAN_A);
        boolean flag = true;
        System.out.print("Nhap ma hoc sinh muon tim: ");
        int maHS = Integer.parseInt(scanner.nextLine());
        for (BanA banA : banAList) {
            if (banA.getMaHocSinh() == maHS) {
                System.out.println(banA);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Ma hoc sinh ko ton tai");
        }
    }

    private static void timKiemBanB() {
        List<BanB> banBList = readBanB(FILE_NAME_BAN_B);
        boolean flag = true;
        System.out.print("Nhap ma hoc sinh muon tim: ");
        int maHS = Integer.parseInt(scanner.nextLine());
        for (BanB banB : banBList) {
            if (banB.getMaHocSinh() == maHS) {
                System.out.println(banB);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Ma hoc sinh ko ton tai");
        }
    }

    private static void diemTrungBinhBanA() {
        List<BanA> banAList = readBanA(FILE_NAME_BAN_A);
        for (BanA banA : banAList) {
            System.out.println("Diem trung binh cua hoc sinh " + banA.getName() + " la: " + banA.getDiemTrungBinh());
        }
    }

    private static void themMoiBanA() {
        List<BanA> banAList = readBanA(FILE_NAME_BAN_A);
        System.out.print("Nhap ma hoc sinh: ");
        int maHS = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.print("Nhap ngay sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.print("Nhap gioi tinh:  ");
        String gioitinh = scanner.nextLine();
        System.out.print("Nhap lop: ");
        String clazz = scanner.nextLine();
        System.out.print("Nhap diem toan: ");
        double math = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap diem hoa: ");
        double chemistry = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap diem ly: ");
        double physical = Double.parseDouble(scanner.nextLine());
        banAList.add(new BanA(maHS, name, ngaySinh, gioitinh, clazz, math, chemistry, physical));
        writeBanA(FILE_NAME_BAN_A, banAList);
    }

    private static void themMoiBanB() {
        List<BanB> banB = readBanB(FILE_NAME_BAN_B);
        System.out.print("Nhap ma hoc sinh: ");
        int maHS = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap ten: ");
        String name = scanner.nextLine();
        System.out.print("Nhap ngay sinh: ");
        String ngaySinh = scanner.nextLine();
        System.out.print("Nhap gioi tinh:  ");
        String gioitinh = scanner.nextLine();
        System.out.print("Nhap lop: ");
        String clazz = scanner.nextLine();
        System.out.print("Nhap diem toan: ");
        double math = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap diem hoa: ");
        double chemistry = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap diem sinh: ");
        double biological = Double.parseDouble(scanner.nextLine());
        banB.add(new BanB(maHS, name, ngaySinh, gioitinh, clazz, math, chemistry, biological));
        writeBanB(FILE_NAME_BAN_B, banB);
    }


    private static void danhSachBanA() {
        List<BanA> banAList = readBanA(FILE_NAME_BAN_A);
        for (BanA banA : banAList) {
            System.out.println(banA);
        }
    }

    private static void danhSachBanB() {
        List<BanB> banBList = readBanB(FILE_NAME_BAN_B);
        for (BanB banB : banBList) {
            System.out.println(banB);
        }
    }

    private static void writeToFile(String pathFile, List<String> strings) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBanA(String pathFile, List<BanA> banAList) {
        List<String> strings = new ArrayList<>();
        for (BanA banA : banAList) {
            strings.add(banA.getMaHocSinh() + COMMA + banA.getName()
                    + COMMA + banA.getDayOfBirth() + COMMA + banA.getGender()
                    + COMMA + banA.getClazz() + COMMA + banA.getMath()
                    + COMMA + banA.getChemistry() + COMMA + banA.getPhysical());
        }
        writeToFile(pathFile, strings);
    }

    private static void writeBanB(String pathFile, List<BanB> banAList) {
        List<String> strings = new ArrayList<>();
        for (BanB banB : banAList) {
            strings.add(banB.getMaHocSinh() + COMMA + banB.getName()
                    + COMMA + banB.getDayOfBirth() + COMMA + banB.getGender()
                    + COMMA + banB.getClazz() + COMMA + banB.getMath()
                    + COMMA + banB.getChemistry() + COMMA + banB.getBiological());
        }
        writeToFile(pathFile, strings);
    }

    private static List<String> readFromFile(String pathFile) {
        List<String> strings = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while (true) {
                line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                strings.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public static List<BanA> readBanA(String pathFile) {
        List<BanA> banA = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            banA.add(new BanA(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4],
                    Double.parseDouble(lines[5]), Double.parseDouble(lines[6]), Double.parseDouble(lines[7])));
        }
        return banA;
    }

    public static List<BanB> readBanB(String pathFile) {
        List<BanB> BanB = new ArrayList<>();
        List<String> strings = readFromFile(pathFile);

        String[] lines;
        for (String s : strings) {
            lines = s.split(COMMA);
            BanB.add(new BanB(Integer.parseInt(lines[0]), lines[1], lines[2], lines[3], lines[4],
                    Double.parseDouble(lines[5]), Double.parseDouble(lines[6]), Double.parseDouble(lines[7])));
        }
        return BanB;
    }
}
