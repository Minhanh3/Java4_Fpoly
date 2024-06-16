<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 4/13/2024
  Time: 9:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="" method="post">
    <table>
        <thead>
        <tr>
            <td>Stt</td>
            <td>ma</td>
            <td>ten</td>
            <td>soThich</td>
            <td>gioiTinh</td>
            <td>hanh dong</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ds}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.ma}</td>
                <td>${b.ten}</td>
                <td>${b.soThich}</td>
                <td>${b.gioiTinh}</td>
                <td>
                    <a href="/demo_ktra_9th4_war_exploded/ban/edit?id=${b.id}">
                        <button type="submit">edit</button>
                    </a><a href="">
                    <button type="submit">Remove</button>
                </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
