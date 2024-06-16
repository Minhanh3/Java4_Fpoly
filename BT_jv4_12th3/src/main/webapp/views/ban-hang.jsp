<%-- Created by IntelliJ IDEA. User: Manhdepzai Date: 4/3/2024 Time: 2:52 PM To change this template use File | Settings
    | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>

<head>
    <title>Trang Chủ</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous"/>
</head>

<body>
<div class="container">
    <nav class="navbar navbar-expand-sm navbar-dark bg-primary">
        <a class="navbar-brand" href="/BT_jv4_12th3_war_exploded/">Home</a>
        <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
                data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation"></button>
        <div class="collapse navbar-collapse" id="collapsibleNavId">
            <ul class="navbar-nav me-auto mt-2 mt-lg-0">
                <!-- <li class="nav-item">
    <a class="nav-link active" href="#" aria-current="page">Home <span
            class="visually-hidden">(current)</span></a> -->
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownId"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Hóa Đơn</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/hoa-don/index">Hóa Đơn
                        </a>
                        <a class="dropdown-item"
                           href="/BT_jv4_12th3_war_exploded/hoa-don-chitiet/index">Hóa Đơn Chi
                            Tiết</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BT_jv4_12th3_war_exploded/nhan-vien/index">Nhân Viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BT_jv4_12th3_war_exploded/khach-hang/index">Khách
                        Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BT_jv4_12th3_war_exploded/ban-hang/index">Bán Hàng</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="/BT_jv4_12th3_war_exploded/san-pham/index"
                       id="" data-bs-toggle="dropdown" aria-expanded="false">Sản Phẩm</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/san-pham/index">Sản
                            Phẩm </a>
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/sp-chitiet/index">Sản
                            Phẩm Chi
                            Tiết</a>
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/mau-sac/index">Màu
                            Sắc</a>
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/kich-thuoc/index">Kích
                            Thước</a>
                    </div>

                </li>
            </ul>
            <form class="d-flex my-2 my-lg-0">
                <input class="form-control me-sm-2" type="text" placeholder="Search"/>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                    Search
                </button>
            </form>
        </div>
    </nav>
</div>
<div class="row">
    <div class="col-7">
        <h4>Danh Sách Hóa Đơn</h4>
        <div class="table-responsive ">
            <table class="table table-primary">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">ID Nhan Vien</th>
                    <th scope="col">ID Khach Hang</th>
                    <th scope="col">Ngay Tao</th>
                    <th scope="col">Trang Thai</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listHd}" var="ms">
                    <tr>
                        <td>${ms.id}</td>
                        <td>${ms.idNhanVien}</td>
                        <td>${ms.idKhachHang}</td>
                        <td>${ms.ngayMuaHang}</td>
                        <td>${ms.trangThai}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-5">
        <h5>Tao Hoa Don</h5>
        <form action="/BT_jv4_12th3_war_exploded/hoa-don/store" method="post">
            <div class="mb-3 col-11">
                <label for="" class="form-label">id NhanVien</label>
                <input type="text" name="idNhanVien" class="form-control" aria-describedby="helpId"/>
                <div class="form-text text-danger">${err.idNhanVien}</div>
            </div>
            <div class="mb-3 col-11">
                <label for="" class="form-label">id KhachHang</label>
                <input type="text" name="idKhachHang" class="form-control" aria-describedby="helpId"/>
                <div class="form-text text-danger">${err.idKhachHang}</div>
            </div>
            <div class="mb-3 col-11">
                <label for="" class="form-label">Ngay Mua Hang</label>
                <input type="date" name="ngayMuaHang" class="form-control aria-describedby=" helpId" />
                <div class="form-text text-danger">${err.ngayMuaHang}</div>
            </div>
            <label for="" class="form-label">Trang thai</label>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="1" checked>
                <label class="form-check-label" for="">
                    Hoat Dong
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="radio" name="trangThai" value="0">
                <label class="form-check-label" for="">
                    Ngung Hoat Dong
                </label>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Thêm</button>
                <button type="reset" class="btn btn-primary">Reset</button>
            </div>
        </form>
    </div>
    <div class="col-7">
        <h5>Gio Hang</h5>
        <div class="table-responsive">
            <table class="table table-primary">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Ma</th>
                    <th scope="col">Ten</th>
                    <th scope="col-2">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listSp}" var="ms">
                    <tr>
                        <td>${ms.id}</td>
                        <td>${ms.ma}</td>
                        <td>${ms.ten}</td>
                        <td>
                            <a
                                    href="/BT_jv4_12th3_war_exploded/sp-chitiet/create?IdSanPham=${ms.id}">
                                <button type="button" class="btn btn-danger">Xoa Gio
                                    Hang
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-7">
        <h4>Danh Sach San Pham</h4>
        <div class="table-responsive">
            <table class="table table-primary">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Ma</th>
                    <th scope="col">Ten</th>
                    <th scope="col">Trang Thai</th>
                    <th scope="col-2">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listSp}" var="ms">
                    <tr>
                        <td>${ms.id}</td>
                        <td>${ms.ma}</td>
                        <td>${ms.ten}</td>
                        <td>${ms.trangThai == 1 ? "Hoat Dong" : "Ngung Hoat Dong"}</td>
                        <td>
                            <a
                                    href="/BT_jv4_12th3_war_exploded/sp-chitiet/create?IdSanPham=${ms.id}">
                                <button type="button" class="btn btn-primary">Thêm Gio
                                    Hang
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>