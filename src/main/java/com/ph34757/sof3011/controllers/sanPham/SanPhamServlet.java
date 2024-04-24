package com.ph34757.sof3011.controllers.sanPham;

import com.ph34757.sof3011.entities.DanhMuc;
import com.ph34757.sof3011.entities.SanPham;
import com.ph34757.sof3011.repositories.DanhMucRepo;
import com.ph34757.sof3011.repositories.SanPhamRepo;
import com.ph34757.sof3011.utils.DateUtils;
import com.ph34757.sof3011.utils.ServletUtils;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@WebServlet(name = "SanPhamServlet", value = {"/home-sanPham", "/create-sanPham", "/store-sanPham", "/edit-sanPham", "/update-sanPham", "/delete-sanPham", "/filter-sanPham"})
public class SanPhamServlet extends HttpServlet implements ServletUtils<SanPham> {

          SanPhamRepo sanPhamRepo = new SanPhamRepo();
          DanhMucRepo danhMucRepo = new DanhMucRepo();

          @Override
          protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    String uri = request.getRequestURI();
                    if (uri.contains("home-sanPham")) {
                              this.home(request, response);
                    } else if (uri.contains("create-sanPham")) {
                              this.create(request, response);
                    } else if (uri.contains("edit-sanPham")) {
                              this.edit(request, response);
                    } else if (uri.contains("delete-sanPham")) {
                              this.delete(request, response);
                    } else if (uri.contains("filter-sanPham")) {
                              this.filter(request, response);
                    }
          }

          @Override
          protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    String uri = request.getRequestURI();
                    if (uri.contains("store-sanPham")) {
                              try {
                                        this.store(request, response);
                              } catch (ParseException e) {
                                        throw new RuntimeException(e);
                              }
                    } else if (uri.contains("update-sanPham")) {
                              try {
                                        this.update(request, response);
                              } catch (ParseException e) {
                                        throw new RuntimeException(e);
                              }
                    }
          }

          @Override
          public void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    request.setAttribute("page", "/viewSanPham/homeSanPham.jsp");
                    request.setAttribute("listSP", sanPhamRepo.getList());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
          }

          @Override
          public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    request.setAttribute("page", "/viewSanPham/createSanPham.jsp");
                    request.setAttribute("danhMuc", danhMucRepo.listActive());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
          }

          @Override
          public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    int id = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("page", "/viewSanPham/updateSanPham.jsp");
                    request.setAttribute("danhMuc", danhMucRepo.listActive());
                    request.setAttribute("sp", sanPhamRepo.findById(id));
                    request.getRequestDispatcher("index.jsp").forward(request, response);
          }

          @Override
          public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    int id = Integer.parseInt(request.getParameter("id"));
                    sanPhamRepo.delete(id);
                    response.sendRedirect("/home-sanPham");
          }

          @Override
          public void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
                    if (validate(request, response)) {
                              sanPhamRepo.insert(getEntityAdd(request, response));
                              response.sendRedirect("/home-sanPham");
                    } else {
                              create(request, response);
                    }
          }

          @Override
          public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
                    sanPhamRepo.update(getEntityUpdate(request, response));
                    response.sendRedirect("/home-sanPham");
          }

          @Override
          public void filter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          }

          @Override
          public SanPham getEntityAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
                    String maSanPham = request.getParameter("maSanPham");
                    String tenSanPham = request.getParameter("tenSanPham");
                    String trangThai = request.getParameter("trangThai");
                    int idDanhMuc = Integer.parseInt(request.getParameter("idDanhMuc"));
                    DanhMuc danhMuc = danhMucRepo.findById(idDanhMuc);
                    Date ngayTao = DateUtils.getDateFormat();

                    return new SanPham(maSanPham, tenSanPham, trangThai, ngayTao, null, idDanhMuc, danhMuc);
          }

          @Override
          public SanPham getEntityUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
                    int id = Integer.parseInt(request.getParameter("id"));
                    SanPham sanPham = sanPhamRepo.findById(id);

                    String tenSanPham = request.getParameter("tenSanPham");
                    String trangThai = request.getParameter("trangThai");
                    int idDanhMuc = Integer.parseInt(request.getParameter("idDanhMuc"));
                    DanhMuc danhMuc = danhMucRepo.findById(idDanhMuc);
                    Date ngaySua = DateUtils.getDateFormat();

                    sanPham.setTenSanPham(tenSanPham);
                    sanPham.setTrangThai(trangThai);
                    sanPham.setIdDanhMuc(idDanhMuc);
                    sanPham.setDanhMucByIdDanhMuc(danhMuc);
                    sanPham.setNgaySua(ngaySua);

                    return sanPham;
          }

          @Override
          public boolean validate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
                    boolean check = true;
                    String maSanPham = request.getParameter("maSanPham");
                    String tenSanPham = request.getParameter("tenSanPham");
                    String trangThai = request.getParameter("trangThai");

                    if (maSanPham == null || maSanPham.trim().isEmpty()) {
                              request.setAttribute("validMaSanPham", "Vui lòng nhập mã sản phẩm");
                              check = false;
                    } else {
                              request.setAttribute("maSanPham", maSanPham);
                              request.setAttribute("validMaSanPham", "");
                    }

                    if (tenSanPham == null || tenSanPham.trim().isEmpty()) {
                              request.setAttribute("validTenSanPham", "Vui lòng nhập tên sản phẩm");
                              check = false;
                    } else {
                              request.setAttribute("tenDanhMuc", tenSanPham);
                              request.setAttribute("validTenSanPham", "");
                    }

                    try {
                              int idDanhMuc = Integer.parseInt(request.getParameter("idDanhMuc"));
                              request.setAttribute("idDanhMuc", idDanhMuc);
                              request.setAttribute("validDanhMuc", "");
                    } catch (NumberFormatException e) {
                              request.setAttribute("validDanhMuc", "Vui lòng chọn danh mục");
                              check = false;
                    }

                    if (trangThai == null || trangThai.trim().isEmpty()) {
                              request.setAttribute("validStatus", "Vui lòng nhập chọn trạng thái sản phẩm");
                              check = false;
                    } else {
                              request.setAttribute("trangThai", trangThai);
                              request.setAttribute("validStatus", "");
                    }

                    return check;
          }
}
