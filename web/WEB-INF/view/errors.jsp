<%--
  Created by IntelliJ IDEA.
  User: samca
  Date: 12/15/2019
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.css">

    <title>Errors</title>
</head>
<body>
    <h2>An error has occurred</h2>
    <div class="container">
        <p>${errorMessage}</p>
    </div>
</body>
</html>
