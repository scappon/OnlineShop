<%--
  Created by IntelliJ IDEA.
  User: samca
  Date: 10/23/2019
  Time: 8:21 PM
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
            <a class="nav-item nav-link active" href="/items">Items</a>
            <a class="nav-item nav-link" href="/shoppingCart">Shopping Cart</a>
        </div>
    </div>
</nav>

<div class="card d-inline-block mx-5 my-5" style="width: 18rem;">
    <img src="resources/img/samsung55.jpg" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">Samsung UN55NU8000FXZA Flat 55" 4K UHD 8 Series Smart LED TV (2018)</h5>
        <p class="card-text">Loaded with features, the NU8000 has advanced smart browsing with voice  control, which finds your shows easily.</p>
        <a href="/itemDetails" class="btn btn-primary">View Details</a>
    </div>
</div>

<div class="card d-inline-block my-5" style="width: 18rem;">
    <img src="resources/img/lenovo330s.jpg" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">Lenovo - 330S-15ARR 15.6" Laptop - AMD Ryzen 5 - 8GB Memory - 128GB Solid State Drive</h5>
        <p class="card-text">Meet the IdeaPad 330S. Thinner & lighter with narrow bezels for broader viewing.</p>
        <a href="#" class="btn btn-primary">View Details</a>
    </div>
</div>
</body>
</html>
