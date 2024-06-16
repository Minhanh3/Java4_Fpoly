<%--
  Created by IntelliJ IDEA.
  User: Manhdepzai
  Date: 3/8/2024
  Time: 11:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator </h1>
<hr>
<form action="/Calculator_8th3_war_exploded/CalculatorServlet" method="post">
    <p><input type="text" name="numberA"></p>
    <p><input type="text" name="numberB"></p>
    <hr>
    <input type="submit" name="action" value="+">
    <input type="submit" name="action" value="-">
    <input type="submit" name="action" value="x">
    <input type="submit" name="action" value="/">
</form>
</body>
</html>
