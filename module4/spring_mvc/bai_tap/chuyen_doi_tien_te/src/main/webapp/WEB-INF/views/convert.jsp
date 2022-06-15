<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/15/2022
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/convert" method="post">
    <fieldset>
      <legend>Currency conversion</legend>
      <table>
        <tr>
          <td>VND</td>
          <td>
            <input type="text" name="vnd" value="${vnd}">
          </td>
        </tr>
        <tr>
          <td>USD</td>
          <td>
            <input type="text" value="${usd}" readonly>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <button>Convert</button>
          </td>
        </tr>
      </table>
    </fieldset>
  </form>
  </body>
</html>
