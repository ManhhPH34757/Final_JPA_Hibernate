<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mt-3">

    <div class="text-center mt-3">
        <h3 class="text-danger">Danh sách sản phẩm ${sp.tenSanPham}</h3>
    </div>
    <a href="create-ctsp?idSp=${sp.id}" class="btn btn-primary mt-3">
        Thêm sản phẩm
    </a>
    <table class="table mt-3">
        <thead>
        <tr>
            <th>STT</th>
            <th>Màu sắc</th>
            <th>Size</th>
            <th>Giá bán</th>
            <th>Số lượng tồn</th>
            <th>Trạng thái</th>
            <th>Ngày tạo</th>
            <th>Ngày sửa</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSPCT}" var="ctsp" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${ctsp.mauSacByIdMauSac.tenMau}</td>
                <td>${ctsp.sizeByIdSize.tenSize}</td>
                <td>${ctsp.giaBan}</td>
                <td>${ctsp.soLuongTon}</td>
                <td>${ctsp.trangThai}</td>
                <td>${ctsp.ngayTao}</td>
                <td>${ctsp.ngaySua}</td>
                <td>
                    <a href="edit-ctsp?idSp=${sp.id}&idctsp=${ctsp.id}" class="btn btn-warning">Sửa</a>
                    <a href="delete-ctsp?idSp=${sp.id}&idctsp=${ctsp.id}" class="btn btn-danger" onclick="return confirm('Bạn muốn xóa sản phẩm này ?')">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>