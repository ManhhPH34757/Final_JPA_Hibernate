<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <h5 class="mt-3 text-center text-danger">Danh sách hóa đơn</h5>
    <table class="table table-striped">
        <tr>
            <th>STT</th>
            <th>Tên khách hàng</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Ngày tạo</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach items="${listHDPaid}" var="hd" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hd.khachHangByIdKhachHang.hoTen}</td>
                <td>${hd.soDienThoai}</td>
                <td>${hd.diaChi}</td>
                <td>${hd.ngayTao}</td>
                <td>${hd.trangThai}</td>
                <td>
                    <a href="details-hoaDon?id=${hd.id}" class="btn btn-info">Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
