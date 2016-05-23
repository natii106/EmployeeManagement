<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl_PL">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="<c:url value="/resources/styles/bootstrap.min.css" />" rel="stylesheet">
    <script type="text/javascript" src='<c:url value="/resources/js/bootstrap.js" />'></script>
    <script type="text/javascript" src='/resources/js/bootstrap.min.js'></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <title>Employee Management</title>
<body>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Employee Management</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Index</a></li>
            <li><a href="/dodaj">Dodaj</a></li>
            <li><a href="/szukaj">Szukaj</a></li>
            <li><a href="/list">Lista</a></li>
        </ul>
    </div>
</nav>

</body>
</html>
