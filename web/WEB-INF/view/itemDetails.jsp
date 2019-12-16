<%--
  Created by IntelliJ IDEA.
  User: samca
  Date: 10/23/2019
  Time: 8:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <title>Item Details</title>
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
            <a class="nav-item nav-link" href="/items">Items</a>
            <a class="nav-item nav-link" href="/shoppingCart">Shopping Cart</a>
        </div>
    </div>
</nav>

<h2 class="mt-5 text-center">${product.name}</h2>
<img class="float-left w-50 mb-3 mx-5" src="${pageContext.request.contextPath}/resources/img/${product.imageFileName}"/>
<ul class="my-4 mr-5">
    <li>${product.description}</li>
    <li>Price: $${product.price}</li>
    <button class="btn btn-primary mt-3">Add To Cart</button>
</ul>


</body>
</html>
