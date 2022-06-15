package service.impl;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;
import repository.IMatBangRepository;
import repository.impl.MatBangRepository;
import service.IMatBangService;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatBangService implements IMatBangService {
    private IMatBangRepository matBangRepository = new MatBangRepository();

    @Override
    public List<MatBang> getAllMatBang() {
        return matBangRepository.getAllMatBang();
    }

    @Override
    public List<TrangThai> getAllTrangThai() {
        return matBangRepository.getAllTrangThai();
    }

    @Override
    public List<LoaiVanPhong> getAllLoaiVanPhong() {
        return matBangRepository.getAllLoaiVanPhong();
    }

    @Override
    public void deleteMatBang(String idDelete) {
        matBangRepository.deleteMatBang(idDelete);
    }

    @Override
    public Map<String, String> addNewMatBang(MatBang matBang) {
        Map<String, String> errMap = new HashMap<>();
        if (matBang.getDienTich() <= 20) {
            errMap.put("errDienTich", "Diện tích phải lớn hơn 20m2");
        }
        if (!(matBang.getTang() > 1 || matBang.getTang() <= 15)) {
            errMap.put("errTang", "Số tầng phải bắt đầu từ 1 - 15");
        }
        if (matBang.getGiaChoThue() < 1000000) {
            errMap.put("errGiaChoThue", "Giá cho thuê phải lớn hơn 1000000");
        }
            if (errMap.isEmpty()) {
                matBangRepository.addNewMatBang(matBang);
            }
        return errMap;
    }

    @Override
    public List<MatBang> findMatBang(int maLoaiVanPhong, int tang, Date ngayBatDau, Date ngayKetThuc) {
        return matBangRepository.findMatBang(maLoaiVanPhong, tang, ngayBatDau, ngayKetThuc);
    }
}
