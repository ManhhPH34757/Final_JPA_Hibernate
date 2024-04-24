<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mt-3">
    <div class="text-center mt-3">
        <h3 class="text-danger">Danh sách danh mục</h3>
    </div>
    <a href="create-danhMuc" class="btn btn-primary mt-3">
        Thêm danh mục
    </a>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã danh mục</th>
            <th>Tên danh mục</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listDM}" var="dm" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${dm.maDanhMuc}</td>
                <td>${dm.tenDanhMuc}</td>
                <td>${dm.trangThai}</td>
                <td>${dm.ngayTao}</td>
                <td>${dm.ngaySua}</td>
                <td>
                    <a href="edit-danhMuc?id=${dm.id}" class="btn btn-warning">Sửa</a>
                    <a href="delete-danhMuc?id=${dm.id}" class="btn btn-danger" onclick="return confirm('Bạn muốn xóa danh mục này ?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>