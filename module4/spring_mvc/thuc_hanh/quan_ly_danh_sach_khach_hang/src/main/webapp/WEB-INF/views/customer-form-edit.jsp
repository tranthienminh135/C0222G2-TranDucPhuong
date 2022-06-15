<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/edit" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <table>
            <tr>
                <td>Id</td>
                <td>
                    <input type="text" readonly name="id" value="${customer.customerId}">
                </td>
            </tr>
            <tr>
                <td>Name</td>
                <td>
                    <input type="text" name="name" value="${customer.customerName}">
                </td>
            </tr>
            <tr>
                <td>Age</td>
                <td>
                    <input type="text" name="age" value="${customer.customerAge}">
                </td>
            </tr>
            <tr>
                <td>Point</td>
                <td>
                    <input type="text" name="point" value="${customer.customerPoint}">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>Edit</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
<button type="button"><a href="/customer">Back to list</a></button>
</body>
</html>
