<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Formularz dodawania </title>
</head>
<body>

<form:form method="POST" modelAttribute="employeeDTO" class="form">
    <div class="form-group">
        <label>Imię</label>
        <form:input type="text" class="form-control" path="name"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="name" /></c:if>
    </div>
    <div class="form-group">
        <label>Nazwisko</label>
        <form:input type="text" class="form-control" path="surname"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="surname" /></c:if>
    </div>
    <div class="form-group">
        <label>Stanowisko</label>
        <form:input type="text" class="form-control" path="position"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="position" /></c:if>
    </div>
    <div class="form-group">
        <label>Pensja</label>
        <form:input type="text" class="form-control" path="salary"/><c:if test="${pageContext.request.method=='POST'}"><form:errors path="salary" /></c:if>
    </div>
    <div class="form-group">
        <label>Zarobki na godzinę</label>
        <form:input type="text" class="form-control" path="salaryPerHour"/>
    </div>
    <div class="form-group">
        <label>Liczba godzin w miesiącu</label>
        <form:input type="text" class="form-control" path="numberOfHoursPerMonth"/>
    </div>
    <div class="form-group">
        <label>Nadgodziny</label>
        <form:input type="text" class="form-control" path="overtime"/>
    </div>

    <button type="submit" class="btn btn-default">Dodaj</button>
</form:form>

</body>
</html>