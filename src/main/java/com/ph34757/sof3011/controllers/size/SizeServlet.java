package com.ph34757.sof3011.controllers.size;

import com.ph34757.sof3011.entities.MauSac;
import com.ph34757.sof3011.entities.Size;
import com.ph34757.sof3011.repositories.SizeRepo;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "SizeServlet", value = {
        "/home-size",
        "/create-size",
        "/store-size",
        "/edit-size",
        "/update-size",
        "/delete-size"
})
public class SizeServlet extends HttpServlet implements ServletUtils<Size> {
    SizeRepo sizeRepo = new SizeRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home-size")) {
            this.home(request, response);
        } else if (uri.contains("create-size")) {
            this.create(request, response);
        } else if (uri.contains("edit-size")) {
            this.edit(request, response);
        } else if (uri.contains("delete-size")) {
            this.delete(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store-size")) {
            try {
                this.store(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("update-size")) {
            try {
                this.update(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewSize/homeSize.jsp");
        request.setAttribute("listSize", sizeRepo.getList());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewSize/createSize.jsp");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("page", "/viewSize/updateSize.jsp");
        request.setAttribute("size", sizeRepo.findById(id));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        sizeRepo.delete(id);
        response.sendRedirect("/home-size");
    }

    @Override
    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        if (this.validate(request, response)){
            sizeRepo.insert(getEntityAdd(request, response));
            response.sendRedirect("/home-size");
        }else {
            create(request, response);
        }
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        sizeRepo.update(getEntityUpdate(request, response));
        response.sendRedirect("/home-size");
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public Size getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        String maSize = request.getParameter("maSize");
        String tenSize = request.getParameter("tenSize");
        String trangThai = request.getParameter("trangThai");
        Date ngayTao = DateUtils.getDateFormat();
        return new Size(maSize, tenSize, trangThai, null, ngayTao);
    }

    @Override
    public Size getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        Size size = sizeRepo.findById(id);

        String tenSize = request.getParameter("tenSize");
        String trangThai = request.getParameter("trangThai");
        Date ngaySua = DateUtils.getDateFormat();

       size.setTenSize(tenSize);
       size.setTrangThai(trangThai);
       size.setNgaySua(ngaySua);

       return size;
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        boolean check = true;
        String maSize = request.getParameter("maSize");
        String tenSize = request.getParameter("tenSize");
        String trangThai = request.getParameter("trangThai");
        if (maSize == null || maSize.trim().isEmpty()){
            request.setAttribute("validMaSize", "Vui lòng nhập mã size");
            check = false;
        }else {
            request.setAttribute("maSize", maSize);
            request.setAttribute("validMaSize", "");
        }

        if (tenSize == null || tenSize.trim().isEmpty()){
            request.setAttribute("validTenSize", "Vui lòng nhập tên size");
            check = false;
        }else {
            request.setAttribute("tenSize", tenSize);
            request.setAttribute("validTenSize", "");
        }

        if (trangThai == null || trangThai.trim().isEmpty()){
            request.setAttribute("validStatus", "Vui lòng nhập chọn trạng thái size");
            check = false;
        }else {
            request.setAttribute("trangThai", trangThai);
            request.setAttribute("validStatus", "");
        }

        return check;

    }
}
