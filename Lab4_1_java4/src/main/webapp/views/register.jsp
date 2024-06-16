<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/20/2024
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>
<body>
<div class="container">
    <div class="row">
        <h2>Đăng Ký</h2>
        <form action="./UserServlet" method="get">
            <input type="hidden" class="form-control" name="action" value="SaveOrUpdate">
            <div class="mb-3">
                <label for="" class="form-label">Username</label>
                <input type="text" name="username" id="" class="form-control" placeholder=""
                       aria-describedby="helpId" />
            </div>
            <div class="mb-3">
                <label for="" class="form-label">Password</label>
                <input type="password" name="password" id="" class="form-control" placeholder=""
                       aria-describedby="helpId" />
            </div>
            <div class="mb-3">
                <label for="" class="form-label">FullName</label>
                <input type="text" name="fullname" id="" class="form-control" placeholder=""
                       aria-describedby="helpId" />
            </div>
            <div class="mb-3">
                <label for="" class="form-label">Age</label>
                <input type="number" name="age" id="" class="form-control" placeholder=""
                       aria-describedby="helpId" />
            </div>
            <div class="mb-3">
                <label for="" class="form-label">Birthday</label>
                <input type="date" name="birthday" id="" class="form-control" placeholder=""
                       aria-describedby="helpId" />
            </div>
            <div class="mb-3">
                <label for="" class="form-label">Gender</label>
                <div class="radio">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" value="1" id="" />
                        <label class="form-check-label" for=""> Male </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gender" value="0" id="" checked />
                        <label class="form-check-label" for=""> Famale </label>
                    </div>
                </div>
            </div>
            <div>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-primary">Cancel</button>
                <a href="UserServlet?action=List" class="btn btn-primary">Display users</a>
            </div>
        </form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>
</html>
