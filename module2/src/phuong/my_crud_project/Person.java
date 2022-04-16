package phuong.my_crud_project;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void input() {
        System.out.print("Enter name: ");
        this.name = (new Scanner(System.in)).nextLine();
        System.out.print("Enter age: ");
        this.age = Integer.parseInt((new Scanner(System.in)).nextLine());
    }

    public String output() {
        return "Name: " + this.name + "\n" +
                "Age: " + this.age + "\n";
    }
}
