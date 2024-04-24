package com.ph34757.sof3011.controllers.hoaDon;

import com.ph34757.sof3011.controllers.khachHang.KhachHangServlet;
import com.ph34757.sof3011.entities.Ctsp;
import com.ph34757.sof3011.entities.Hdct;
import com.ph34757.sof3011.entities.HoaDon;
import com.ph34757.sof3011.entities.KhachHang;
import com.ph34757.sof3011.repositories.HoaDonChiTietRepo;
import com.ph34757.sof3011.repositories.HoaDonRepo;
import com.ph34757.sof3011.repositories.KhachHangRepo;
import com.ph34757.sof3011.repositories.SanPhamChiTietRepo;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@WebServlet(name = "HoaDonServlet", value = {
        "/home-hoaDon",
        "/findKH-hoaDon",
        "/select-khachHang",
        "/create-hoaDon",
        "/addKH-hoaDon",
        "/delete-hoaDon",
        "/paid-hoaDon",
        "/hoaDonPaid",
        "/details-hoaDon"
})
public class HoaDonServlet extends HttpServlet implements ServletUtils<HoaDon> {
    HoaDonRepo hoaDonRepo = new HoaDonRepo();
    KhachHangRepo khachHangRepo = new KhachHangRepo();
    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();
    SanPhamChiTietRepo sanPhamChiTietRepo = new SanPhamChiTietRepo();
    KhachHangServlet khachHangServlet = new KhachHangServlet();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home-hoaDon")){
            home(request, response);
        } else if (uri.contains("select-khachHang")) {
            selectKH(request, response);
        } else if (uri.contains("delete-hoaDon")) {
            delete(request, response);
        } else if (uri.contains("hoaDonPaid")) {
            hoaDonPaid(request, response);
        } else if (uri.contains("paid-hoaDon")) {
            try {
                paidHoaDon(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("details-hoaDon")) {
            hoaDonCTPaid(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("findKH-hoaDon")){
            findKH(request, response);
        } else if (uri.contains("addKH-hoaDon")) {
            try {
                addKH(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("create-hoaDon")) {
            try {
                create(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewHoaDon/homeHoaDon.jsp");
        request.setAttribute("listHD", hoaDonRepo.listUnPaid());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void hoaDonPaid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewHoaDon/homeHoaDonPaid.jsp");
        request.setAttribute("listHDPaid", hoaDonRepo.listActive());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void hoaDonCTPaid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idHD = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("listHDCTPaid", hoaDonChiTietRepo.listHDCTByIdHD(idHD));
        request.setAttribute("tongTien", hoaDonRepo.tongTien(idHD));
        HoaDon hoaDon = hoaDonRepo.findById(idHD);
        request.setAttribute("hd", hoaDon);
        request.setAttribute("page", "/viewHoaDon/hoaDonDetails.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String id_KH = request.getParameter("idKH");
        if (id_KH == null || id_KH.trim().isEmpty()){
            KhachHang khachHang = new KhachHang();
            khachHang.setHoTen(generateAutoCodeKH());
            khachHang.setSdt(generateAutoCodeSDT());
            khachHang.setDiaChi("Address");
            khachHang.setTrangThai("Active");
            khachHang.setNgayTao(DateUtils.getDateFormat());
            khachHangRepo.insert(khachHang);
            KhachHang kh_hoaDon = khachHangRepo.getKhachHang();
            HoaDon hoaDon = new HoaDon(kh_hoaDon.getId(), "Unpaid", DateUtils.getDateFormat(), null, kh_hoaDon.getDiaChi(), kh_hoaDon.getSdt(), kh_hoaDon);
            hoaDonRepo.insert(hoaDon);
        }else {
            int idKH = Integer.parseInt(request.getParameter("idKH"));
            KhachHang khachHang = khachHangRepo.findById(idKH);
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            HoaDon hoaDon = new HoaDon(khachHang.getId(), "Unpaid", DateUtils.getDateFormat(), null, diaChi, sdt, khachHang);
            hoaDonRepo.insert(hoaDon);
        }
        response.sendRedirect("/home-hoaDon");
    }

    public String generateAutoCodeKH() {
        String uppercaseLetters = "KH";
        String numbers = "0123456789";

        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        codeBuilder.append(uppercaseLetters);

        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(numbers.length());
            codeBuilder.append(numbers.charAt(randomIndex));
        }

        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(numbers.length());
            codeBuilder.append(numbers.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }

    public String generateAutoCodeSDT() {
        String uppercaseLetters = "+84";
        String numbers = "0123456789";

        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();

        codeBuilder.append(uppercaseLetters);

        for (int i = 0; i < 9; i++) {
            int randomIndex = random.nextInt(numbers.length());
            codeBuilder.append(numbers.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }

    public void findKH (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String findKH = request.getParameter("findKH");
        request.setAttribute("findKH", findKH);
        request.setAttribute("listKH", khachHangRepo.findByPhoneNumber(findKH));
        request.setAttribute("page", "/viewHoaDon/homeHoaDon.jsp");
        request.setAttribute("listHD", hoaDonRepo.listUnPaid());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void selectKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idKH = Integer.parseInt(request.getParameter("idKH"));
        KhachHang khachHang = khachHangRepo.findById(idKH);
        request.setAttribute("hoTen",khachHang.getHoTen());
        request.setAttribute("diaChi",khachHang.getDiaChi());
        request.setAttribute("sdt",khachHang.getSdt());
        request.setAttribute("kh",khachHang);
        request.setAttribute("page", "/viewHoaDon/homeHoaDon.jsp");
        request.setAttribute("listHD", hoaDonRepo.listUnPaid());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void paidHoaDon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String id = request.getParameter("idHD");
        if (id != null && !id.trim().isEmpty()){
            int idHD = Integer.parseInt(id);
            HoaDon hoaDon = hoaDonRepo.findById(idHD);
            hoaDon.setTrangThai("Paid");
            List<Hdct> list = hoaDonChiTietRepo.listHDCTByIdHD(idHD);
            for (Hdct hdct : list) {
                hdct.setTrangThai("Paid");
                hoaDonChiTietRepo.update(hdct);
            }
            hoaDonRepo.update(hoaDon);
        }
        response.sendRedirect("/home-hoaDon");
    }

    public void addKH(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String hoTen = request.getParameter("hoTen");
        if (hoTen != null && !hoTen.trim().isEmpty()){
            KhachHang kh = khachHangServlet.getEntityAdd(request, response);
            kh.setTrangThai("Active");
            khachHangRepo.insert(kh);
            KhachHang khachHang = khachHangRepo.getKhachHang();
            int idKH = khachHang.getId();
            request.setAttribute("kh",khachHang);
            response.sendRedirect("/select-khachHang?idKH="+idKH);
        } else {
            response.sendRedirect("/home-hoaDon");
        }
    }

    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Hdct> list = hoaDonChiTietRepo.listHDCTByIdHD(id);
        if (list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                Hdct hdct = list.get(i);
                Ctsp ctsp = hdct.getCtspByIdCtsp();
                ctsp.setSoLuongTon(ctsp.getSoLuongTon() + hdct.getSoLuongMua());
                sanPhamChiTietRepo.update(ctsp);
            }
        }
        hoaDonRepo.delete(id);
        response.sendRedirect("/home-hoaDon");
    }

    @Override
    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public HoaDon getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        return null;
    }

    @Override
    public HoaDon getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        return null;
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        return false;
    }
}
