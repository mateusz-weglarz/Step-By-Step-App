<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Usuń konto</title>
</head>
<body>
<h2>Czy na pewno usunąć konto?</h2>

<h3>Usunięcie konta jest nieodwracalne i wiąże się z utratą wszelkich zapisanych danych.</h3>
<form:form action="/user/account/delete" method="post">
    <button name="button" type="submit" value="delete">Usuń</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</body>
</html>