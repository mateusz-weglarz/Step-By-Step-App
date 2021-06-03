<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Zakładanie nowego konta</title>
</head>
<body>
<style>
    .errors {
        color: red;
    }
</style>
</body>
<form:form method="post" action="/register" modelAttribute="user">
    <br><label for="firstName">Podaj imię:</label>
    <form:input path="firstName" type="text" id="firstName"/>
    <form:errors path="firstName" cssClass="errors"/>
    <br><label for="lastName">Podaj nazwisko:</label>
    <form:input path="lastName" type="text" id="lastName"/>
    <form:errors path="lastName" cssClass="errors"/>
    <br><label for="userName">Podaj nazwę użytkownika</label>
    <form:input path="userName" type="text" id="userName"/>
    <form:errors path="userName" cssClass="errors"/>
    <br><label for="email">Podaj email:</label>
    <form:input path="email" type="text" id="email"/>
    <form:errors path="email" cssClass="errors"/>
    <br><label for="password">Podaj hasło:</label>
    <form:input path="password" type="password" id="password"/>
    <form:errors path="password" cssClass="errors"/>
    <br><button name="button" type="submit" value="save" >Utwórz konto</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>