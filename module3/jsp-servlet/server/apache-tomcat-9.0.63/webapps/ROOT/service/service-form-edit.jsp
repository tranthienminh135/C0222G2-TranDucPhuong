<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2022
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="../style/bootstrap/normalize.css">
  <link rel="stylesheet" href="../style/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="../style/datatables/css/dataTables.bootstrap4.min.css"/>
  <style>
    .bg-pink {
      background-color: deeppink !important;
    }

    .nav-item:hover {
      border: 3px solid deeppink;
    }
  </style>
</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-warning p-2">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="../img/instagram.png" alt="Logo" style="width:40px;" class="rounded-pill">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link text-white active" href="../index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-white" href="customer">Back</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="col-auto" style="margin: 0 auto;">
  <div class="bg-pink text-white" style="margin: 0 auto !important; padding: 20px;">

    <form method="post">

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example3">Service Name</label>
        <input value="${serviceName}" type="text" id="form1Example3" class="form-control" name="serviceName"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example4">Service Area</label>
        <input value="${serviceArea}" type="text" id="form1Example4" class="form-control" name="serviceArea"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example5">Service Cost</label>
        <input value="${serviceCost}" type="text" id="form1Example5" class="form-control" name="serviceCost"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example6">Service Max People</label>
        <input value="${serviceMaxPeople}" type="text" id="form1Example6" class="form-control" name="serviceMaxPeople"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example7">Rent Type</label>
        <select class="form-select" aria-label="Default select example" id="form1Example7" name="rentTypeId">
          <c:forEach items="${rentTypes}" var="i">
            <c:choose>
              <c:when test="${i.rentTypeId == rentTypeId}">
                <option value="${i.rentTypeId}" selected>${i.rentTypeName}</option>
              </c:when>
              <c:otherwise>
                <option value="${i.rentTypeId}">${i.rentTypeName}</option>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example8">Rent Type</label>
        <select class="form-select" aria-label="Default select example" id="form1Example8" name="serviceTypeId">
          <c:forEach items="${serviceTypes}" var="i">
            <c:choose>
              <c:when test="${i.serviceTypeId == serviceTypeId}">
                <option value="${i.serviceTypeId}" selected>${i.serviceTypeName}</option>
              </c:when>
              <c:otherwise>
                <option value="${i.serviceTypeId}">${i.serviceTypeName}</option>
              </c:otherwise>
            </c:choose>
          </c:forEach>
        </select>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example9">Standard Room</label>
        <input value="${standardRoom}" type="text" id="form1Example9" class="form-control" name="standardRoom"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example10">Description</label>
        <input value="${descriptionOtherConvenience}" type="text" id="form1Example10" class="form-control" name="descriptionOtherConvenience"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example11">Pool Area</label>
        <input value="${poolArea}" type="text" id="form1Example11" class="form-control" name="poolArea"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example12">Number Of Floors</label>
        <input value="${numberOfFloors}" type="text" id="form1Example12" class="form-control" name="numberOfFloors"/>
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form1Example13">Status</label>
        <select class="form-select" aria-label="Default select example" id="form1Example13" name="status">
          <c:if test="${status == 0}">
            <option value="0" class="text-success" selected>Active</option>
            <option value="1" class="text-danger" >Deleted</option>
          </c:if>
          <c:if test="${status == 1}">
            <option value="0" class="text-success" >Active</option>
            <option value="1" class="text-danger" selected>Deleted</option>
          </c:if>
        </select>
      </div>

      <button type="submit" class="btn btn-warning btn-block">Submit</button>

    </form>

  </div>
</div>
<footer class="container-fluid text-center bg-warning p-2 text-light">
  <p class="text-light">Furama Resort - &copy; Copyright by Phuong 2022</p>
</footer>
</body>
<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>
</html>
