<%-- Created by IntelliJ IDEA. User: Manhdepzai Date: 3/12/2024 Time: 10:56 PM To change this template use File |
    Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!doctype html>
<html lang="en">

<head>
    <title>Danh Sách Khách Hàng</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous" />
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
                    <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        Hóa Đơn</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/hoa-don/index">Hóa Đơn </a>
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/hoa-don-chitiet/index">Hóa Đơn
                            Chi
                            Tiết</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BT_jv4_12th3_war_exploded/nhan-vien/index">Nhân Viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BT_jv4_12th3_war_exploded/khach-hang/index">Khách Hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/BT_jv4_12th3_war_exploded/ban-hang/index">Bán Hàng</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="/BT_jv4_12th3_war_exploded/san-pham/index"
                       id="dropdownId" data-bs-toggle="dropdown" aria-expanded="false">Sản Phẩm</a>
                    <div class="dropdown-menu" aria-labelledby="dropdownId">
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/san-pham/index">Sản Phẩm </a>
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/sp-chitiet/index">Sản Phẩm Chi
                            Tiết</a>
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/mau-sac/index">Màu Sắc</a>
                        <a class="dropdown-item" href="/BT_jv4_12th3_war_exploded/kich-thuoc/index">Kích
                            Thước</a>
                    </div>

                </li>
            </ul>
            <form class="d-flex my-2 my-lg-0">
                <input class="form-control me-sm-2" type="text" placeholder="Search" />
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                    Search
                </button>
            </form>
        </div>
    </nav>
    <div class="mt-3">
        <a href="/BT_jv4_12th3_war_exploded/khach-hang/create"><button type="button" class="btn btn-primary">Thêm Khách Hàng</button> </a>
    </div>
    <h4>Danh Sách Khách Hàng</h4>
    <div class="table-responsive">

        <table class="table table-primary">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Tên</th>
                <th scope="col">SDT</th>
                <th scope="col">Ma</th>
                <th scope="col">Trang Thai</th>
                <th scope="col-2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ds}" var="kh">
                <tr>
                    <td>${kh.id}</td>
                    <td>${kh.ten}</td>
                    <td>${kh.sdt}</td>
                    <td>${kh.ma}</td>
                    <td>${kh.trangThai == 1 ? "Hoat Dong" : "Ngung Hoat Dong"}</td>
                    <td>
                        <a href="/BT_jv4_12th3_war_exploded/khach-hang/edit?id=${kh.id}">
                            <button type="button" class="btn btn-info">Update</button></a>
                        <a href="/BT_jv4_12th3_war_exploded/khach-hang/delete?id=${kh.id}">
                            <button type="button" class="btn btn-danger">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
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