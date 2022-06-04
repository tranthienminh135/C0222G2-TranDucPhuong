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
      background-color: deeppink;
    }
    button {
      background-color: deeppink !important;
    }
    .nav-item:hover {
      border: 1px solid deeppink;
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
          <a class="nav-link text-light" href="">Employee</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="customer">Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="">Service</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="">Contract</a>
        </li>
      </ul>
      <form class="d-flex">
        <input class="form-control me-2" type="text" placeholder="Search">
        <button class="btn btn-primary" type="button">Search</button>
      </form>
    </div>
  </div>
</nav>
<div class="container-fluid text-center">
  <div class="row content" style="padding: 20px">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-8 text-left">
      <h1>Welcome</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <hr>
      <h3>Test</h3>
      <p>Lorem ipsum...</p>
      <h1>Welcome</h1>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
      <hr>
      <h3>Test</h3>
      <p>Lorem ipsum...</p>
    </div>
    <div class="col-sm-2 sidenav">
      <div class="well p-3">
        <p>ADS</p>
      </div>
      <div class="well p-3">
        <p>ADS</p>
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