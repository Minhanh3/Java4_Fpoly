<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/30/2024
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="../hoa-don/store">
    <div>
        <span>ID K</span>
        <input type="text" name="id">
    </div><div>
        <span>ID Khach Hang</span>
        <input type="text" name="idKhachHang">
    </div>
    <div>
        <span>ID Nhan Vien</span>
        <input type="text" name="idNhanVien">
    </div>
    <div>
        <span>Ngay Mua Hang</span>
        <input type="date" name="ngayMuaHang">
    </div>
    <div>
        <span>Trang Thai</span>
        <input type="radio" name="trangThai" checked value="1">Hoat Dong
        <input type="radio" name="trangThai"  value="0">Ngung Hoat Dong
    </div>

    <button type="submit">Add</button>
</form>
</body>
</html>
