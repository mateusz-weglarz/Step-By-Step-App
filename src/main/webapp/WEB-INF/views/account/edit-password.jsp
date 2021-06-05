<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Zmień hasło</title>
</head>
<body>
<style>
    .errors {
        color: red;
    }
</style>
</body>
<h1>Zmień hasło</h1>
<form:form method="post" action="/user/account/edit-password" modelAttribute="user">
    <form:hidden path="id" value="${user.id}"/>
    <br><label for="password">Podaj hasło:</label>
    <form:input path="password" type="password" value="password" id="password"/>
    <form:errors path="password" cssClass="errors"/>
    <br><button name="button" type="submit" value="save" >Zmień hasło</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>