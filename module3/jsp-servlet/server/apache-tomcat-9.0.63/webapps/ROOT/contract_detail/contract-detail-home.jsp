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
                    <a class="nav-link text-white" href="contract-detail">Show Contract Detail Is Active</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="contract-detail?action=getAll">Show All Contract Detail</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-white" href="contract-detail?action=create">Add New Contract Detail</a>
                </li>
            </ul>
            <form class="d-flex" method="get" action="contract-detail">
                <input type="text" value="search" name="action" hidden>
                <input class="form-control me-2" type="text" placeholder="Search" name="contractDetailSearchValue"
                       value="${contractDetailSearchValue}">
                <button class="btn btn-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid" style="padding: 50px">
    <h2>Contract Management</h2>
    <div class="table-scrollable col-12 border-dark">
        <table id="tableCustomer" class="table table-light table-hover table-warning">
            <thead>
            <tr class="table-danger">
                <th class="table-warning">ID</th>
                <th class="table-warning">Contract ID</th>
                <th class="table-warning">Attach Service</th>
                <th class="table-warning">Quantity</th>
                <th class="table-warning">Status</th>
                <th class="table-warning">Delete</th>
                <th class="table-warning">Edit</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listContractDetail}" var="i">
                <tr>
                    <td class="table-warning">${i.contractDetailId}</td>
                    <td class="table-warning">${i.contractId}</td>

                    <c:forEach items="${listAttachService}" var="o">
                        <c:if test="${o.attachServiceId == i.attachServiceId}">
                            <td class="table-warning">${o.attachServiceName}</td>
                        </c:if>
                    </c:forEach>

                    <td class="table-warning">${i.quantity}</td>

                    <c:if test="${i.status == 0}">
                        <td class="table-warning text-success">Active</td>
                        <td class="table-warning">
                            <a href="#" class="text-danger text-decoration-none fw-bold hover-zoom"
                               data-bs-toggle="modal" data-bs-target="#staticBackdrop${i.contractDetailId}">
                                Delete
                            </a>
                        </td>
                    </c:if>
                    <c:if test="${i.status == 1}">
                        <td class="table-warning text-danger">Deleted</td>
                        <td class="table-warning">
                            <span class="text-secondary text-decoration-line-through fw-bold hover-zoom disabled">
                                Delete
                            </span>
                        </td>
                    </c:if>

                    <!-- Modal -->
                    <div class="modal fade" id="staticBackdrop${i.contractDetailId}" data-bs-backdrop="static"
                         data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title text-danger" id="staticBackdropLabel">Warning!</h5>
                                </div>
                                <div class="modal-body">
                                    <h5>Do you want delete contract detail with id = <strong class="text-warning">${i.contractDetailId}</strong> ?
                                    </h5>
                                </div>
                                <div class="modal-footer">
                                    <a href="contract-detail?action=delete&idDelete=${i.contractDetailId}"
                                       class="btn btn-pink text-white">Accept</a>
                                    <button type="button" class="btn btn-secondary text-white" data-bs-dismiss="modal"
                                            style="background-color: grey !important;">Close
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <td class="table-warning"><a href="contract-detail?action=edit&idEdit=${i.contractDetailId}" class="text-warning text-decoration-none fw-bold hover-zoom">Edit</a>
                    </td>
                </tr>
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
