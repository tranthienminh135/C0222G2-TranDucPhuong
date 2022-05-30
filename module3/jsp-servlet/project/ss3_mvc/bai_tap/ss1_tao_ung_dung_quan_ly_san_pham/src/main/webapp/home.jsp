<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2022
  Time: 2:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="home?action=create">
    <button type="submit">Add new product</button>
</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${listProduct}" var="i">
        <tr>
            <td>${i.id}</td>
            <td><a href="home?action=info&id=${i.id}">${i.name}</a></td>
            <td><a href="home?action=delete&id=${i.id}">
                <button type="submit">Delete</button>
            </a></td>
            <td><a href="home?action=edit&id=${i.id}">
                <button type="submit">Edit</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
<form action="home?action=search" method="post">
    <input type="text" name="searchValue">
    <button type="submit">Search</button>
</form>
</body>
</html>
