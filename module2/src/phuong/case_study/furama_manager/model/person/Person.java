package phuong.case_study.furama_manager.model.person;

import java.sql.Date;

public abstract class Person {
    private String id;
    private String name;
    private Date date;
    private String gender;
    private int idCard;
    private int phoneNumber;
    private String mail;

    public Person() {
    }

    public Person(String id, String name, Date date, String gender, int idCard, int phoneNumber, String mail) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return ", id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", date = " + date +
                ", gender = '" + gender + '\'' +
                ", idCard = " + idCard +
                ", phoneNumber = " + phoneNumber +
                ", mail = '" + mail + '\'' +
                '}';
    }
}
