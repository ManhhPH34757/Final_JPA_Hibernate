package com.ph34757.sof3011.controllers.mauSac;

import com.ph34757.sof3011.entities.MauSac;
import com.ph34757.sof3011.repositories.MauSacRepo;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "MauSacServlet", value = {
        "/home-mauSac",
        "/create-mauSac",
        "/store-mauSac",
        "/edit-mauSac",
        "/update-mauSac",
        "/delete-mauSac"
})
public class MauSacServlet extends HttpServlet implements ServletUtils<MauSac> {

    MauSacRepo mauSacRepo = new MauSacRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home-mauSac")) {
            this.home(request, response);
        } else if (uri.contains("create-mauSac")) {
            this.create(request, response);
        } else if (uri.contains("edit-mauSac")) {
            this.edit(request, response);
        } else if (uri.contains("delete-mauSac")) {
            this.delete(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store-mauSac")) {
            try {
                this.store(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("update-mauSac")) {
            try {
                this.update(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewMauSac/homeMauSac.jsp");
        request.setAttribute("listMS", mauSacRepo.getList());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewMauSac/createMauSac.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("page", "/viewMauSac/updateMauSac.jsp");
        request.setAttribute("ms", mauSacRepo.findById(id));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        mauSacRepo.delete(id);
        response.sendRedirect("/home-mauSac");
    }

    @Override
    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        if (this.validate(request, response)){
            mauSacRepo.insert(getEntityAdd(request, response));
            response.sendRedirect("/home-mauSac");
        }else {
            create(request, response);
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        mauSacRepo.update(getEntityUpdate(request, response));
        response.sendRedirect("/home-mauSac");
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public MauSac getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String maMau = request.getParameter("maMau");
        String tenMau = request.getParameter("tenMau");
        String trangThai = request.getParameter("trangThai");
        Date ngayTao = DateUtils.getDateFormat();
        return new MauSac(maMau, tenMau, trangThai, null, ngayTao);
    }

    @Override
    public MauSac getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        MauSac mauSac = mauSacRepo.findById(id);

        String tenMau = request.getParameter("tenMau");
        String trangThai = request.getParameter("trangThai");
        Date ngaySua = DateUtils.getDateFormat();

        mauSac.setTenMau(tenMau);
        mauSac.setTrangThai(trangThai);
        mauSac.setNgaySua(ngaySua);

        return mauSac;
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        boolean check = true;
        String maMau = request.getParameter("maMau");
        String tenMau = request.getParameter("tenMau");
        String trangThai = request.getParameter("trangThai");
        if (maMau == null || maMau.trim().isEmpty()){
            request.setAttribute("validMaMau", "Vui lòng nhập mã màu");
            check = false;
        }else {
            request.setAttribute("maMau", maMau);
            request.setAttribute("validMaMau", "");
        }

        if (tenMau == null || tenMau.trim().isEmpty()){
            request.setAttribute("validTenMau", "Vui lòng nhập tên màu");
            check = false;
        }else {
            request.setAttribute("tenMau", tenMau);
            request.setAttribute("validTenMau", "");
        }

        if (trangThai == null || trangThai.trim().isEmpty()){
            request.setAttribute("validStatus", "Vui lòng nhập chọn trạng thái màu sắc");
            check = false;
        }else {
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("validStatus", "");
        }

        return check;

    }
}
