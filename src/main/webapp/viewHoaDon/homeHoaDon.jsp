<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-7">
            <div class="mt-3">
                <a class="btn btn-success" href="create-hoaDon?idKH=${kh.id}" id="createHD" >
                    Tạo hóa đơn
                </a>
                <table class="table">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên khách hàng</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Trạng thái</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listHD}" var="hd" varStatus="i">
                            <tr>
                                <td>${i.index + 1}</td>
                                <td>${hd.khachHangByIdKhachHang.hoTen}</td>
                                <td>${hd.soDienThoai}</td>
                                <td>${hd.diaChi}</td>
                                <td>${hd.trangThai}</td>
                                <td>
                                    <a href="store-hoaDon?id=${hd.id}" class="btn btn-info">Thêm SP</a>
                                    <a href="delete-hoaDon?id=${hd.id}" class="btn btn-danger">Hủy</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="mt-3">
                <div class="row border border-danger-subtle pb-2">
                    <div class="text-center mt-3">
                        <h5 class="text-danger">Tìm sản phẩm</h5>
                    </div>
                    <form action="findSP-hoaDon?idHD=${hd.id}" method="post">
                        <div class="row">
                            <div class="col-6">
                                <div class="from-group">
                                    <label for="findTenSP">Tên SP:</label>
                                    <input class="form-control" type="text" name="findTenSP" id="findTenSP">
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="findTenDanhMuc">Tên danh mục:</label>
                                    <select class="form-control" name="findTenDanhMuc" id="findTenDanhMuc">
                                        <option value="" hidden>--Chọn tên danh mục</option>
                                        <c:forEach items="${listDM}" var="danhMuc">
                                            <option value="${danhMuc.tenDanhMuc}">${danhMuc.tenDanhMuc}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="findTenMau">Tên màu:</label>
                                    <select class="form-control" name="findTenMau" id="findTenMau">
                                        <option value="" hidden>--Chọn tên màu</option>
                                        <c:forEach items="${listMauSac}" var="mauSac">
                                            <option value="${mauSac.tenMau}">${mauSac.tenMau}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label for="findTenSize">Tên size:</label>
                                    <select class="form-control" name="findTenSize" id="findTenSize">
                                        <option value="" hidden>--Chọn tên size</option>
                                        <c:forEach items="${listSize}" var="size">
                                            <option value="${size.tenSize}">${size.tenSize}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <button type="submit" class="mt-3 btn btn-info">Tìm</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-5">
            <div class="mt-3">
                <div class="text-center mt-3">
                    <h5 class="text-danger">Thông tin khách hàng</h5>
                </div>

                <form class="mt-3" action="findKH-hoaDon" method="post">
                    <div class="row">
                        <div class="col-5">
                            <label for="findKH">SĐT / Họ tên</label>
                        </div>
                        <div class="col-6">
                            <input class="form-control" type="text" name="findKH" id="findKH" value="${findKH}">
                        </div>
                        <div class="col-1">
                            <button type="submit" class="btn btn-success">Tìm</button>
                        </div>
                    </div>
                </form>
                <form action="addKH-hoaDon" method="post">
                    <div class="form-group">
                        <label for="hoTen">Họ tên</label>
                        <input type="text" class="form-control" id="hoten" name="hoTen" value="${hoTen}">
                    </div>
                    <div class="form-group">
                        <label for="diaChi">Địa chỉ</label>
                        <input type="text" class="form-control" id="diaChi" name="diaChi" value="${diaChi}">
                    </div>
                    <div class="form-group">
                        <label for="sdt">Số điện thoại</label>
                        <input type="text" class="form-control" id="sdt" name="sdt" value="${sdt}">
                    </div>
                    <button class="mt-3 btn btn-primary" type="submit">Chọn</button>
                </form>
                <table class="table">
                    <thead>
                        <tr>
                            <th>STT</th>
                            <th>Tên khách hàng</th>
                            <th>Số điện thoại</th>
                            <th>Địa chỉ</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listKH}" var="kh" varStatus="i">
                        <tr>
                            <td>${i.index + 1}</td>
                            <td>${kh.hoTen}</td>
                            <td>${kh.sdt}</td>
                            <td>${kh.diaChi}</td>
                            <td>
                                <a href="select-khachHang?idKH=${kh.id}" class="btn btn-info">Chọn</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="mt-3">
            <div class="text-center">
                <h5 class="text-danger">Danh sách sản phẩm</h5>
            </div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sản phẩm</th>
                    <th>Màu sắc</th>
                    <th>Size</th>
                    <th>Giá</th>
                    <th>Số lượng tồn</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listSP}" var="sp" varStatus="i">
                    <tr>
                        <td>${i.index + 1}</td>
                        <td>${sp.sanPhamByIdSp.tenSanPham}</td>
                        <td>${sp.mauSacByIdMauSac.tenMau}</td>
                        <td>${sp.sizeByIdSize.tenSize}</td>
                        <td><fmt:formatNumber value="${sp.giaBan}" pattern="#,###.##"/>$</td>
                        <td>${sp.soLuongTon}</td>
                        <td>
                            <a id="selectSP${i.index}" data-idsp="${sp.id}" href="#" class="btn btn-info selectSP" data-bs-toggle="modal" data-bs-target="#exampleModal">Chọn</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="row">
                <div class="col-4">
                    <div class="float-start"><a href="/prev?id=${hd.id}" class="btn btn-info">Prev</a> </div>
                </div>
                <div class="col-4">
                    <div class="text-center-center"><h5 class="text-center text-info">${index}</h5></div>
                </div>
                <div class="col-4">
                    <div class="float-end"><a href="/next?id=${hd.id}" class="btn btn-info">Next</a></div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="mt-3">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sản phẩm</th>
                    <th>Màu</th>
                    <th>Size</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th>Tổng tiền</th>
                    <th>Trạng thái</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listHDCT}" var="hdct" varStatus="i">
                        <tr>
                            <td style="width: 5%">${i.index + 1}</td>
                            <td>${hdct.ctspByIdCtsp.sanPhamByIdSp.tenSanPham}</td>
                            <td>${hdct.ctspByIdCtsp.mauSacByIdMauSac.tenMau}</td>
                            <td>${hdct.ctspByIdCtsp.sizeByIdSize.tenSize}</td>
                            <td style="width: 10%"><input class="form-control" value="${hdct.soLuongMua}" name="soLuongMua" type="number" min="1" id="soLuongMua"></td>
                            <td><fmt:formatNumber value="${hdct.giaBan}" pattern="#,###.##"/>$</td>
                            <td><fmt:formatNumber value="${hdct.tongTien}" pattern="#,###.##"/>$</td>
                            <td>${hdct.trangThai}</td>
                            <td>
                                <a href="updateSP-hoaDon?idHD=${hd.id}&idHDCT=${hdct.id}" class="btn btn-primary updateSp">Cập nhật</a>
                                <a href="deleteSP-hoaDon?idHD=${hd.id}&idHDCT=${hdct.id}" class="btn btn-danger">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th colspan="6">Tổng tiền</th>
                        <th colspan="2"><fmt:formatNumber value="${tongTien}" pattern="#,###.##"/>$</th>
                        <td>
                            <a href="paid-hoaDon?idHD=${hd.id}" class="btn btn-success">Thanh toán</a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Nhập số lượng</h5>
            </div>
            <div class="modal-body">
                <label for="quantity">Số lượng:</label>
                <input type="number" id="quantity" name="quantity" min="1" class="form-control">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" id="saveButton" class="btn btn-success" data-dismiss="modal">Save</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="modalSoLuongTonKhongDu" tabindex="-1" aria-labelledby="modalSoLuongTonKhongDuLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalSoLuongTonKhongDuLabel">Thông báo</h5>
            </div>
            <div class="modal-body">
                <p class="text-danger">${sessionScope.message}</p>
            </div>
            <div class="modal-footer">
                <button type="button" id="removeSession" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    $(document).ready(function(){
        $('#createHD').click(function(e){
            e.preventDefault();
            const idKH = $(this).attr('href').split('=')[1]; // Lấy idKH từ href của thẻ <a>
            const diaChi = $('#diaChi').val();
            const sdt = $('#sdt').val();
            $.ajax({
                url: '/create-hoaDon',
                type: 'post',
                data: { idKH: idKH, diaChi: diaChi, sdt: sdt },
                success: function(response){
                    // Chuyển hướng người dùng về /home-hoaDon mà không cần tải lại trang
                    window.location.href = '/home-hoaDon';
                }
            });
        });

        $(document).ready(function(){
            $('.updateSp').click(function(e){
                e.preventDefault();
                const href = $(this).attr('href');
                const url = new URL(href, window.location.origin);
                const idHD = url.searchParams.get("idHD");
                const idHDCT = url.searchParams.get("idHDCT");
                // Lấy giá trị từ thẻ <input> trong cùng một hàng với thẻ <a> được nhấp
                const soLuongMua = $(this).closest('tr').find('input[name="soLuongMua"]').val();
                $.ajax({
                    url: '/updateSP-hoaDon',
                    type: 'post',
                    data: { idHD: idHD, idHDCT: idHDCT, soLuongMua: soLuongMua },
                    success: function(){
                        window.location.href = 'store-hoaDon?id='+idHD;
                    },
                    error: function(jqXHR, textStatus, errorThrown){
                        console.log(textStatus, errorThrown);
                    }
                });
            });
        });
    });
</script>
<script>
    $(document).ready(function(){
        $(".selectSP").click(function(e){
            e.preventDefault();
            const idSP = $(this).data("idsp");
            $("#saveButton").data("idsp", idSP);
        });

        $("#saveButton").click(function(){
            const quantity = $("#quantity").val();
            const idSP = $(this).data("idsp");
            window.location.href = "select-sanPham?idHD=${hd.id}&idSP=" + idSP + "&quantity=" + quantity;
        });
    });
</script>
<c:if test="${not empty sessionScope.message}">
    <script>
        $(document).ready(function() {
            $("#modalSoLuongTonKhongDu").modal("show");
            $("#removeSession").click(function () {
                sessionStorage.removeItem("message");
            })
        });
    </script>
</c:if>
