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
                    <a class="nav-link text-white" href="employee">Back</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="col-auto" style="margin: 0 auto;">
    <div class="bg-pink text-white" style="margin: 0 auto !important; padding: 20px;">
        <form method="post">

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example1">Employee Name</label>
                <input type="text" id="form1Example1" class="form-control" name="employeeName" value="${employeeName}"/>
                <div class="text-black text-center bg-warning">${errMap.errEmployeeName}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example3">Employee Birthday</label>
                <input type="date" id="form1Example3" class="form-control" name="employeeBirthday" value="${employeeBirthday}"/>
                <div class="text-black text-center bg-warning">${errMap.errEmployeeBirthday}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example5">Employee ID Card</label>
                <input type="text" id="form1Example5" class="form-control" name="employeeIdCard" value="${employeeIdCard}"/>
                <div class="text-black text-center bg-warning">${errMap.errEmployeeIdCard}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example14">Employee Salary</label>
                <input type="text" id="form1Example14" class="form-control" name="employeeSalary" value="${employeeSalary}"/>
                <div class="text-black text-center bg-warning">${errMap.errEmployeeSalary}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example6">Employee Phone</label>
                <input type="number" id="form1Example6" class="form-control" name="employeePhone" value="${employeePhone}"/>
                <div class="text-black text-center bg-warning">${errMap.errEmployeePhone}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example7">Employee Email</label>
                <input type="email" id="form1Example7" class="form-control" name="employeeEmail" value="${employeeEmail}"/>
                <div class="text-black text-center bg-warning">${errMap.errEmployeeEmail}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example9">Employee Address</label>
                <input type="text" id="form1Example9" class="form-control" name="employeeAddress" value="${employeeAddress}"/>
                <div class="text-black text-center bg-warning">${errMap.errEmployeeAddress}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example10">Employee Position</label>
                <select class="form-select" aria-label="Default select example" id="form1Example10" name="positionId">
                    <c:forEach items="${listPosition}" var="i">
                        <c:choose>
                            <c:when test="${i.positionId == positionId1}">
                                <option value="${i.positionId}" selected>${i.positionName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.positionId}" >${i.positionName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errEmployeePosition}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example11">Employee Education Degree</label>
                <select class="form-select" aria-label="Default select example" id="form1Example11" name="educationDegreeId">
                    <c:forEach items="${listED}" var="i">
                        <c:choose>
                            <c:when test="${i.educationDegreeId == educationDegreeId1}">
                                <option value="${i.educationDegreeId}" selected>${i.educationDegreeName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.educationDegreeId}" >${i.educationDegreeName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errEducationDegreeId}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example12">Employee Division</label>
                <select class="form-select" aria-label="Default select example" id="form1Example12" name="divisionId">
                    <c:forEach items="${listDivision}" var="i">
                        <c:choose>
                            <c:when test="${i.divisionId == divisionId1}">
                                <option value="${i.divisionId}" selected>${i.divisionName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.divisionId}" >${i.divisionName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errDivisionId}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example15">Employee Username</label>
                <select class="form-select" aria-label="Default select example" id="form1Example15" name="username">
                    <c:forEach items="${listUser}" var="i">
                        <c:choose>
                            <c:when test="${i.username == username1}">
                                <option value="${i.username}" selected>${i.username}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${i.username}" >${i.username}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errUserName}</div>
            </div>

            <div class="form-outline mb-4">
                <label class="form-label" for="form1Example16">Status</label>
                <select class="form-select" aria-label="Default select example" id="form1Example16" name="status">
                        <c:choose>
                            <c:when test="${status == 0}">
                                <option value="0" class="text-success" selected>Active</option>
                                <option value="1" class="text-danger" >Delete</option>
                            </c:when>
                            <c:otherwise>
                                <option value="0" class="text-success" >Active</option>
                                <option value="1" class="text-danger" selected>Delete</option>
                            </c:otherwise>
                        </c:choose>
                </select>
                <div class="text-black text-center bg-warning">${errMap.errStatus}</div>

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
