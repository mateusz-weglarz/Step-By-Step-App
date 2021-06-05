<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuń konto</title>
</head>
<body>
<h2>Czy na pewno usunąć konto?</h2>

<table>
    <th>Konto użytkownika</th>
    <th>Założono</th>
    <tr>
        <td>${userToDelete.userName}</td>
        <td>${userToDelete.created}</td>
    </tr>
</table>
<form:form action="/user/account/confirm-delete" method="get">
    <button name="button" type="submit" value="delete">Usuń</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>

</body>
</html>