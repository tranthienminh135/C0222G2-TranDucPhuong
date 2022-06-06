package model.employee;

public class EducationDegree {
    private Integer educationDegreeId;
    private String educationDegreeName;
    private Integer status;

    public EducationDegree() {
    }

    public EducationDegree(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public EducationDegree(Integer educationDegreeId, String educationDegreeName, Integer status) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.status = status;
    }

    public Integer getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(Integer educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EducationDegree{" +
                "educationDegreeId=" + educationDegreeId +
                ", educationDegreeName='" + educationDegreeName + '\'' +
                ", status=" + status +
                '}';
    }
}
