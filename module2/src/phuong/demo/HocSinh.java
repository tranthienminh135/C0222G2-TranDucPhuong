package phuong.demo;

public abstract class HocSinh {
    private Integer maHocSinh;
    private String name;
    private String dayOfBirth;
    private String gender;
    private String clazz;
    private Double math;
    private Double chemistry;

    public HocSinh() {
    }

    public HocSinh(Integer maHocSinh, String name, String dayOfBirth, String gender, String clazz, Double math, Double chemistry) {
        this.maHocSinh = maHocSinh;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.clazz = clazz;
        this.math = math;
        this.chemistry = chemistry;
    }

    public Integer getMaHocSinh() {
        return maHocSinh;
    }

    public void setMaHocSinh(Integer maHocSinh) {
        this.maHocSinh = maHocSinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public Double getMath() {
        return math;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public Double getChemistry() {
        return chemistry;
    }

    public void setChemistry(Double chemistry) {
        this.chemistry = chemistry;
    }

    public abstract Double getDiemTrungBinh();

    @Override
    public String toString() {
        return "HocSinh{" +
                "maHocSinh=" + maHocSinh +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", clazz='" + clazz + '\'' +
                ", math=" + math +
                ", chemistry=" + chemistry +
                '}';
    }
}
