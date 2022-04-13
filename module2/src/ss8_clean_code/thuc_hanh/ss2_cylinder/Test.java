package ss8_clean_code.thuc_hanh.ss2_cylinder;

public class Test {
    public static void main(String[] args) {
        testGetVolume0And0();
        testGetVolume1And2();
    }

    static void testGetVolume0And0() {
        int radius = 0;
        int height = 0;

        double result = Cylinder.getVolume(radius, height);
        System.out.println(result);
    }

    static void testGetVolume1And2() {
        int radius = 1;
        int height = 2;

        double result = Cylinder.getVolume(radius, height);
        System.out.println(result);
    }
}
