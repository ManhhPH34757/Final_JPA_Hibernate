<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mt-3">
    <div class="text-center mt-3">
        <h3 class="text-danger">Danh sách màu sắc</h3>
    </div>
    <a href="create-mauSac" class="btn btn-primary mt-3">
        Thêm màu sắc
    </a>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã màu sắc</th>
            <th>Tên màu sắc</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listMS}" var="ms" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${ms.maMau}</td>
                <td>${ms.tenMau}</td>
                <td>${ms.trangThai}</td>
                <td>${ms.ngayTao}</td>
                <td>${ms.ngaySua}</td>
                <td>
                    <a href="edit-mauSac?id=${ms.id}" class="btn btn-warning">Sửa</a>
                    <a href="delete-mauSac?id=${ms.id}" class="btn btn-danger" onclick="return confirm('Bạn muốn xóa màu sắc này ?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>