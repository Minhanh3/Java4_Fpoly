<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/19/2024
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<%--<%@taglib uri="jakarta.tags.core" prefix="fmt" %>--%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>
<body>
<div class="container">
    <h2>List Users</h2>
    <a href="./UserServlet?action=AddOrEdit" class="btn btn-primary">Add User</a>
    <div class="table-responsive">
        <table class="table table-primary">
            <thead>
            <tr>
                <th scope="col">Username</th>
                <th scope="col">PassWord</th>
                <th scope="col">FullName</th>
                <th scope="col">Age</th>
                <th scope="col">Birthday</th>
                <th scope="col">Gender</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr class="">
                    <td scope="row">${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.fullname}</td>
                    <td>${user.age}</td>
                    <td><fmt:formatDate value="${user.birthday}" pattern="dd/MM/yyyy" /></td>
                    <td>${user.gender? "Nam" : "Nu" }</td>
                    <td>
                        <a href="UserServlet?action=AddOrEdit&username=fpoly"
                           class="btn btn-primary btn-sm">Edit</a>
                        <a href="UserServlet?action=Delete&username=fpoly" class="btn btn-danger btn-sm">Del</a>
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
</div>
</body>
</html>
