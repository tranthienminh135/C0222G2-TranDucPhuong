<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2022
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form method="post" action="calculate">
  <fieldset>
    <legend>Calculator</legend>
    <table>
      <tr>
        <td>First operand: </td>
        <td><input name="first-operand" type="text" value="${first}"/></td>
      </tr>
      <tr>
        <td>Operator: </td>
        <td><select name="operator">
          <c:choose>
            <c:when test="${operator == '+'}">
              <h1>abd</h1>
              <option value="+">Addition</option>
              <option value="-">Subtraction</option>
              <option value="*">Multiplication</option>
              <option value="/">Division</option>
            </c:when>
            <c:when test="${operator == '-'}">
              <option value="-">Subtraction</option>
              <option value="+">Addition</option>
              <option value="*">Multiplication</option>
              <option value="/">Division</option>
            </c:when>
            <c:when test="${operator == '*'}">
              <option value="*">Multiplication</option>
              <option value="+">Addition</option>
              <option value="-">Subtraction</option>
              <option value="/">Division</option>
            </c:when>
            <c:when test="${operator == '/'}">
              <option value="/">Division</option>
              <option value="+">Addition</option>
              <option value="-">Subtraction</option>
              <option value="*">Multiplication</option>
            </c:when>
            <c:otherwise>
              <option value="+">Addition</option>
              <option value="-">Subtraction</option>
              <option value="*">Multiplication</option>
              <option value="/">Division</option>
            </c:otherwise>
          </c:choose>
          </select>
        </td>
      </tr>
      <tr>
        <td>Second operand: </td>
        <td><input name="second-operand" type="text" value="${second}"/></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Calculate"/></td>
      </tr>
      <tr>
        <td>Result: </td>
        <td><input type="text" value="${result}" readonly></td>
      </tr>
      <tr>
        <td><h3>${alert}</h3></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>