package repository;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;

import java.sql.Date;
import java.util.List;

public interface IMatBangRepository {
    List<MatBang> getAllMatBang();

    List<TrangThai> getAllTrangThai();

    List<LoaiVanPhong> getAllLoaiVanPhong();

    void deleteMatBang(String idDelete);

    void addNewMatBang(MatBang matBang);

    List<MatBang> findMatBang(int maLoaiVanPhong, int tang, Date ngayBatDau, Date ngayKetThuc);
}
