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
<form method="post" action="home?action=edit">
    <fieldset>
        <legend>EDIT PRODUCT</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input name="id" type="text" value="${id}" readonly/></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input name="name" type="text" value="${name}"/></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input name="price" type="text" value="${price}"/></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input name="description" type="text" value="${description}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><button type="submit">Submit</button></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
