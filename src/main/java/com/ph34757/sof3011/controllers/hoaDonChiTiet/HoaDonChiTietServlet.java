package com.ph34757.sof3011.controllers.hoaDonChiTiet;

import com.ph34757.sof3011.entities.Ctsp;
import com.ph34757.sof3011.entities.Hdct;
import com.ph34757.sof3011.entities.HoaDon;
import com.ph34757.sof3011.repositories.*;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet(name = "HoaDonChiTietServlet", value = {
        "/store-hoaDon",
        "/select-sanPham",
        "/findSP-hoaDon",
        "/updateSP-hoaDon",
        "/deleteSP-hoaDon",
        "/next",
        "/prev"


})
public class HoaDonChiTietServlet extends HttpServlet implements ServletUtils<Hdct> {
    HoaDonRepo hoaDonRepo = new HoaDonRepo();
    HoaDonChiTietRepo hoaDonChiTietRepo = new HoaDonChiTietRepo();
    DanhMucRepo danhMucRepo = new DanhMucRepo();
    MauSacRepo mauSacRepo = new MauSacRepo();
    SizeRepo sizeRepo = new SizeRepo();
    SanPhamChiTietRepo sanPhamChiTietRepo = new SanPhamChiTietRepo();

    int index = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store-hoaDon")){
            home(request, response);
        } else if (uri.contains("deleteSP-hoaDon")) {
            delete(request, response);
        } else if (uri.contains("select-sanPham")) {
            try {
                store(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("next")) {
            next(request, response);
        } else if (uri.contains("prev")) {
            prev(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("updateSP-hoaDon")) {
            try {
                update(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (uri.contains("findSP-hoaDon")) {
            filter(request, response);
        }
    }

    @Override
    public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        index = 1;
        request.setAttribute("index",index);
        request.setAttribute("listSP", sanPhamChiTietRepo.listActive1(index));
        pagination(request, response);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void next(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || id.trim().isEmpty()){
            response.sendRedirect("/home-hoaDon");
        }else {
            int max = 0;
            if (sanPhamChiTietRepo.listActive().size() % 2 == 0){
                max = sanPhamChiTietRepo.listActive().size() / 2;
            }else {
                max = (sanPhamChiTietRepo.listActive().size() + 1) / 2;
            }
            if (index < max){
                index = index + 1;
            } else {
                index = max;
            }
            request.setAttribute("index",index);
            request.setAttribute("listSP", sanPhamChiTietRepo.listActive1(index));
            pagination(request, response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

    public void prev(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null || id.trim().isEmpty()){
            response.sendRedirect("/home-hoaDon");
        }else {
            if (index > 1){
                index = index - 1;
            } else {
                index = 1;
            }
            request.setAttribute("index",index);
            request.setAttribute("listSP", sanPhamChiTietRepo.listActive1(index));
            pagination(request, response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void pagination(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idHD = Integer.parseInt(request.getParameter("id"));
        HoaDon hoaDon = hoaDonRepo.findById(idHD);
        request.setAttribute("hd", hoaDon);
        request.setAttribute("hoTen", hoaDon.getKhachHangByIdKhachHang().getHoTen());
        request.setAttribute("diaChi", hoaDon.getDiaChi());
        request.setAttribute("sdt", hoaDon.getSoDienThoai());
        request.setAttribute("listHDCT", hoaDonChiTietRepo.listHDCTByIdHD(idHD));
        request.setAttribute("tongTien", hoaDonRepo.tongTien(idHD));
        request.setAttribute("page", "/viewHoaDon/homeHoaDon.jsp");
        request.setAttribute("listHD", hoaDonRepo.listUnPaid());
        request.setAttribute("listDM", danhMucRepo.getList());
        request.setAttribute("listMauSac", mauSacRepo.getList());
        request.setAttribute("listSize", sizeRepo.getList());
    }

    @Override
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

    }

    @Override
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idHD = Integer.parseInt(request.getParameter("idHD"));
        int idHDCT = Integer.parseInt(request.getParameter("idHDCT"));
        Hdct hdct = hoaDonChiTietRepo.findById(idHDCT);
        Ctsp ctsp = hdct.getCtspByIdCtsp();
        ctsp.setSoLuongTon(ctsp.getSoLuongTon() + hdct.getSoLuongMua());
        sanPhamChiTietRepo.update(ctsp);
        hoaDonChiTietRepo.delete(idHDCT);
        response.sendRedirect("store-hoaDon?id="+idHD);
    }

    @Override
    public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int idHD = Integer.parseInt(request.getParameter("idHD"));
        int idSP = Integer.parseInt(request.getParameter("idSP"));
        Ctsp ctsp = sanPhamChiTietRepo.findById(idSP);
        HoaDon hoaDon = hoaDonRepo.findById(idHD);
        request.setAttribute("hd",hoaDon);
        Date ngayTao = DateUtils.getDateFormat();
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        List<Hdct> list = hoaDonChiTietRepo.listHDCTByIdHD(idHD);
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (idSP == list.get(i).getIdCtsp()){
                index = i;
                break;
            }
        }
        if (ctsp.getSoLuongTon() >= quantity){
            if (index != -1){
                Hdct hdct = list.get(index);
                hdct.setSoLuongMua(hdct.getSoLuongMua() + quantity);
                hdct.setTongTien(hdct.getGiaBan().multiply(BigDecimal.valueOf(hdct.getSoLuongMua())));
                hoaDonChiTietRepo.update(hdct);
            }else {
                Hdct hdct = new Hdct(idHD, idSP, quantity, ctsp.getGiaBan(), ctsp.getGiaBan().multiply(BigDecimal.valueOf(quantity)), "Unpaid", ngayTao, null, hoaDon, ctsp);
                hoaDonChiTietRepo.insert(hdct);
            }
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() - quantity);
            sanPhamChiTietRepo.update(ctsp);
            request.getSession().setAttribute("message", null);
        } else {
            request.getSession().setAttribute("message", "Số lượng tồn kho không đủ! Vui lòng nhập lại số lượng mua!");
        }
        response.sendRedirect("store-hoaDon?id="+idHD);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        int idHD = Integer.parseInt(request.getParameter("idHD"));
        int idHDCT = Integer.parseInt(request.getParameter("idHDCT"));
        Hdct hdct = hoaDonChiTietRepo.findById(idHDCT);
        Ctsp ctsp = hdct.getCtspByIdCtsp();
        int soLuongMua = Integer.parseInt(request.getParameter("soLuongMua"));
        if (soLuongMua > 0 && soLuongMua <= hdct.getSoLuongMua()+ctsp.getSoLuongTon()){
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() + hdct.getSoLuongMua() - soLuongMua);
            sanPhamChiTietRepo.update(ctsp);
            hdct.setSoLuongMua(soLuongMua);
            hdct.setTongTien(hdct.getGiaBan().multiply(BigDecimal.valueOf(soLuongMua)));
            hoaDonChiTietRepo.update(hdct);
            request.getSession().setAttribute("message", null);
        }else {
            request.getSession().setAttribute("message", "Số lượng tồn kho không đủ! Vui lòng nhập lại số lượng mua!");
        }
        response.sendRedirect("store-hoaDon?id="+idHD);
    }

    @Override
    public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("idHD");
        if (id == null || id.trim().isEmpty()){
            response.sendRedirect("/home-hoaDon");
        }else {
            int idHD = Integer.parseInt(id);
            HoaDon hoaDon = hoaDonRepo.findById(idHD);
            request.setAttribute("hd", hoaDon);
            request.setAttribute("hoTen", hoaDon.getKhachHangByIdKhachHang().getHoTen());
            request.setAttribute("diaChi", hoaDon.getDiaChi());
            request.setAttribute("sdt", hoaDon.getSoDienThoai());
            String tenSP = request.getParameter("findTenSP");
            String tenDanhMuc = request.getParameter("findTenDanhMuc");
            String tenMau = request.getParameter("findTenMau");
            String tenSize = request.getParameter("findTenSize");
            List<Ctsp> list = sanPhamChiTietRepo.findByName(tenSP, tenDanhMuc, tenMau, tenSize);
            request.setAttribute("listSP", list);
            request.setAttribute("listHDCT", hoaDonChiTietRepo.listHDCTByIdHD(idHD));
            request.setAttribute("tongTien", hoaDonRepo.tongTien(idHD));
            request.setAttribute("listHD", hoaDonRepo.listUnPaid());
            request.setAttribute("page", "/viewHoaDon/homeHoaDon.jsp");
            request.setAttribute("listDM", danhMucRepo.getList());
            request.setAttribute("listMauSac", mauSacRepo.getList());
            request.setAttribute("listSize", sizeRepo.getList());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public Hdct getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        return null;
    }

    @Override
    public Hdct getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        return null;
    }

    @Override
    public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        return false;
    }
}
