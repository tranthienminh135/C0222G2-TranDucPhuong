package model;

public class TrangThai {
    private Integer maTrangThai;
    private String tenTrangThai;

    public TrangThai() {
    }

    public TrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    public TrangThai(Integer maTrangThai, String tenTrangThai) {
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
    }

    public Integer getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(Integer maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }

    @Override
    public String toString() {
        return "TrangThai{" +
                "maTrangThai=" + maTrangThai +
                ", tenTrangThai='" + tenTrangThai + '\'' +
                '}';
    }
}
