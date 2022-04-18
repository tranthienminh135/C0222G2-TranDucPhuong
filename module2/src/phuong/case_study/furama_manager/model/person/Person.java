package phuong.case_study.furama_manager.model.person;


public abstract class Person {
    private String id;
    private String name;
    private String date;
    private String gender;
    private Long idCard;
    private Long phoneNumber;
    private String mail;

    public Person() {
    }

    public Person(String id, String name, String date, String gender, Long idCard, Long phoneNumber, String mail) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
        return " id = '" + id + '\'' +
                ", name = '" + name + '\'' +
                ", date = " + date +
                ", gender = '" + gender + '\'' +
                ", idCard = " + idCard +
                ", phoneNumber = " + phoneNumber +
                ", mail = '" + mail + '\'' +
                '}';
    }
}
