package phuong.case_study.furama_manager.model.person;


import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
    private String id;
    private String name;
    private Date dayOfBirth;
    private String gender;
    private Long idCard;
    private Long phoneNumber;
    private String mail;

    public Person() {
    }

    public Person(String id, String name, Date date, String gender, Long idCard, Long phoneNumber, String mail) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = date;
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

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
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
        final String PATTERN = "dd-MM-yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        return " id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", day of birth = " + dateFormat.format(dayOfBirth) +
                ", gender = '" + gender + '\'' +
                ", idCard = " + idCard +
                ", phoneNumber = " + phoneNumber +
                ", mail = '" + mail + '\'' +
                '}';
    }
}
