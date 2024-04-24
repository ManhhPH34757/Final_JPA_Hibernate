package com.ph34757.sof3011.controllers.khachHang;

import com.ph34757.sof3011.entities.KhachHang;
import com.ph34757.sof3011.repositories.KhachHangRepo;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "KhachHangServlet", value = {
        "/home-khachHang",
        "/create-khachHang",
        "/store-khachHang",
        "/edit-khachHang",
        "/update-khachHang",
        "/delete-khachHang",
        "/filter-khachHang"
})
public class KhachHangServlet extends HttpServlet implements ServletUtils<KhachHang> {
    KhachHangRepo khachHangRepo = new KhachHangRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home-khachHang")) {
            this.home(request, response);
        } else if (uri.contains("create-khachHang")) {
            this.create(request, response);
        } else if (uri.contains("edit-khachHang")) {
            this.edit(request, response);
        } else if (uri.contains("delete-khachHang")) {
            this.delete(request, response);
        } else if (uri.contains("filter-khachHang")) {
            this.filter(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store-khachHang")) {
            try {
                this.store(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("update-khachHang")) {
            try {
                this.update(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewKhachHang/homeKhachHang.jsp");
        request.setAttribute("listKH", khachHangRepo.getList());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewKhachHang/createKhachHang.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        if (validate(request, response)){
            khachHangRepo.insert(getEntityAdd(request, response));
            response.sendRedirect("/home-khachHang");
        }else {
            create(request, response);
        }
    }

    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("page", "/viewKhachHang/updateKhachHang.jsp");
        request.setAttribute("kh", khachHangRepo.findById(id));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        khachHangRepo.update(getEntityUpdate(request, response));
        response.sendRedirect("/home-khachHang");
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        khachHangRepo.delete(id);
        response.sendRedirect("/home-khachHang");
    }

    @Override
    public KhachHang getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String trangThai = request.getParameter("trangThai");
        Date ngayTao = DateUtils.getDateFormat();
        return new KhachHang(hoTen, diaChi, sdt, trangThai, ngayTao, null);
    }

    public KhachHang getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang khachHang = khachHangRepo.findById(id);

        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String trangThai = request.getParameter("trangThai");
        Date ngaySua = DateUtils.getDateFormat();

        khachHang.setHoTen(hoTen);
        khachHang.setDiaChi(diaChi);
        khachHang.setSdt(sdt);
        khachHang.setTrangThai(trangThai);
        khachHang.setNgaySua(ngaySua);

        return khachHang;
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        boolean check = true;
        String hoTen = request.getParameter("hoTen");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("sdt");
        String trangThai = request.getParameter("trangThai");
        if (hoTen == null || hoTen.trim().isEmpty()){
            request.setAttribute("validName", "Vui lòng nhập tên khách hàng");
            check = false;
        }else {
            request.setAttribute("hoTen", hoTen);
            request.setAttribute("validName", "");
        }

        if (diaChi == null || diaChi.trim().isEmpty()){
            request.setAttribute("validAddress", "Vui lòng nhập địa chỉ khách hàng");
            check = false;
        }else {
            request.setAttribute("diaChi", diaChi);
            request.setAttribute("validAddress", "");
        }

        if (sdt == null || sdt.trim().isEmpty()){
            request.setAttribute("validPhoneNumber", "Vui lòng nhập số điện thoại khách hàng");
            check = false;
        }else {
            request.setAttribute("sdt", sdt);
            request.setAttribute("validPhoneNumber", "");
        }

        if (trangThai == null || trangThai.trim().isEmpty()){
            request.setAttribute("validStatus", "Vui lòng nhập chọn trạng thái khách hàng");
            check = false;
        }else {
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("validStatus", "");
        }

        return check;
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");

        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("phone", phone);

        request.setAttribute("page", "/viewKhachHang/homeKhachHang.jsp");
        request.setAttribute("listKH", khachHangRepo.filter(name, address, phone));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }


}
