<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <h5 class="mt-3 text-center text-danger">Danh sách hóa đơn</h5>
    <table class="table table-striped">
        <tr>
            <th>ID hóa đơn</th>
            <th>Tên khách hàng</th>
            <th>Số điện thoại</th>
            <th>Địa chỉ</th>
            <th>Ngày tạo</th>
            <th>Trạng thái</th>
        </tr>
        <tr>
            <td>${hd.id}</td>
            <td>${hd.khachHangByIdKhachHang.hoTen}</td>
            <td>${hd.soDienThoai}</td>
            <td>${hd.diaChi}</td>
            <td>${hd.ngayTao}</td>
            <td>${hd.trangThai}</td>
        </tr>
    </table>
    <table class="mt-3 table table-striped">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th>Màu</th>
            <th>Size</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Tổng tiền</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listHDCTPaid}" var="hdct" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hdct.ctspByIdCtsp.sanPhamByIdSp.tenSanPham}</td>
                <td>${hdct.ctspByIdCtsp.mauSacByIdMauSac.tenMau}</td>
                <td>${hdct.ctspByIdCtsp.sizeByIdSize.tenSize}</td>
                <td>${hdct.soLuongMua}</td>
                <td>${hdct.giaBan}</td>
                <td>${hdct.tongTien}</td>
            </tr>
        </c:forEach>
        <tr>
            <th colspan="6">Tổng tiền</th>
            <th>${tongTien}$</th>
        </tr>
        </tbody>
    </table>
</div>

