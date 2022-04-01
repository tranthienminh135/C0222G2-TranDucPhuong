package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so tien gui: ");
        int soTienGoc = sc.nextInt();
        System.out.print("Nhap lai suat: ");
        float laiSuat = sc.nextFloat();
        System.out.print("Nhap so thang gui: ");
        int soThangGui = sc.nextInt();
        float count = 0;

        for (int i = 0; i < soThangGui; i++) {
            float soTienLai = (laiSuat / 100) * soTienGoc;
            count += soTienLai;
            soTienGoc += soTienLai;
            System.out.println("Thang: " + (i + 1) + "\n" + "So tien lai: " + soTienLai + "\n" + "Lai suat: " + laiSuat + "%" + "\n" + "So tien goc: " + soTienGoc + "\n" + "-------");
        }
        System.out.println("So tien goc sau " + soThangGui + " thang gui: " + soTienGoc);
        System.out.println("So tien lai sau " + soThangGui + " thang gui: " + count);
    }
}
