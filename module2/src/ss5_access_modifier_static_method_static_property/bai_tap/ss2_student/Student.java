package ss5_access_modifier_static_method_static_property.bai_tap.ss2_student;

public class Student {
    private String name = "John";
    private String clazz = "C02";

    public Student() {
    }

    protected void setName(String name) {
        this.name = name;
    }

    void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}
