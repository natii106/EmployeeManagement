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
    <title>Lista pracowników </title>
</head>
<body>

<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Stanowisko</th>
            <th>Pensja</th>
            <th>Zarobki na godzinę</th>
            <th>Ilość godzin w miesiącu</th>
            <th>Nadgodziny</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="employee" items="${getList}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.surname}</td>
            <td>${employee.position}</td>
            <td>${employee.salary}</td>
            <td>${employee.salaryPerHour}</td>
            <td>${employee.numberOfHoursPerMonth}</td>
            <td>${employee.overtime}</td>
        </tr>
        </c:forEach>
    </table>

</div>



</body>
</html>
