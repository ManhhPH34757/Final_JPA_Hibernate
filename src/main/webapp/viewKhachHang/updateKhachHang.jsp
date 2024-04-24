<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row mt-3">
    <div class="text-center">
        <h3 class="text-danger">Sửa thông tin khách hàng</h3>
    </div>
    <div class="col-3"></div>
    <div class="col-6">
        <form action="update-khachHang?id=${kh.id}" method="post">
            <div class="mt-3">
                <label for="name"><strong>Họ tên:</strong></label>
                <input class="form-control" name="hoTen" id="name" type="text" value="${kh.hoTen}">
            </div>
            <div class="mt-3">
                <label for="diaChi"><strong>Địa chỉ:</strong></label>
                <input class="form-control" name="diaChi" id="diaChi" type="text" value="${kh.diaChi}">
            </div>
            <div class="mt-3">
                <label for="sdt"><strong>Số điện thoại:</strong></label>
                <input class="form-control" name="sdt" id="sdt" type="text" value="${kh.sdt}">
            </div>
            <div class="mt-3">
                <label><strong>Trạng thái:</strong></label>
                <div>
                    <input type="radio" name="trangThai" value="Active" id="1"
                           <c:if test="${kh.trangThai == 'Active'}">checked</c:if>
                    >
                    <label for="1">Active</label>
                </div>
                <div>
                    <input type="radio" name="trangThai" value="InActive" id="0"
                           <c:if test="${kh.trangThai == 'InActive'}">checked</c:if>
                    >
                    <label for="0">InActive</label>
                </div>
            </div>
            <div class="text-center">
                <a>
                    <button class="btn btn-outline-success" type="submit">Update</button>
                </a>
            </div>
        </form>
    </div>
    <div class="col-3"></div>
</div>