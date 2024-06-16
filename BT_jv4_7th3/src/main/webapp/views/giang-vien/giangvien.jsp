<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/27/2024
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Ma Gv</th>
        <th scope="col">Ho Ten</th>
        <th scope="col">Tuoi</th>
        <th scope="col">Que Quan</th>
        <th scope="col">Gioi Tinh</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${a}" var="gv">
        <tr>
            <th scope="row">${gv.mssv}</th>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.queQuan}</td>
            <td>${gv.gioiTinh == true ? "Nam" : "Nu"}</td>
            <td>Action</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
