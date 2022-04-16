package phuong.my_crud_project;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Staff extends Person {
    private int id;
    private int salary;
    private String job;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Enter salary: ");
        this.salary = Integer.parseInt((new Scanner(System.in)).nextLine());
        System.out.print("Enter job: ");
        this.job = (new Scanner(System.in)).nextLine();
    }

    @Override
    public String output() {
        Locale lc = new Locale("vi", "VN");
        NumberFormat nf = NumberFormat.getInstance(lc);
        return "ID: " + this.id + "\n" +
                super.output() +
                "Salary: " + nf.format(this.salary) + "\n" +
                "Job: " + this.job + "\n";
    }
}

