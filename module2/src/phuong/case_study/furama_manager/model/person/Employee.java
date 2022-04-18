package phuong.case_study.furama_manager.model.person;

import java.sql.Date;

public class Employee extends Person{
    private String level;
    private String position;
    private long salary;

    public Employee() {
    }

    public Employee(String level, String position, long salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String id, String name, Date date, String gender, int idCard, int phoneNumber, String mail, String level, String position, long salary) {
        super(id, name, date, gender, idCard, phoneNumber, mail);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer {" +
                super.toString() +
                ", level = '" + level + '\'' +
                ", position = '" + position + '\'' +
                ", salary = " + salary +
                '}';
    }
}
