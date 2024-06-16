<%-- Created by IntelliJ IDEA. User: Manhdepzai Date: 3/19/2024 Time: 8:04 AM To change this template use File |
    Settings | File Templates. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"/>
</head>

<body>
<div class="container">
    <h2>Thêm Hóa Đơn</h2>
    <form action="/BT_jv4_12th3_war_exploded/hoa-don/store" method="post">
        <div class="mb-3 col-7">
            <label for="" class="form-label">id NhanVien</label>
            <input type="text" name="idNhanVien" class="form-control" aria-describedby="helpId" />
            <div class="form-text text-danger">${err.idnv}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">id KhachHang</label>
            <input type="text" name="idKhachHang" class="form-control" aria-describedby="helpId" />
            <div class="form-text text-danger">${err.idkh}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">Ngay Mua Hang</label>
            <input type="date" name="ngayMuaHang" class="form-control aria-describedby=" helpId" />
            <div class="form-text text-danger">${err.ngayMuaHang}</div>
        </div>
        <label for="" class="form-label">Trang thai</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" value="1" checked>
            <label class="form-check-label" for="flexRadioDefault1">
                Hoat Dong
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="trangThai" value="0">
            <label class="form-check-label" for="flexRadioDefault2">
                Ngung Hoat Dong
            </label>
        </div>
        <div class="mt-3">
            <a href="/BT_jv4_12th3_war_exploded/hoa-don/index">
                <button type="button" class="btn btn-primary">Quay Lại</button>
            </a>
            <button type="submit" class="btn btn-primary">Thêm</button>
            <button type="reset" class="btn btn-primary">Reset</button>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>