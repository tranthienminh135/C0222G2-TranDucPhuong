<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2022
  Time: 2:35 PM
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
        .table-scrollable {
            overflow: auto;
        }

        th, td {
            text-align: center !important;
        }

        button {
            background-color: deeppink !important;
        }

        .btn-pink {
            background-color: deeppink !important;
        }

        .nav-item:hover {
            border: 3px solid deeppink;
        }

        .bg-pink {
            background-color: deeppink !important;
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
                    <a class="nav-link text-white" href="customer">Show Customer Is Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="customer?action=getAll">Show All Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="customer?action=create">Add new customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="customer?action=showCustomerUsingService">Show list customers
                        using service</a>
                </li>
            </ul>
            <form class="d-flex" method="get" action="customer">
                <input type="text" value="search" name="action" hidden>
                <input class="form-control me-2" type="text" placeholder="Search" name="customerSearchValue"
                       value="${customerSearchValue}">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding: 50px">
    <h2>Customer Management</h2>
    <div class="table-scrollable col-12 border-dark">
        <table id="tableCustomer" class="table table-light table-hover table-warning">
            <thead>
            <tr class="table-danger">
                <th class="table-warning">Id</th>
                <th class="table-warning">Name</th>
                <th class="table-warning">Phone</th>
                <th class="table-warning">Attach Service Name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listCustomerUsingService}" var="i">
            <tr>
                <td class="table-warning">${i.customerId}</td>
                <td class="table-warning">${i.customerName}</td>
                <td class="table-warning">${i.customerPhone}</td>
                <td class="table-warning">${i.attachServiceName}</td>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<footer class="container-fluid text-center bg-pink p-2 text-light">
    <p class="text-light">Furama Resort - &copy; Copyright by Phuong 2022</p>
</footer>
</body>
<script src="../style/jquery/jquery-3.5.1.min.js"></script>
<script src="../style/datatables/js/jquery.dataTables.min.js"></script>
<script src="../style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="../style/bootstrap/bootstrap.bundle.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        });
    });
</script>
</html>
