<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/4/2022
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="style/bootstrap/normalize.css">
  <link rel="stylesheet" href="style/bootstrap/bootstrap.min.css">
  <link rel="stylesheet" href="style/datatables/css/dataTables.bootstrap4.min.css"/>
  <style>
    .bg-pink {
      background-color: deeppink !important;
    }
    .button {
      background-color: deeppink !important;
    }
    .nav-item:hover {
      border: 3px solid deeppink;
    }
  </style>
</head>
<body>
<div class="p-3 bg-pink text-white text-center">
  <h1>FURAMA RESORT</h1>
  <p>Welcome to <strong>Furama Resort!</strong></p>
</div>
<nav class="navbar navbar-expand-sm navbar-dark bg-warning">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
      <img src="img/instagram.png" alt="Logo" style="width:40px;" class="rounded-pill">
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="mynavbar">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">
          <a class="nav-link text-light active" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="employee">Employee</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="customer">Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="service">Service</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="contract">Contract</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="contract-detail">Contract Detail</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary button" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>
<div class="container-fluid text-center">
  <div class="row content" style="padding: 20px">
    <div class="col-sm-2 sidenav">
      <!-- Offcanvas Sidebar -->
      <div class="offcanvas offcanvas-start" id="demo1">
        <div class="offcanvas-header">
          <h1 class="offcanvas-title">Hello</h1>
          <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
        </div>
        <div class="offcanvas-body">
            <img src="img/hermione-granger.png" class="img-thumbnail" alt="Cinque Terre">
        </div>

      </div>

      <!-- Button to open the offcanvas sidebar -->
      <button class="btn btn-primary button" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo1">
        Open Offcanvas Sidebar
      </button>
    </div>

    <div class="col-sm-8 text-left">
      <!-- Carousel -->
      <div id="demo" class="carousel slide" data-bs-ride="carousel">

        <!-- Indicators/dots -->
        <div class="carousel-indicators">
          <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
          <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
          <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
        </div>

        <!-- The slideshow/carousel -->
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="img/hermione-granger.png" alt="Los Angeles" class="d-block w-100">
          </div>
          <div class="carousel-item">
            <img src="img/hermione-granger.png" alt="Chicago" class="d-block w-100">
          </div>
          <div class="carousel-item">
            <img src="img/hermione-granger.png" alt="New York" class="d-block w-100">
          </div>
        </div>

        <!-- Left and right controls/icons -->
        <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
          <span class="carousel-control-prev-icon"></span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
          <span class="carousel-control-next-icon"></span>
        </button>
      </div>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well p-3">
        <img src="img/hermione-granger.png" class="img-thumbnail" alt="Cinque Terre">
      </div>
      <div class="well p-3">
        <img src="img/hermione-granger.png" class="img-thumbnail" alt="Cinque Terre">
      </div>
      <div class="well p-3">
        <img src="img/hermione-granger.png" class="img-thumbnail" alt="Cinque Terre">
      </div>
      <div class="well p-3">
        <img src="img/hermione-granger.png" class="img-thumbnail" alt="Cinque Terre">
      </div>
    </div>
  </div>
</div>
<footer class="container-fluid text-center bg-pink p-2 text-light">
  <p class="text-light">Furama Resort - &copy; Copyright by Phuong 2022</p>
</footer>
</body>
</html>
<script src="style/jquery/jquery-3.5.1.min.js"></script>
<script src="style/datatables/js/jquery.dataTables.min.js"></script>
<script src="style/datatables/js/dataTables.bootstrap4.min.js"></script>
<script src="style/bootstrap/bootstrap.bundle.min.js"></script>