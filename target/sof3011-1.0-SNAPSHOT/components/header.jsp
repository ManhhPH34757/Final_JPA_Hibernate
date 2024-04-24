<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-body-tertiary m-0 p-0">
    <!-- Container wrapper -->
    <div class="container-fluid">
        <!-- Toggle button -->
        <button
                data-mdb-collapse-init
                class="navbar-toggler"
                type="button"
                data-mdb-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <i class="fas fa-bars"></i>
        </button>

        <!-- Collapsible wrapper -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <!-- Navbar brand -->
            <a class="navbar-brand mt-lg-0" href="#">
                <img
                        src="https://logos.textgiraffe.com/logos/logo-name/Manh-designstyle-cartoon-m.png"
                        height="70"
                        alt="Manh Logo"
                        loading="lazy"
                />
            </a>
            <!-- Left links -->
            <ul class="navbar-nav mt-2 me-auto mb-lg-0">
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="${pageContext.request.contextPath}/">Trang chủ</a></h5>
                </li>
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="home-khachHang">Khách hàng</a></h5>
                </li>
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="home-sanPham">Sản phẩm</a></h5>
                </li>
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="home-danhMuc">Danh mục</a></h5>
                </li>
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="home-mauSac">Màu sắc</a></h5>
                </li>
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="home-size">Size</a></h5>
                </li>
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="home-hoaDon">Tạo hóa đơn</a></h5>
                </li>
                <li class="nav-item me-2">
                    <h5><a class="nav-link" href="hoaDonPaid">Danh sách hóa đơn</a></h5>
                </li>
            </ul>
            <!-- Left links -->
        </div>
        <!-- Collapsible wrapper -->

        <!-- Right elements -->
        <div class="d-flex align-items-center">
            <!-- Icon -->
            <a class="text-reset me-3" href="#">
                <i class="fas fa-shopping-cart"></i>
            </a>

            <!-- Notifications -->
            <div class="dropdown">
                <a
                        data-mdb-dropdown-init
                        class="text-reset me-3 dropdown-toggle hidden-arrow"
                        href="#"
                        id="navbarDropdownMenuLink"
                        role="button"
                        aria-expanded="false"
                >
                    <i class="fas fa-bell"></i>
                    <span class="badge rounded-pill badge-notification bg-danger">1</span>
                </a>
                <ul
                        class="dropdown-menu dropdown-menu-end"
                        aria-labelledby="navbarDropdownMenuLink"
                >
                    <li>
                        <a class="dropdown-item" href="#">Some news</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Another news</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </li>
                </ul>
            </div>
            <!-- Avatar -->
            <div class="dropdown">
                <a
                        data-mdb-dropdown-init
                        class="dropdown-toggle d-flex align-items-center hidden-arrow"
                        href="#"
                        id="navbarDropdownMenuAvatar"
                        role="button"
                        aria-expanded="false"
                >
                    <img
                            src="https://yt3.googleusercontent.com/8xBXPYt4495d4icf-IiSukUzZ9CmyIXL7VpQLbNHGSyzMT_mb401RdAPEDhhaSbj8A2Oczfh=s900-c-k-c0x00ffffff-no-rj"
                            class="rounded-circle"
                            height="30"
                            alt="Black and White Portrait of a Man"
                            loading="lazy"
                    />
                </a>
                <ul
                        class="dropdown-menu dropdown-menu-end"
                        aria-labelledby="navbarDropdownMenuAvatar"
                >
                    <li>
                        <a class="dropdown-item" href="#">My profile</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Settings</a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- Right elements -->
    </div>
    <!-- Container wrapper -->
</nav>
<!-- Navbar -->