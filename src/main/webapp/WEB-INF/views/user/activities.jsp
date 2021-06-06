<h1>edycja(dodanie zdjęcia)</h1>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista aktywności</title>
</head>
<body>
</body>
<h2>Lista aktywności</h2>
<table>
    <th>Nazwa aktywności</th>
    <th>Wykonane kroki</th>
    <tr>
        <c:forEach items="${userActivities}" var="ua">
        <td>${ua.name}</td>
        <td>${ua.numberOfSteps}</td>
        <td><a href="${pageContext.request.contextPath}/activity/show/${ua.id}">Pokaż szczegóły</a></td>
        <td><a href="${pageContext.request.contextPath}/activity/edit/${ua.id}">Edytuj aktywność</a></td>
        <td><a href="${pageContext.request.contextPath}/activity/delete/${ua.id}">Usuń aktywność</a></td>
    </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/user/dashboard">Powrót</a>
</html>