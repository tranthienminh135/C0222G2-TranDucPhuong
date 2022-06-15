<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<style>
    td {
        padding: 10px;
    }
</style>
<body>

<table border="1">
    <caption><button type="button"><a href="/add">Add new Customer</a></button></caption>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Point</th>
        <th>Delete</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCustomer}" var="i">
        <tr>
            <td>${i.customerId}</td>
            <td>${i.customerName}</td>
            <td>${i.customerAge}</td>
            <td>${i.customerPoint}</td>
            <td><button type="button"><a href="/delete?idDelete=${i.customerId}">Delete</a></button></td>
            <td><button type="button"><a href="/edit?idEdit=${i.customerId}">Edit</a></button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
