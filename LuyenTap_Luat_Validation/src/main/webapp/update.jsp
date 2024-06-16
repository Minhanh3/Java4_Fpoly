<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 21/03/2024
  Time: 01:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/sua?ma=${detail.maGV}" method="post">
    <div class="mb-3">
        <label class="form-label">id</label>
        <input type="text" class="form-control" name="id"  value="${detail.id}">
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
    <button type="submit">sua</button>
</form>
</body>
</html>
