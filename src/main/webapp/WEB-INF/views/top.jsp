<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Zakładanie nowego konta</title>
</head>
<body>
</body>
<h2>Nasi najlepsi:</h2>
<table>
    <th>Nazwa użytkownika</th>
    <th>Wykonane kroki</th>
    <tr>
        <c:forEach items="${topUserList}" var="t">
        <td>${t.userName}</td>
        <td>${t.globalNumberOfSteps}</td>
    </tr>
    </c:forEach>
</table>
</html>