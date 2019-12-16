<%--
  Created by IntelliJ IDEA.
  User: samca
  Date: 10/6/2019
  Time: 7:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/bootstrap.bundle.js"></script>
    <script src="resources/js/bootstrap.js"></script>

    <title>Hello, world!</title>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark justify-content-between">
    <a class="navbar-brand" href="/">Electronic Shop</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link" href="/">Home</a>
            <li class="nav-item dropdown">
                <a class="dropdown-toggle nav-link active" href="/items" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Items</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/items/showAddProductForm">Add Item</a>
                    <a class="dropdown-item" href="/items">List</a>
                </div>
            </li>
            <a class="nav-item nav-link" href="/shoppingCart">Shopping Cart</a>
        </div>
        <form:form method="GET" action="search" class="form-inline my-2 my-lg-0 mr-0">
            <input class="form-control mr-sm-2" name="searchTerm" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit" value="search">Search</button>
        </form:form>
    </div>
</nav>

<!-- Jumbotron -->
<div class="mt-5 mx-auto jumbotron">
    <h3 class="text-center">Welcome to the electronics shop.</h3>
    <p class="lead text-center">Click on "Items" in the nav bar to see our items for sale.</p>
</div>


</body>

