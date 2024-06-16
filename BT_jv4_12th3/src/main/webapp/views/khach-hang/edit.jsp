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
    <h2>Chỉnh Sửa Khách Hàng</h2>
    <form action="/BT_jv4_12th3_war_exploded/khach-hang/update?id=${kh.id}" method="post">
        <div class="mb-3 col-7">
            <label for="" class="form-label">Id</label>
            <input type="text" name="id" value="${kh.id}" class="form-control" aria-describedby="helpId"/>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">Mã KH</label>
            <input type="text" name="ma" value="${kh.ma}" class="form-control aria-describedby=" helpId" />
            <div class="form-text text-danger">${err.ma}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">Tên</label>
            <input type="text" name="ten" value="${kh.ten}" class="form-control" aria-describedby="helpId"/>
            <div class="form-text text-danger">${err.ten}</div>
        </div>
        <div class="mb-3 col-7">
            <label for="" class="form-label">SDT</label>
            <input type="text" name="sdt" value="${kh.sdt}" class="form-control aria-describedby=" helpId" />
            <div class="form-text text-danger">${err.sdt}</div>
        </div>
        <label for="" class="form-label">Trang thai</label>
        <div class="form-check">
            <input class="form-check-input"
            ${kh.trangThai==1 ? "checked" : "" }
                   type="radio" name="trangThai" value="1" checked>
            <label class="form-check-label" for="">
                Hoat Dong
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input"
            ${kh.trangThai==0 ? "checked" : "" }
                   type="radio" name="trangThai" value="0" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Ngung Hoat Dong
            </label>
        </div>
        <div class="mt-3">
            <a href="/BT_jv4_12th3_war_exploded/khach-hang/index">
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