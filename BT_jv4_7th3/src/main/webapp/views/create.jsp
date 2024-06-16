<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS v5.3.2 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>

<body>
<div class="container">
    <form method="POST" action="/BT_jv4_7th3_war_exploded/mau-sac/store" class="row g-3 needs-validation mt-5" novalidate>
        <div class="col-md-8">
            <label for="ma" class="form-label">Mã</label>
            <input type="text" class="form-control" id="ma" name="ma" value="" required>
        </div>
        <div class="col-md-8">
            <label for="" class="form-label">Tên</label>
            <input type="text" class="form-control" id="ten" name="name" value="" required>
        </div>
        <div class="col-md-8">
            <label class="form-label">Trạng thái</label>
            <div>
                <input class="form-check-input" type="radio" value="0" checked name="trangthai"> Hoạt Động
                <input class="form-check-input" type="radio" value="1" name="trangthai"> Không hoạt động
            </div>
        </div>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Thêm</button>
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
