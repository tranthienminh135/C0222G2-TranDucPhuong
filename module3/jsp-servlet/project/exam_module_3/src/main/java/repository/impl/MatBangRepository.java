package repository.impl;

import connection.DBConnect;
import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;
import repository.IMatBangRepository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MatBangRepository implements IMatBangRepository {
    private DBConnect dbConnect = new DBConnect();
    private final String SELECT_ALL_MAT_BANG = " select * from `mat_bang` where `is_deleted` = 0 order by `dien_tich` ";
    private final String SELECT_ALL_TRANG_THAI = " select * from `trang_thai` ";
    private final String SELECT_ALL_LOAI_VAN_PHONG = " select * from `loai_van_phong` ";
    private final String DELETE_MAT_BANG = " update `mat_bang` " +
            " set `is_deleted` = 1 " +
            " where `ma_mat_bang` = ? ";
    private final String INSERT_MAT_BANG = " INSERT INTO `mat_bang` (`ma_mat_bang`, `dien_tich`, `ma_trang_thai`, `tang`, `ma_loai_van_phong`, `mo_ta_chi_tiet`, `gia_cho_thue`, `ngay_bat_dau`, `ngay_ket_thuc`) " +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?); ";
    private final String SEARCH_MAT_BANG = " select * " +
            " from mat_bang " +
            "         join loai_van_phong lvp on lvp.ma_loai_van_phong = mat_bang.ma_loai_van_phong " +
            " where (lvp.ma_loai_van_phong like ? and tang like ? and ngay_bat_dau between ? and ?) and `is_deleted` = 0 ";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<MatBang> getAllMatBang() {
        List<MatBang> matBangs = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MAT_BANG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("ma_mat_bang");
                double dienTich = resultSet.getDouble("dien_tich");
                int maTrangThai = resultSet.getInt("ma_trang_thai");
                int tang = resultSet.getInt("tang");
                int maLoaiVanPhong = resultSet.getInt("ma_loai_van_phong");
                String moTaChiTiet = resultSet.getString("mo_ta_chi_tiet");
                double giaChoThue = resultSet.getDouble("gia_cho_thue");
                Date ngayBatDau = resultSet.getDate("ngay_bat_dau");
                Date ngayKetThuc = resultSet.getDate("ngay_ket_thuc");
                int isDeleted = resultSet.getInt("is_deleted");
                MatBang matBang = new MatBang(maMatBang, dienTich, maTrangThai, tang, maLoaiVanPhong, moTaChiTiet, giaChoThue, ngayBatDau, ngayKetThuc, isDeleted);
                matBangs.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return matBangs;
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        List<TrangThai> trangThais = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANG_THAI);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maTrangThai = resultSet.getInt("ma_trang_thai");
                String tenTrangThai = resultSet.getString("ten_trang_thai");
                trangThais.add(new TrangThai(maTrangThai, tenTrangThai));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return trangThais;
    }

    @Override
    public List<LoaiVanPhong> getAllLoaiVanPhong() {
        List<LoaiVanPhong> loaiVanPhongs = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LOAI_VAN_PHONG);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maLoaiVanPhong = resultSet.getInt("ma_loai_van_phong");
                String tenLoaiVanPhong = resultSet.getString("ten_loai_van_phong");
                loaiVanPhongs.add(new LoaiVanPhong(maLoaiVanPhong, tenLoaiVanPhong));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return loaiVanPhongs;
    }

    @Override
    public void deleteMatBang(String idDelete) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MAT_BANG);
            preparedStatement.setString(1, idDelete);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addNewMatBang(MatBang matBang) {
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MAT_BANG);
            preparedStatement.setString(1,matBang.getMaMatBang());
            preparedStatement.setDouble(2,matBang.getDienTich());
            preparedStatement.setInt(3,matBang.getMaTrangThai());
            preparedStatement.setInt(4,matBang.getTang());
            preparedStatement.setInt(5,matBang.getMaLoaiVanPhong());
            preparedStatement.setString(6,matBang.getMoTaChiTiet());
            preparedStatement.setDouble(7,matBang.getGiaChoThue());
            preparedStatement.setDate(8,matBang.getNgayBatDau());
            preparedStatement.setDate(9,matBang.getNgayKetThuc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<MatBang> findMatBang(int maLoaiVanPhong, int tang, Date ngayBatDau, Date ngayKetThuc) {
        List<MatBang> matBangs = new ArrayList<>();
        Connection connection = dbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MAT_BANG);
            preparedStatement.setString(1, "%" + maLoaiVanPhong + "%");
            preparedStatement.setString(2, "%" + tang + "%");
            preparedStatement.setString(3, simpleDateFormat.format(ngayBatDau));
            preparedStatement.setString(4, simpleDateFormat.format(ngayKetThuc));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maMatBang = resultSet.getString("ma_mat_bang");
                double dienTich = resultSet.getDouble("dien_tich");
                int maTrangThai = resultSet.getInt("ma_trang_thai");
                int tang1 = resultSet.getInt("tang");
                int maLoaiVanPhong1 = resultSet.getInt("ma_loai_van_phong");
                String moTaChiTiet = resultSet.getString("mo_ta_chi_tiet");
                double giaChoThue = resultSet.getDouble("gia_cho_thue");
                Date ngayBatDau1 = resultSet.getDate("ngay_bat_dau");
                Date ngayKetThuc1 = resultSet.getDate("ngay_ket_thuc");
                int isDeleted = resultSet.getInt("is_deleted");
                MatBang matBang = new MatBang(maMatBang, dienTich, maTrangThai, tang1, maLoaiVanPhong1, moTaChiTiet, giaChoThue, ngayBatDau1, ngayKetThuc1, isDeleted);
                matBangs.add(matBang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return matBangs;
    }
}
