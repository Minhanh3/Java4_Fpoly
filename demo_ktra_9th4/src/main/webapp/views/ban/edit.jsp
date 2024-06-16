<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 4/13/2024
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <label for="">Ma</label>
    <input type="text" name="ma" id="" value="${b.ma}">
</div>
<div>
    <label for="">ten</label>
    <input type="text" name="ten" id="" value="${b.ten}">
</div>
<div>
    <label for="">soThich</label>
    <input type="text" name="soThich" id="" value="${b.soThich}">
</div>
<div>
    <label for="">gioiTinh</label>
    <input type="radio" name="gioiTinh"  ${b.gioiTinh == 1 ? "checked" : ""}>Nam
    <input type="radio" name="gioiTinh"  ${b.gioiTinh == 0 ? "checked" : ""}>Nu
</div>
<div>
    <button type="submit">Update</button>
</div>
</body>
</html>
