<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row mt-3">
    <div class="text-center">
        <h3 class="text-danger">Thêm màu sắc</h3>
    </div>
    <div class="col-3"></div>
    <div class="col-6">
        <form action="store-mauSac" method="post">
            <div class="mt-3">
                <label for="ma"><strong>Mã màu:</strong></label>
                <input class="form-control" name="maMau" id="ma" type="text" value="${maMau}">
                <div class="text-danger">${validMaMau}</div>
            </div>
            <div class="mt-3">
                <label for="name"><strong>Tên màu:</strong></label>
                <input class="form-control" name="tenMau" id="name" type="text" value="${tenMau}">
                <div class="text-danger">${validTenMau}</div>
            </div>
            <div class="mt-3">
                <label><strong>Trạng thái:</strong></label>
                <div>
                    <input type="radio" name="trangThai" value="Active" id="1"
                           <c:if test="${trangThai == 'Active'}">checked</c:if>
                    >
                    <label for="1">Active</label>
                </div>
                <div>
                    <input type="radio" name="trangThai" value="InActive" id="0"
                           <c:if test="${trangThai == 'InActive'}">checked</c:if>
                    >
                    <label for="0">InActive</label>
                </div>
                <div class="text-danger">${validStatus}</div>
            </div>
            <div class="text-center">
                <a>
                    <button class="btn btn-outline-success" type="submit">Add</button>
                </a>
            </div>
        </form>
    </div>
    <div class="col-3"></div>
</div>