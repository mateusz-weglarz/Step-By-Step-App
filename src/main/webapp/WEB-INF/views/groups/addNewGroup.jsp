<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tworze nowej grupy</title>
</head>
<body>
<style>
    .errors {
        color: red;
    }
</style>
</body>
<h2>Utwórz grupę:</h2>
<form:form method="post" action="/user/groups/add-group" modelAttribute="group">
    <br><label for="name">Podaj nazwę grupy</label>
    <form:input path="name" type="text" id="name"/>
    <form:errors path="name" cssClass="errors"/>
    <br><label for="description">Podaj opis grupy</label>
    <form:input path="description" type="text" id="description"/>
    <form:errors path="description" cssClass="errors"/>
    <br><label for="goal">Wyznacz cel do osiągnięcia</label>
    <form:input path="goal" type="text" id="goal"/>
    <form:errors path="goal" cssClass="errors"/>
    <br><button name="button" type="submit" value="save" >Utwórz grupę</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>