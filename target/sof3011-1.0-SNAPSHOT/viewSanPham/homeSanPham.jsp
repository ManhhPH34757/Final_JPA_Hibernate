<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mt-3">

    <div class="text-center mt-3">
        <h3 class="text-danger">Danh sách sản phẩm</h3>
    </div>
    <a href="create-sanPham" class="btn btn-primary mt-3">
        Thêm sản phẩm
    </a>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã sản phẩm</th>
            <th>Tên sản phẩm</th>
            <th>Trạng thái</th>
            <th>Danh mục</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSP}" var="sp" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${sp.maSanPham}</td>
                <td>${sp.tenSanPham}</td>
                <td>${sp.trangThai}</td>
                <td>${sp.danhMucByIdDanhMuc.tenDanhMuc}</td>
                <td>${sp.ngayTao}</td>
                <td>${sp.ngaySua}</td>
                <td>
                    <a href="home-ctsp?idSp=${sp.id}" class="btn btn-primary">Thêm spct</a>
                    <a href="edit-sanPham?id=${sp.id}" class="btn btn-warning">Sửa</a>
                    <a href="delete-sanPham?id=${sp.id}" class="btn btn-danger" onclick="return confirm('Bạn muốn xóa sản phẩm này ?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>