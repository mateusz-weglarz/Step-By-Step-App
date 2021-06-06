<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edytuj grupę</title>
</head>
<body>
<style>
    .errors {
        color: red;
    }
</style>
</body>
<h2>Edytuj grupę</h2>
<form:form method="post" action="/user/groups/edit" modelAttribute="group">
    <form:hidden path="id" value="${group.id}"/>
    <form:hidden path="groupAdminId" value="${group.groupAdminId}"/>
    <br><label for="name">Zmień nazwę grupy</label>
    <form:input path="name" type="text" id="name"/>
    <form:errors path="name" cssClass="errors"/>
    <br><label for="description">Zmień opis grupy</label>
    <form:input path="description" type="text" id="description"/>
    <form:errors path="description" cssClass="errors"/>
    <br><label for="goal">Wyznacz nowy cel do osiągnięcia</label>
    <form:input path="goal" type="text" id="goal"/>
    <form:errors path="goal" cssClass="errors"/>
    <br>
    <button name="button" type="submit" value="save">Zapisz edycję</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>