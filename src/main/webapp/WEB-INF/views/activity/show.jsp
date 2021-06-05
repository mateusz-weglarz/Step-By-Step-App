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
    <th>Data ostatniej aktualizacji</th>
    <th>Wykonane kroki</th>
    <th>Użytkownik</th>
    <tr>
        <td>${activityToShow.name}</td>
        <td>${activityToShow.created}</td>
        <td>${activityToShow.updated}</td>
        <td>${activityToShow.numberOfSteps}</td>
        <td>${activityToShow.user.userName}</td>
        <td><a href="${pageContext.request.contextPath}/activity/edit/${activityToShow.id}">Edytuj aktywność</a></td>
        <td><a href="${pageContext.request.contextPath}/activity/delete/${activityToShow.id}">Usuń aktywność</a></td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/user/activities">Powrót do listy aktywności</a>
</html>