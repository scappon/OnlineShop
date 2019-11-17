<%--
  Created by IntelliJ IDEA.
  User: samca
  Date: 10/23/2019
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
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
    <title>Shopping Cart</title>
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
            <a class="nav-item nav-link active" href="/shoppingCart">Shopping Cart</a>
        </div>
    </div>
</nav>
<div class="my-5 border border-primary w-25 p-4" style="margin-left: auto; margin-right: auto;">
    <h6>Items in shopping cart: </h6>
    <p class="text-warning">There are no items currently in your shopping cart</p>
    <span>Total $0.00</span><br><br>
    <button class="btn btn-primary">Checkout</button>
</div>
</body>
</html>
