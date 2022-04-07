package my_crud_project;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class OfficeStaff extends Staff {
    private int timeForWork;
    private int dayOfAbsent;
    private int dayForWork;

    public int getTimeForWork() {
        return timeForWork;
    }

    public void setTimeForWork(int timeForWork) {
        this.timeForWork = timeForWork;
    }

    public int getDayOfAbsent() {
        return dayOfAbsent;
    }

    public void setDayOfAbsent(int dayOfAbsent) {
        this.dayOfAbsent = dayOfAbsent;
    }

    public int getDayForWork() {
        return dayForWork;
    }

    public void setDayForWork(int dayForWork) {
        this.dayForWork = dayForWork;
    }

    public int originalIncome() {
        return this.timeForWork * super.getSalary() * this.dayForWork;
    }

    public int totalIncome(int soNgayNghi) {
        return this.originalIncome() - (soNgayNghi * this.timeForWork * super.getSalary());
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Enter time for work (hour): ");
        this.timeForWork = Integer.parseInt((new Scanner(System.in).nextLine()));
        System.out.print("Enter day of Absent: ");
        this.dayOfAbsent = Integer.parseInt((new Scanner(System.in).nextLine()));
        System.out.print("Enter day for work: ");
        this.dayForWork = Integer.parseInt((new Scanner(System.in).nextLine()));
    }

    @Override
    public String output() {
        Locale lc = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getInstance(lc);
        return "--------------\n" +
                super.output() +
                "Time for work: " + this.timeForWork + "\n" +
                "Day for work: " + this.dayForWork + "\n" +
                "Day of Absent: " + this.dayOfAbsent + "\n" +
                "Original income: " + nf.format(this.originalIncome()) + "\n" +
                "Total income: " + nf.format(this.totalIncome(this.dayOfAbsent)) + "\n";
    }
}
