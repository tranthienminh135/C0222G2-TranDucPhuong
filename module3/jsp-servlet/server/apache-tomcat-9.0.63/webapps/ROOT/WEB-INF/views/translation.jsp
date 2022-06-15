<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/translation" method="post">
    <fieldset>
        <legend>Dictionary</legend>
        <table>
            <tr>
                <td>English</td>
                <td>
                    <input type="text" name="english" value="${english}">
                </td>
            </tr>
            <tr>
                <td>Vietnamese</td>
                <td>
                    <input type="text" value="${vietnamese}" readonly>
                </td>
            </tr>
            <tr>
                <td style="color: red" colspan="2">
                    ${alert}
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>Translate</button>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
