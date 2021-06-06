<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Grupa ogólnie</title>
</head>
<body>
</body>
<h2>Grupa:</h2>
<table>
    <th>Nazwa grupy</th>
    <th>Opis grupy</th>
    <th>Utworzona</th>
    <tr>
        <td>${group.name}</td>
        <td>${group.description}</td>
        <td>${group.created}</td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/user/groups/all">Pokaż wszystkie grupy</a>
<a href="${pageContext.request.contextPath}/user/groups/list">Powrót do moich grup</a>
</html>