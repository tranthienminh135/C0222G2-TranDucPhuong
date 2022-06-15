package model;

import java.sql.Date;

public class MatBang {
    private String maMatBang;
    private Double dienTich;
    private Integer maTrangThai;
    private Integer tang;
    private Integer maLoaiVanPhong;
    private String moTaChiTiet;
    private Double giaChoThue;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Integer isDeleted;

    public MatBang() {
    }

    public MatBang(String maMatBang, Double dienTich, Integer maTrangThai, Integer tang, Integer maLoaiVanPhong, String moTaChiTiet, Double giaChoThue, Date ngayBatDau, Date ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.maTrangThai = maTrangThai;
        this.tang = tang;
        this.maLoaiVanPhong = maLoaiVanPhong;
        this.moTaChiTiet = moTaChiTiet;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(String maMatBang, Double dienTich, Integer maTrangThai, Integer tang, Integer maLoaiVanPhong, String moTaChiTiet, Double giaChoThue, Date ngayBatDau, Date ngayKetThuc, Integer isDeleted) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.maTrangThai = maTrangThai;
        this.tang = tang;
        this.maLoaiVanPhong = maLoaiVanPhong;
        this.moTaChiTiet = moTaChiTiet;
        this.giaChoThue = giaChoThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.isDeleted = isDeleted;
    }

    public String getMaMatBang() {
        return maMatBang;
    }

    public void setMaMatBang(String maMatBang) {
        this.maMatBang = maMatBang;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public Integer getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(Integer maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public Integer getTang() {
        return tang;
    }

    public void setTang(Integer tang) {
        this.tang = tang;
    }

    public Integer getMaLoaiVanPhong() {
        return maLoaiVanPhong;
    }

    public void setMaLoaiVanPhong(Integer maLoaiVanPhong) {
        this.maLoaiVanPhong = maLoaiVanPhong;
    }

    public String getMoTaChiTiet() {
        return moTaChiTiet;
    }

    public void setMoTaChiTiet(String moTaChiTiet) {
        this.moTaChiTiet = moTaChiTiet;
    }

    public Double getGiaChoThue() {
        return giaChoThue;
    }

    public void setGiaChoThue(Double giaChoThue) {
        this.giaChoThue = giaChoThue;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "MatBang{" +
                "maMatBang='" + maMatBang + '\'' +
                ", dienTich=" + dienTich +
                ", maTrangThai=" + maTrangThai +
                ", tang=" + tang +
                ", maLoaiVanPhong=" + maLoaiVanPhong +
                ", moTaChiTiet='" + moTaChiTiet + '\'' +
                ", giaChoThue=" + giaChoThue +
                ", ngayBatDau=" + ngayBatDau +
                ", ngayKetThuc=" + ngayKetThuc +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
