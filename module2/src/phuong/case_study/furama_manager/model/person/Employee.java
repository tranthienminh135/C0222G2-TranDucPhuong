package phuong.case_study.furama_manager.model.person;

import java.util.Date;

public class Employee extends Person{
    private String level;
    private String position;
    private Double salary;

    public Employee() {
    }

    public Employee(String level, String position, Double salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String id, String name, Date date, String gender, Long idCard, Long phoneNumber, String mail, String level, String position, Double salary) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee {" +
                super.toString() +
                ", level = '" + level + '\'' +
                ", position = '" + position + '\'' +
                ", salary = " + salary +
                " }";
    }
}
