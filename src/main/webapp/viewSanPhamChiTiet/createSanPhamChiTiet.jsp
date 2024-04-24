<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row mt-3">
    <div class="text-center">
        <h3 class="text-danger">Thêm sản phẩm</h3>
    </div>
    <div class="col-3"></div>
    <div class="col-6">
        <form action="store-ctsp?idSp=${sp.id}" method="post">
            <div class="mt-3">
                <label for="idSp"><strong>Tên sản phẩm:</strong></label>
                <input class="form-control" name="idSp" id="idSp" type="text" value="${sp.tenSanPham}" readonly >
            </div>
            <div class="mt-3">
                <label><strong>Màu sắc:</strong></label>
                <select class="form-control" name="idMauSac">
                    <option value="" hidden>-- Chọn màu sắc</option>
                    <c:forEach items="${mauSac}" var="ms">
                        <option value="${ms.id}" <c:if test="${idMauSac == ms.id}">selected</c:if> >${ms.tenMau}</option>
                    </c:forEach>
                </select>
                <div class="text-danger">${validMauSac}</div>
            </div>
            <div class="mt-3">
                <label><strong>Size:</strong></label>
                <select class="form-control" name="idSize">
                    <option value="" hidden>-- Chọn size</option>
                    <c:forEach items="${size}" var="s">
                        <option value="${s.id}" <c:if test="${idSize == s.id}">selected</c:if> >${s.tenSize}</option>
                    </c:forEach>
                </select>
                <div class="text-danger">${validSize}</div>
            </div>
            <div class="mt-3">
                <label for="giaBan"><strong>Giá bán:</strong></label>
                <input class="form-control" name="giaBan" id="giaBan" type="text" value="${giaBan}" >
                <div class="text-danger">${validGiaBan}</div>
            </div>
            <div class="mt-3">
                <label for="soLuongTon"><strong>Số lượng tồn:</strong></label>
                <input class="form-control" name="soLuongTon" id="soLuongTon" type="text" value="${soLuongTon}" >
                <div class="text-danger">${validSoLuongTon}</div>
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