<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edytuj aktywność</title>
</head>
<body>
<style>
    .errors {
        color: red;
    }
</style>
</body>
<form:form method="post" action="/activity/edit" modelAttribute="activityToEdit">
    <form:hidden path="created" value="${activityToEdit.created}"/>
    <form:hidden path="draft" value="false"/>
    <br><label for="name">Podaj imię:</label>
    <form:input path="name" type="text" id="name"/>
    <form:errors path="name" cssClass="errors"/>
    <br><button name="button" type="submit" value="save" >Zapisz edycję</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>