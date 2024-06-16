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
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous"/>
</head>

<body>
<div class="container">
    <h2>Chỉnh Sửa Hóa Đơn Chi Tiết</h2>
    <form action="/BT_jv4_12th3_war_exploded/hoa-don-chitiet/update?id=${hdct.id}" method="post">
        <div class="mb-3 col-7">
            <label for="" class="form-label">ID</label>
            <input type="text" name="id" value="${hdct.id}" class="form-control" aria-describedby="helpId" disabled
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">id HoaDon</label>
            <input type="text" name="idHoaDon" value="${hdct.idHoaDon}" class="form-control" aria-describedby="helpId"/>
            <div class="form-text text-danger">${err.idHoaDon}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">id SPCT</label>
            <input type="text" name="idSPCT" value="${hdct.idSPCT}" class="form-control" aria-describedby="helpId"/>
            <div class="form-text text-danger">${err.idSPCT}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">So luong</label>
            <input type="text" name="soLuong" value="${hdct.soLuong}" class="form-control aria-describedby=" helpId" />
            <div class="form-text text-danger">${err.soLuong}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">Don gia</label>
            <input type="text" name="donGia" value="${hdct.donGia}" class="form-control aria-describedby=" helpId" />
            <div class="form-text text-danger">${err.donGia}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">thoi Gian</label>
            <input type="date" name="thoiGian" value="${hdct.thoiGian}" class="form-control aria-describedby=" helpId"
            />
            <div class="form-text text-danger">${err.thoiGian}</div>
        </div>
        <label for="" class="form-label">Trang thai</label>
        <div class="form-check">
            <input class="form-check-input"
            ${hdct.trangThai==1 ? "checked" : "" }
                   type="radio" name="trangThai" value="1" checked>
            <label class="form-check-label" for="">
                Hoat Dong
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input"
            ${hdct.trangThai==0 ? "checked" : "" }
                   type="radio" name="trangThai" value="0" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Ngung Hoat Dong
            </label>
        </div>
        <div class="mt-3">
            <a href="/BT_jv4_12th3_war_exploded/hoa-don-chitiet/index">
                <button type="button" class="btn btn-primary">Quay Lại</button>
            </a>
            <button type="submit" class="btn btn-primary">Update</button>
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