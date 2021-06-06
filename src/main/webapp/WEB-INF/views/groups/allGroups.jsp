<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Lista grup</title>
</head>
<body>
</body>
<h2>Lista grup</h2>
<table>
    <th>Nazwa grupy</th>
    <th>Opis grupy</th>
    <th>Utworzona</th>
    <tr>
        <c:forEach items="${groupList}" var="gl">
        <td>${gl.name}</td>
        <td>${gl.description}</td>
        <td>${gl.created}</td>
    </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/user/groups/list">Moje grupy</a>
<a href="${pageContext.request.contextPath}/user/dashboard">Strona główna</a>
</html>