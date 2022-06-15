package controller;

import model.LoaiVanPhong;
import model.MatBang;
import model.TrangThai;
import service.IMatBangService;
import service.impl.MatBangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@WebServlet(name = "MatBangController", value = "/home")
public class MatBangController extends HttpServlet {
    private IMatBangService matBangService = new MatBangService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                int maLoaiVanPhong = Integer.parseInt(request.getParameter("maloaiVanPhong"));
                int tang = Integer.parseInt(request.getParameter("tang"));
                Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
                Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
                List<MatBang> matBangs = matBangService.findMatBang(maLoaiVanPhong,tang,ngayBatDau,ngayKetThuc);
                List<TrangThai> trangThais = matBangService.getAllTrangThai();
                List<LoaiVanPhong> loaiVanPhongs = matBangService.getAllLoaiVanPhong();

                request.setAttribute("maloaiVanPhong", maLoaiVanPhong);
                request.setAttribute("tang", tang);
                request.setAttribute("ngayBatDau", ngayBatDau);
                request.setAttribute("ngayKetThuc", ngayKetThuc);
                request.setAttribute("matBangs", matBangs);
                request.setAttribute("trangThais", trangThais);
                request.setAttribute("loaiVanPhongs", loaiVanPhongs);
                request.getRequestDispatcher("list.jsp").forward(request, response);
                break;
            case "create":
                showFormCreate(request, response);
                break;
            case "delete":
                deleteMatBang(request, response);
                break;
            default:
                showListMatBang(request, response);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TrangThai> trangThais = matBangService.getAllTrangThai();
        List<LoaiVanPhong> loaiVanPhongs = matBangService.getAllLoaiVanPhong();
        request.setAttribute("trangThais", trangThais);
        request.setAttribute("loaiVanPhongs", loaiVanPhongs);
        request.getRequestDispatcher("create.jsp").forward(request, response);
    }

    private void deleteMatBang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idDelete = request.getParameter("idDelete");
        matBangService.deleteMatBang(idDelete);
        response.sendRedirect("/home");
    }

    private void showListMatBang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MatBang> matBangs = matBangService.getAllMatBang();
        List<TrangThai> trangThais = matBangService.getAllTrangThai();
        List<LoaiVanPhong> loaiVanPhongs = matBangService.getAllLoaiVanPhong();

        request.setAttribute("matBangs", matBangs);
        request.setAttribute("trangThais", trangThais);
        request.setAttribute("loaiVanPhongs", loaiVanPhongs);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            default:
                showListMatBang(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String maMatBang = request.getParameter("maMatBang");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        int maTrangThai = Integer.parseInt(request.getParameter("maTrangThai"));
        int tang = Integer.parseInt(request.getParameter("tang"));
        int loaiVanPhong = Integer.parseInt(request.getParameter("loaiVanPhong"));
        String moTaChiTiet = request.getParameter("moTaChiTiet");
        double giaChoThue = Double.parseDouble(request.getParameter("giaChoThue"));
        Date ngayBatDau = Date.valueOf(request.getParameter("ngayBatDau"));
        Date ngayKetThuc = Date.valueOf(request.getParameter("ngayKetThuc"));
        MatBang matBang = new MatBang(maMatBang,dienTich,maTrangThai,tang,loaiVanPhong,moTaChiTiet,giaChoThue,ngayBatDau,ngayKetThuc);
        Map<String, String> errMap = matBangService.addNewMatBang(matBang);

        if (errMap.isEmpty()) {
            response.sendRedirect("/home");
        } else {
            request.setAttribute("errMap", errMap);
            request.setAttribute("matBang", matBang);
            request.getRequestDispatcher("create.jsp").forward(request,response);
        }
    }
}
