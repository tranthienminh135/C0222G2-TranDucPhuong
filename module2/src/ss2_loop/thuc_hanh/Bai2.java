package ss2_loop.thuc_hanh;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so tien gui: ");
        int soTiengui = sc.nextInt();
        System.out.print("Nhap lai suat: ");
        int laiSuat = sc.nextInt();
        float soTienLai = (laiSuat/100) * soTiengui;
        System.out.println(soTienLai);
    }
}
