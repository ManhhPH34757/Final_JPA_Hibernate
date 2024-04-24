<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row mt-3">
    <div class="text-center">
        <h3 class="text-danger">Sửa sản phẩm</h3>
    </div>
    <div class="col-3"></div>
    <div class="col-6">
        <form action="update-sanPham?id=${sp.id}" method="post">
            <div class="mt-3">
                <label for="maSanPham"><strong>Mã sản phẩm:</strong></label>
                <input class="form-control" name="maSanPham" id="maSanPham" type="text" value="${sp.maSanPham}" readonly>
            </div>
            <div class="mt-3">
                <label for="tenSanPham"><strong>Tên sản phẩm:</strong></label>
                <input class="form-control" name="tenSanPham" id="tenSanPham" type="text" value="${sp.tenSanPham}">
            </div>
            <div class="mt-3">
                <label><strong>Danh mục:</strong></label>
                <select class="form-control" name="idDanhMuc">
                    <option value="" hidden>-- Chọn danh mục</option>
                    <c:forEach items="${danhMuc}" var="dm">
                        <option value="${dm.id}" <c:if test="${sp.idDanhMuc == dm.id}">selected</c:if> >${dm.tenDanhMuc}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mt-3">
                <label><strong>Trạng thái:</strong></label>
                <div>
                    <input type="radio" name="trangThai" value="Active" id="1"
                           <c:if test="${sp.trangThai == 'Active'}">checked</c:if>
                    >
                    <label for="1">Active</label>
                </div>
                <div>
                    <input type="radio" name="trangThai" value="InActive" id="0"
                           <c:if test="${sp.trangThai == 'InActive'}">checked</c:if>
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