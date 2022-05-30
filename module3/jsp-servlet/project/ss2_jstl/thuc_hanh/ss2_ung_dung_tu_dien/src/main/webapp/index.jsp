<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2022
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<head>
  <title>Simple Dictionary</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form action="dictionary" method="post">
  <input type="text" name="search" placeholder="Enter your word: "/>
  <input type = "submit" id = "submit" value = "Search"/>
</form>
<h1>Search: ${search}</h1>
<h1>Result: ${result}</h1>
<h1>Alert: ${alert}</h1>
</body>
</html>
