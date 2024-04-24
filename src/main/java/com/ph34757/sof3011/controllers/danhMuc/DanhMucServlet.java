package com.ph34757.sof3011.controllers.danhMuc;

import com.ph34757.sof3011.entities.DanhMuc;
import com.ph34757.sof3011.repositories.DanhMucRepo;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "DanhMucServlet", value = {
        "/home-danhMuc",
        "/create-danhMuc",
        "/store-danhMuc",
        "/edit-danhMuc",
        "/update-danhMuc",
        "/delete-danhMuc"
})
public class DanhMucServlet extends HttpServlet implements ServletUtils<DanhMuc> {

    DanhMucRepo danhMucRepo = new DanhMucRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home-danhMuc")) {
            this.home(request, response);
        } else if (uri.contains("create-danhMuc")) {
            this.create(request, response);
        } else if (uri.contains("edit-danhMuc")) {
            this.edit(request, response);
        } else if (uri.contains("delete-danhMuc")) {
            this.delete(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store-danhMuc")) {
            try {
                this.store(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("update-danhMuc")) {
            try {
                this.update(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewDanhMuc/homeDanhMuc.jsp");
        request.setAttribute("listDM", danhMucRepo.getList());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewDanhMuc/createDanhMuc.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("page", "/viewDanhMuc/updateDanhMuc.jsp");
        request.setAttribute("dm", danhMucRepo.findById(id));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        danhMucRepo.delete(id);
        response.sendRedirect("/home-danhMuc");
    }

    @Override
    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        if (this.validate(request, response)){
            danhMucRepo.insert(getEntityAdd(request, response));
            response.sendRedirect("/home-danhMuc");
        }else {
            create(request, response);
        }

    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        danhMucRepo.update(getEntityUpdate(request, response));
        response.sendRedirect("/home-danhMuc");
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public DanhMuc getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String maDanhMuc = request.getParameter("maDanhMuc");
        String tenDanhMuc = request.getParameter("tenDanhMuc");
        String trangThai = request.getParameter("trangThai");
        Date ngayTao = DateUtils.getDateFormat();
        return new DanhMuc(maDanhMuc, tenDanhMuc, trangThai, ngayTao, null);

    }

    @Override
    public DanhMuc getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        DanhMuc danhMuc = danhMucRepo.findById(id);

        String tenDanhMuc = request.getParameter("tenDanhMuc");
        String trangThai = request.getParameter("trangThai");
        Date ngaySua = DateUtils.getDateFormat();

        danhMuc.setTenDanhMuc(tenDanhMuc);
        danhMuc.setTrangThai(trangThai);
        danhMuc.setNgaySua(ngaySua);

        return danhMuc;
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        boolean check = true;
        String maDanhMuc = request.getParameter("maDanhMuc");
        String tenDanhMuc = request.getParameter("tenDanhMuc");
        String trangThai = request.getParameter("trangThai");
        if (maDanhMuc == null || maDanhMuc.trim().isEmpty()){
            request.setAttribute("validMaDanhMuc", "Vui lòng nhập mã danh mục");
            check = false;
        }else {
            request.setAttribute("maDanhMuc", maDanhMuc);
            request.setAttribute("validMaDanhMuc", "");
        }

        if (tenDanhMuc == null || tenDanhMuc.trim().isEmpty()){
            request.setAttribute("validTenDanhMuc", "Vui lòng nhập tên danh mục");
            check = false;
        }else {
            request.setAttribute("tenDanhMuc", tenDanhMuc);
            request.setAttribute("validTenDanhMuc", "");
        }

        if (trangThai == null || trangThai.trim().isEmpty()){
            request.setAttribute("validStatus", "Vui lòng nhập chọn trạng thái danh mục");
            check = false;
        }else {
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("validStatus", "");
        }

        return check;
    }
}
