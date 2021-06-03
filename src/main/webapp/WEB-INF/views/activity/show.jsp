<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aktywność</title>
</head>
<body>
</body>
<h2>Aktywność</h2>
<table>
    <th>Nazwa aktywności</th>
    <th>Data wykonania</th>
    <th>Wykonane kroki</th>
    <tr>
        <c:forEach items="${activityToShow}" var="ats">
        <td>${ats.name}</td>
        <td>${ats.created}</td>
        <td>${ats.numberOfSteps}</td>
        <td><a href="${pageContext.request.contextPath}/activity/edit/${ats.id}">Edytuj aktywność</a></td>
        <td><a href="${pageContext.request.contextPath}/activity/delete/${ats.id}">Usuń aktywność</a></td>
    </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/user/activities">Powrót do listy aktywności</a>
</html>