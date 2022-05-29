<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2022
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="display-discount" method="post">
    <input type="text" name="pd" placeholder="Product Description">
    <input type="text" name="lp" placeholder="List Price">
    <input type="text" name="dp" placeholder="Discount Percent">
    <button type="submit">Submit</button>
  </form>
  <h1>Product Description: ${pd}</h1>
  <h1>List Price: ${lp}</h1>
  <h1>Discount Percent: ${dp}</h1>
  <h1>Discount Amount: ${da}</h1>
  </body>
</html>
