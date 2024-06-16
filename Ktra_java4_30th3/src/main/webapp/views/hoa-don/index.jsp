<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/30/2024
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // Ẩn tất cả các bảng khi tải trang
            $(".table-container").hide();

            // Xử lý sự kiện khi người dùng chọn một tùy chọn
            $("#select-menu").change(function() {
                var selectedOption = $(this).val();

                // Ẩn tất cả các bảng
                $(".table-container").hide();

                // Hiển thị bảng tương ứng với tùy chọn được chọn
                $("#table-" + selectedOption).show();
            });
        });
    </script>
</head>
<body>
<a href="../hoa-don/create">
    <button type="submit">Them Hoa Don</button></a>
<div>
    <select id="select-menu" class="form-select" aria-label="Default select example">
        <option selected disabled>Open this select menu</option>
        <option value="1">Option 1</option>
        <option value="2">Option 2</option>
        <option value="3">Option 3</option>
    </select>

    <div id="table-1" class="table-container">
        <table class="table" >
            <thead>
            <tr>
                <th>ID</th>
                <th>ID Khach Hang</th>
                <th>ID Nhan Vien</th>
                <th>Ngay Mua Hang</th>
                <th>Trang Thai</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${ds}" var="hd">
                <tr>
                    <td>${hd.id}</td>
                    <td>${hd.idKhachHang}</td>
                    <td>${hd.idNhanVien}</td>
                    <td>${hd.ngayMuaHang}</td>
                    <td>${hd.trangThai == 1 ? "Hoat Dong" : "Ngung Hoat Dong"}</td>
                    <td>
                        <a href="../hoa-don/delete?id=${hd.id}">
                            <button type="submit">Delete</button></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div id="table-2" class="table-container">
        <table class="table" >
            <thead>
            <tr>
                <th>ID</th>
                <th>Ten</th>
                <th>Ma</th>
                <th>Ten Dang nhap</th>
                <th>Mat khau</th>
                <th>Trang thai</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dsnv}" var="hd">
                <tr>
                    <td>${hd.id}</td>
                    <td>${hd.ten}</td>
                    <td>${hd.ma}</td>
                    <td>${hd.tenDangNhap}</td>
                    <td>${hd.matKhau}</td>
                    <td>${hd.trangThai == 1 ? "Hoat Dong" : "Ngung Hoat Dong"}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
