<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Caculator</h1>
<form action="/calculator" method="post">
    <input type="text" name="firstNumber">
    <input type="text" name="secondNumber">
    <br>
    <hr>
    <input type="submit" name="operator" value="+">
    <input type="submit" name="operator" value="-">
    <input type="submit" name="operator" value="*">
    <input type="submit" name="operator" value="/">
</form>
<h1>Result: ${result}</h1>
<h3 style="color: red">${alert}</h3>
</body>
</html>
