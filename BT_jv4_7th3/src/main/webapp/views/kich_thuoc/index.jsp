<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/12/2024
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <td>ID</td>
            <td>Tên</td>
            <td>Mã</td>
            <td>Trang Thái</td>
        </tr>
        </thead>
        <tbody >
        <c:forEach items="${ ds }" var="ms">
            <tr>
                <td>1</td>
                <td>${ms.ten} </td>
                <td>${ms.ma} </td>
                <td>${ms.trangThai}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
