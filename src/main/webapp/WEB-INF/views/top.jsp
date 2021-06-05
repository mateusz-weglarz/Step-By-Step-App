<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Nasi najlepsi</title>
</head>
<body>
</body>
<h2>Top użytkownicy:</h2>
<table>
    <th>Nazwa użytkownika</th>
    <th>Wykonane kroki</th>
    <tr>
        <c:forEach items="${topUserList}" var="tu">
        <td>${tu.userName}</td>
        <td>${tu.globalNumberOfSteps}</td>
    </tr>
    </c:forEach>
</table>
<h2>Top aktywności:</h2>
<table>
    <th>Nazwa aktywności</th>
    <th>Wykonane kroki</th>
    <th>Data wykonania</th>
    <tr>
        <c:forEach items="${topActivityList}" var="ta">
        <td>${ta.name}</td>
        <td>${ta.numberOfSteps}</td>
        <td>${ta.created}</td>
    </tr>
    </c:forEach>
</table>
</html>