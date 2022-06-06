package model.employee;

public class Position {
    private Integer positionId;
    private String positionName;
    private Integer status;

    public Position() {
    }

    public Position(String positionName) {
        this.positionName = positionName;
    }

    public Position(Integer positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public Position(Integer positionId, String positionName, Integer status) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.status = status;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName='" + positionName + '\'' +
                ", status=" + status +
                '}';
    }
}
