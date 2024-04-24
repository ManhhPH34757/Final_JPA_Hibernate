<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row mt-3">
    <div class="text-center">
        <h3 class="text-danger">Thêm danh mục</h3>
    </div>
    <div class="col-3"></div>
    <div class="col-6">
        <form action="update-danhMuc?id=${dm.id}" method="post">
            <div class="mt-3">
                <label for="ma"><strong>Mã danh mục:</strong></label>
                <input class="form-control" name="maDanhMuc" id="ma" type="text" value="${dm.maDanhMuc}" readonly>
            </div>

            <div class="mt-3">
                <label for="name"><strong>Tên danh mục:</strong></label>
                <input class="form-control" name="tenDanhMuc" id="name" type="text" value="${dm.tenDanhMuc}">
            </div>

            <div class="mt-3">
                <label><strong>Trạng thái:</strong></label>
                <div>
                    <input type="radio" name="trangThai" value="Active" id="1"
                           <c:if test="${dm.trangThai == 'Active'}">checked</c:if>
                    >
                    <label for="1">Active</label>
                </div>
                <div>
                    <input type="radio" name="trangThai" value="InActive" id="0"
                           <c:if test="${dm.trangThai == 'InActive'}">checked</c:if>
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