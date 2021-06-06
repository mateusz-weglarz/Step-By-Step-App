<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista grup użytkownika</title>
</head>
<body>
</body>
<h1>założenie, dodanie, podanie, usunięcie, wypisanie się, wiadomość do grupy?,lista
    członków?</h1>
<h2>Lista grup użytkownika</h2>
<table>
    <th>Nazwa grupy</th>
    <th>Opis grupy</th>
    <th>Utworzona</th>
    <tr>
        <c:forEach items="${groupList}" var="gl">
        <td>${gl.name}</td>
        <td>${gl.description}</td>
        <td>${gl.created}</td>
        <td><a href="${pageContext.request.contextPath}/user/groups/details/${gl.id}">Szczegóły grupy</a></td>
    </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/user/groups/all">Pokaż wszystkie grupy</a>
<a href="${pageContext.request.contextPath}/user/groups/add-group">Dodaj grupę</a>
<a href="${pageContext.request.contextPath}/user/groups/find">Szukaj grupy</a>
<a href="${pageContext.request.contextPath}/user/dashboard">Powrót</a>
</html>