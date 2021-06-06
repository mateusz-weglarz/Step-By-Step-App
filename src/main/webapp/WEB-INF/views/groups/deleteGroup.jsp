<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuń grupę</title>
</head>
<body>
</body>
<h2>Na pewno chcesz usunąć grupę:</h2>
<table>
    <th>Nazwa grupy</th>
    <th>Opis grupy</th>
    <th>Utworzona</th>
    <th>Ostatnia aktualizacja</th>
    <th>Cel</th>
    <th>Członkowie</th>
    <tr>
        <td>${groupToDelete.name}</td>
        <td>${groupToDelete.description}</td>
        <td>${groupToDelete.created}</td>
        <td>${groupToDelete.updated}</td>
        <td>${groupToDelete.goal}</td>
        <td><c:forEach items="${groupToDelete.members}" var="member">
            ${member.userName}
        </c:forEach> </td>
    </tr>
</table>
<form:form action="/user/groups/delete/${groupToDelete.id}" method="post">
    <button name="button" type="submit" value="delete">Usuń</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>