<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/12/2024
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
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
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th colspan="2">Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ ds }" var="ms">
            <tr>
                <td>${ ms.id}</td>
                <td>${ ms.ma }</td>
                <td>${ ms.ten }</td>
                <td>${ ms.trangthai == 1 ? "Hoạt Động" : "Không Hoạt Động"}</td>
                <td>
                    <a href="#">
                        <button class="btn btn-primary">Detail</button></a>
                </td>
                <td>
                    <a href="#">
                        <button class="btn btn-info">Update</button></a>
                </td>
                <td>
                    <a href="/BT_jv4_7th3_war_exploded/mau-sac/delete?ma=${ ms.ma }">
                        <button class="btn btn-danger"> Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>
</html>

