<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2022
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="home?action=create">
    <fieldset>
        <legend>ADD NEW PRODUCT</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input name="id" type="text"/></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input name="name" type="text"/></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input name="price" type="text"/></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input name="description" type="text"/></td>
            </tr>
            <tr>
                <td><a href="home"><button type="button">Back to Home</button></a></td>
                <td><button type="submit">Submit</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
