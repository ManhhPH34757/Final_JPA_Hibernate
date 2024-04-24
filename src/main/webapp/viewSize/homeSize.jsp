<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mt-3">
    <div class="text-center mt-3">
        <h3 class="text-danger">Danh sách size</h3>
    </div>
    <a href="create-size" class="btn btn-primary mt-3">
        Thêm size
    </a>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã size</th>
            <th>Tên size</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSize}" var="s" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${s.maSize}</td>
                <td>${s.tenSize}</td>
                <td>${s.trangThai}</td>
                <td>${s.ngayTao}</td>
                <td>${s.ngaySua}</td>
                <td>
                    <a href="edit-size?id=${s.id}" class="btn btn-warning">Sửa</a>
                    <a href="delete-size?id=${s.id}" class="btn btn-danger" onclick="return confirm('Bạn muốn xóa size này ?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>