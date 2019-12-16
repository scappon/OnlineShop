<%--
  Created by IntelliJ IDEA.
  User: samca
  Date: 12/4/2019
  Time: 3:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="resources/js/bootstrap.bundle.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <title>Add New Item</title>
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

<div class="container border border-primary mt-5">
        <form:form action="save" modelAttribute="aProduct" enctype="multipart/form-data">

            <table>
                <tr>
                    <td><label>Product Name</label></td>
                    <td><form:input path="name"></form:input>
                        <form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Description</label></td>
                    <td><form:textarea rows="4" cols="30" path="description"/>
                        <form:errors path="description" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label>Price</label></td>
                    <td><form:input path="price"/>
                        <form:errors path="price" cssClass="error"/></td>
                </tr>

                <tr>
                    <td><label>Image</label></td>
                    <td><input type="file" name="productImage"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Save" class="save"></td>
                </tr>
            </table>

        </form:form>
</div>

</body>
</html>
