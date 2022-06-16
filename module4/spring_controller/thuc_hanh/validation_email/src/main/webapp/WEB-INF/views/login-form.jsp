<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2022
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/login" method="post">
    <fieldset>
      <legend>Login</legend>
      <table>
        <tr>
          <td>Email</td>
          <td>
            <input type="text" name="email" value="${email}">
          </td>
        </tr>
        <tr>
          <td>Password</td>
          <td>
            <input type="password" name="password" value="${password}" >
          </td>
        </tr>
        <tr>
          <td style="color: red" colspan="2">
            ${alert}
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <button>Login</button>
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
  </body>
</html>
