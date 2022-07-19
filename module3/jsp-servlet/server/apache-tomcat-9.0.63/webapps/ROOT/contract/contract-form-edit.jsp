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
                    <a class="nav-link text-white" href="contract">Back</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-auto" style="margin: 0 auto;">
    <div class="bg-pink text-white" style="margin: 0 auto !important; padding: 20px;">
        <form method="post">

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example1">Contract Start Date</label>
                <input type="date" id="form1Example1" class="form-control" name="contractStartDate" value="${contract.contractStartDate}"/>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example3">Contract End Date</label>
                <input type="date" id="form1Example3" class="form-control" name="contractEndDate" value="${contract.contractEndDate}"/>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example5">Contract Deposit</label>
                <input type="text" id="form1Example5" class="form-control" name="contractDeposit" value="${contract.contractDeposit}"/>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example6">Contract Total Money</label>
                <input type="text" id="form1Example6" class="form-control" name="contractTotalMoney" value="${contract.contractTotalMoney}"/>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example2">Employee</label>
                <select class="form-select" aria-label="Default select example" id="form1Example2" name="employeeId">
                    <c:forEach items="${listEmployee}" var="i">
                        <c:choose>
                            <c:when test="${i.employeeId == contract.employeeId}">
                                <option value="${i.employeeId}" selected>${i.employeeName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.employeeId}">${i.employeeName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example14">Customer</label>
                <select class="form-select" aria-label="Default select example" id="form1Example14" name="customerId">
                    <c:forEach items="${listCustomer}" var="i">
                        <c:choose>
                            <c:when test="${i.customerId == contract.customerId}">
                                <option value="${i.customerId}" selected>${i.customerName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.customerId}">${i.customerName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example15">Service</label>
                <select class="form-select" aria-label="Default select example" id="form1Example15" name="serviceId">
                    <c:forEach items="${listService}" var="i">
                        <c:choose>
                            <c:when test="${i.serviceId == contract.serviceId}">
                                <option value="${i.serviceId}" selected>${i.serviceName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.serviceId}">${i.serviceName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example16">Service</label>
                <select class="form-select" aria-label="Default select example" id="form1Example16" name="status">
                        <c:choose>
                            <c:when test="${contract.status == 1}">
                                <option value="1" selected class="text-danger">Deleted</option>
                                <option value="0" class="text-success">Active</option>
                            </c:when>
                            <c:when test="${contract.status == 0}">
                                <option value="1" class="text-danger">Deleted</option>
                                <option value="0" class="text-success" selected>Active</option>
                            </c:when>
                        </c:choose>
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
