package com.ph34757.sof3011.controllers.sanPhamChiTiet;

import com.ph34757.sof3011.entities.Ctsp;
import com.ph34757.sof3011.entities.MauSac;
import com.ph34757.sof3011.entities.SanPham;
import com.ph34757.sof3011.entities.Size;
import com.ph34757.sof3011.repositories.MauSacRepo;
import com.ph34757.sof3011.repositories.SanPhamChiTietRepo;
import com.ph34757.sof3011.repositories.SanPhamRepo;
import com.ph34757.sof3011.repositories.SizeRepo;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "SanPhamChiTietServlet", value = {
        "/home-ctsp",
        "/create-ctsp",
        "/store-ctsp",
        "/edit-ctsp",
        "/update-ctsp",
        "/delete-ctsp"
})
public class SanPhamChiTietServlet extends HttpServlet implements ServletUtils<Ctsp> {
    SanPhamRepo sanPhamRepo = new SanPhamRepo();
    MauSacRepo mauSacRepo = new MauSacRepo();
    SizeRepo sizeRepo = new SizeRepo();
    SanPhamChiTietRepo sanPhamChiTietRepo = new SanPhamChiTietRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home-ctsp")) {
            this.home(request, response);
        } else if (uri.contains("create-ctsp")) {
            this.create(request, response);
        } else if (uri.contains("edit-ctsp")) {
            this.edit(request, response);
        } else if (uri.contains("delete-ctsp")) {
            this.delete(request, response);
        } else if (uri.contains("filter-ctsp")) {
            this.filter(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store-ctsp")) {
            try {
                this.store(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("update-ctsp")) {
            try {
                this.update(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewSanPhamChiTiet/homeSanPhamChiTiet.jsp");
        int idSp = Integer.parseInt(request.getParameter("idSp"));
        request.setAttribute("sp", sanPhamRepo.findById(idSp));
        request.setAttribute("listSPCT", sanPhamChiTietRepo.getListCTSP(idSp));
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewSanPhamChiTiet/createSanPhamChiTiet.jsp");
        int idSp = Integer.parseInt(request.getParameter("idSp"));
        request.setAttribute("sp", sanPhamRepo.findById(idSp));
        request.setAttribute("mauSac", mauSacRepo.listActive());
        request.setAttribute("size", sizeRepo.listActive());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "/viewSanPhamChiTiet/updateSanPhamChiTiet.jsp");
        int idSp = Integer.parseInt(request.getParameter("idSp"));
        request.setAttribute("sp", sanPhamRepo.findById(idSp));
        int idctsp = Integer.parseInt(request.getParameter("idctsp"));
        request.setAttribute("ctsp", sanPhamChiTietRepo.findById(idctsp));
        request.setAttribute("mauSac", mauSacRepo.listActive());
        request.setAttribute("size", sizeRepo.listActive());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idctsp = Integer.parseInt(request.getParameter("idctsp"));
        int idSp = Integer.parseInt(request.getParameter("idSp"));
        sanPhamChiTietRepo.delete(idctsp);
        response.sendRedirect("/home-ctsp?idSp="+idSp);
    }

    @Override
    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int idSp = Integer.parseInt(request.getParameter("idSp"));
        sanPhamChiTietRepo.insert(getEntityAdd(request, response));
        response.sendRedirect("/home-ctsp?idSp="+idSp);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int idSp = Integer.parseInt(request.getParameter("idSp"));
        sanPhamChiTietRepo.update(getEntityUpdate(request, response));
        response.sendRedirect("/home-ctsp?idSp="+idSp);
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public Ctsp getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int idSp = Integer.parseInt(request.getParameter("idSp"));
        SanPham sanPham = sanPhamRepo.findById(idSp);
        Date ngayTao = DateUtils.getDateFormat();

        return new Ctsp(idSp, getEntity(request, response).getIdMauSac(), getEntity(request, response).getIdSize(), getEntity(request, response).getGiaBan(), getEntity(request, response).getSoLuongTon(), getEntity(request, response).getTrangThai(), ngayTao, null, sanPham, getEntity(request, response).getMauSacByIdMauSac(), getEntity(request, response).getSizeByIdSize());
    }

    @Override
    public Ctsp getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int idctsp = Integer.parseInt(request.getParameter("idctsp"));
        Ctsp ctsp = sanPhamChiTietRepo.findById(idctsp);

        Date ngaySua = DateUtils.getDateFormat();

        ctsp.setIdMauSac(getEntity(request, response).getIdMauSac());
        ctsp.setMauSacByIdMauSac(getEntity(request, response).getMauSacByIdMauSac());
        ctsp.setIdSize(getEntity(request, response).getIdSize());
        ctsp.setSizeByIdSize(getEntity(request, response).getSizeByIdSize());
        ctsp.setGiaBan(getEntity(request, response).getGiaBan());
        ctsp.setSoLuongTon(getEntity(request, response).getSoLuongTon());
        ctsp.setTrangThai(getEntity(request, response).getTrangThai());
        ctsp.setNgaySua(ngaySua);

        return ctsp;
    }

    public Ctsp getEntity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int idMauSac = Integer.parseInt(request.getParameter("idMauSac"));
        MauSac mauSac = mauSacRepo.findById(idMauSac);
        int idSize = Integer.parseInt(request.getParameter("idSize"));
        Size size = sizeRepo.findById(idSize);
        BigDecimal giaBan = new BigDecimal(request.getParameter("giaBan"));
        int soLuongTon = Integer.parseInt(request.getParameter("soLuongTon"));
        String trangThai = request.getParameter("trangThai");

        return new Ctsp(idMauSac, idSize, giaBan, soLuongTon, trangThai, mauSac, size);
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        return false;
    }
}
