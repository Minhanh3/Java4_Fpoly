<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 20/03/2024
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body class="shadow-lg p-4 mb-5 bg-body rounded container">
<form action="">

</form>

<form action="/giang-vien/search" method="get">
    ten
    <input type="text" name="ten">
    gioi tinh:
    <select name="gioiTinh">
        <option value="true">nam</option>
        <option value="false">nu</option>
    </select>
    <button type="submit">Search</button>
</form>
<form action="/giang-vien/them" method="post">
    <div class="mb-3">
        <label class="form-label">id</label>
        <input type="text" class="form-control" name="id" disabled value="${detail.id}">
        <div class="form-text text-danger">${err.id}</div>
    </div>
    <div class="mb-3">
        <label class="form-label">mã</label>
        <input type="text" class="form-control" name="maGV" value="${detail.maGV}">
        <div class="form-text text-danger">${err.ma}</div>
    </div>
    <div class="mb-3">
        <label class="form-label">ten</label>
        <input type="text" class="form-control" name="tenGV"value="${detail.tenGV}">
        <div class="form-text text-danger">${err.ten}</div>
    </div>
    <div class="mb-3">
        <label class="form-label">tuoi</label>
        <input type="text" class="form-control" name="tuoi"value="${detail.tuoi}">
        <div class="form-text text-danger">${err.tuoi}</div>
    </div>
    <div class="mb-3">
        <label class="form-label">gioi tinh</label>
        <input type="radio"   name="gioiTinh" ${detail.gioiTinh?"":"checked"} value="false">nu
        <input type="radio" name="gioiTinh" ${detail.gioiTinh?"checked":""} value="true">nam
        <div class="form-text text-danger">${err.gioiTinh}</div>
    </div>
    <div class="mb-3">
        <label class="form-label">dia chi</label>
        <select name="diaChi">
            <option value="HN" ${detail.diaChi eq 'HN' ? "selected" : ""}>HN</option>
            <option value="HCM" ${detail.diaChi eq 'HCM' ? "selected" : ""}>HCM</option>
        </select>
        <div class="form-text text-danger">${err.diaChi}</div>
    </div>
    <button type="submit">thêm</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Id</th>
        <th scope="col">Ma</th>
        <th scope="col">Ten</th>
        <th scope="col">tuoi</th>
        <th scope="col">gioi tinh</th>
        <th scope="col">dia chi</th>
        <th scope="col"> </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach varStatus="i" items="${list}" var="item">
        <tr>
            <td>${i.index+1}</td>
            <td>${item.id}</td>
            <td>${item.maGV}</td>
            <td>${item.tenGV}</td>
            <td>${item.tuoi}</td>
            <td>${item.gioiTinh?"Nam":"Nu"}</td>
            <td>${item.diaChi}</td>
            <td>
                <a href="/giang-vien/update?ma=${item.maGV}" class="btn btn-warning" >update</a>
                <a href="/giang-vien/detail?ma=${item.maGV}"class="btn btn-warning">detail</a>
                <a href="/giang-vien/delete?ma=${item.maGV}"class="btn btn-warning">delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
