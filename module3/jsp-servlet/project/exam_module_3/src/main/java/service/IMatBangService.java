package service;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface IMatBangService {
    List<MatBang> getAllMatBang();

    List<TrangThai> getAllTrangThai();

    List<LoaiVanPhong> getAllLoaiVanPhong();

    void deleteMatBang(String idDelete);

    Map<String, String> addNewMatBang(MatBang matBang);

    List<MatBang> findMatBang(int maLoaiVanPhong, int tang, Date ngayBatDau, Date ngayKetThuc);
}
