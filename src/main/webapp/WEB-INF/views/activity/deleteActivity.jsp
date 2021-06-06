<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuń aktywność</title>
</head>
<body>
<h2>Czy na pewno usunąć aktywność?</h2>

<table>
    <th>Nazwa aktywności</th>
    <th>Kiedy</th>
    <th>Wykonane kroki</th>
    <tr>
        <td>${activityToDelete.name}</td>
        <td>${activityToDelete.created}</td>
        <td>${activityToDelete.numberOfSteps}</td>
    </tr>
</table>
<form:form action="/activity/delete/${activityToDelete.id}" method="post">
    <button name="button" type="submit" value="delete">Usuń</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>

</body>
</html>
