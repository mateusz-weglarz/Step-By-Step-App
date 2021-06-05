<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edytuj konto</title>
</head>
<body>
<style>
    .errors {
        color: red;
    }
</style>
</body>
<form:form method="post" action="/user/account/edit-account" modelAttribute="user">
    <form:hidden path="id" value="${user.id}"/>
    <br><label for="firstName">Podaj imię:</label>
    <form:input path="firstName" type="text" id="firstName"/>
    <form:errors path="firstName" cssClass="errors"/>
    <br><label for="lastName">Podaj nazwisko:</label>
    <form:input path="lastName" type="text" id="lastName"/>
    <form:errors path="lastName" cssClass="errors"/>
    <br><label for="userName">Podaj nazwę użytkownika:</label>
    <form:input path="userName" type="text" id="userName"/>
    <form:errors path="userName" cssClass="errors"/>
    <br><label for="email">Podaj adres email:</label>
    <form:input path="email" type="text" id="email"/>
    <form:errors path="email" cssClass="errors"/>
    <br><button name="button" type="submit" value="save" >Zapisz edycję</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>