<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mt-3">
    <form action="filter-khachHang" method="get" class="border border-warning pb-3">
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">
                <div class="mt-3">
                    <label for="name"><strong>Họ tên:</strong></label>
                    <input class="form-control" name="name" id="name" type="text" value="${name}">
                </div>
            </div>
            <div class="col-3">
                <div class="mt-3">
                    <label for="diaChi"><strong>Địa chỉ:</strong></label>
                    <input class="form-control" name="address" id="diaChi" type="text" value="${address}">
                </div>
            </div>
            <div class="col-3">
                <div class="mt-3">
                    <label for="sdt"><strong>Số điện thoại:</strong></label>
                    <input class="form-control" name="phone" id="sdt" type="text" value="${phone}">
                </div>
            </div>
            <div class="col-1 float-end mt-3">
                <button class="btn btn-success mt-4" type="submit">Find</button>
            </div>
        </div>
    </form>

    <div class="text-center mt-3">
        <h3 class="text-danger">Danh sách khách hàng</h3>
    </div>
    <a href="create-khachHang" class="btn btn-primary mt-3">
        Thêm khách hàng
    </a>
    <table class="table mt-3">
        <thead>
            <tr>
                <th>STT</th>
                <th>Tên khách hàng</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>Trạng thái</th>
                <th>Ngày tạo</th>
                <th>Ngày sửa</th>
                <th>Thao tác</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listKH}" var="kh" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${kh.hoTen}</td>
                    <td>${kh.diaChi}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.trangThai}</td>
                    <td>${kh.ngayTao}</td>
                    <td>${kh.ngaySua}</td>
                    <td>
                        <a href="edit-khachHang?id=${kh.id}" class="btn btn-warning">Sửa</a>
                        <a href="delete-khachHang?id=${kh.id}" class="btn btn-danger" onclick="return confirm('Bạn muốn xóa khách hàng này ?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>