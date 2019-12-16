<%--
  Created by IntelliJ IDEA.
  User: samca
  Date: 10/23/2019
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/bootstrap.bundle.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <title>Items</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
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
    </div>
</nav>


<form:form method="GET" action="search">
    Search <input type="search" name="searchTerm">
    <input type="submit" value="Search" class="add-button">
</form:form>

<c:forEach var="tempProduct" items="${products}">
    <div class="card d-inline-block my-5" style="width: 18rem;">
        <img src="resources/img/${tempProduct.imageFileName}" class="card-img-top" alt="...">
        <div class="card-body">
            <h5 class="card-title">${tempProduct.name}</h5>
            <c:url var="deleteLink" value="/items/delete">
                <c:param name="itemId" value="${tempProduct.productID}"/>
            </c:url>
            <c:url var="detailsLink" value="/items/details">
                <c:param name="item" value="${tempProduct.productID}"/>
            </c:url>
            <a href="${deleteLink}" class="btn btn-danger">Delete</a>
            <p class="card-text">${tempProduct.description}</p>

            <a href="${detailsLink}" class="btn btn-primary">View Details</a>
        </div>
    </div>
</c:forEach>

</body>
</html>
