<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Moje konto</title>
</head>
<body>
</body>
<h2>Szczegóły konta</h2>
<table>
    <th>Imię</th>
    <th>Nazwisko</th>
    <th>Nazwa użytkownika</th>
    <th>Adres email</th>
    <th>Liczba wszystkich kroków</th>
    <th>Konto założone</th>
    <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.userName}</td>
        <td>${user.email}</td>
        <td>${user.globalNumberOfSteps}</td>
        <td>${user.created}</td>
        <td><a href="${pageContext.request.contextPath}/user/account/edit-account">Edytuj konto</a></td>
        <td><a href="${pageContext.request.contextPath}/user/account/edit-password">Zmień hasło</a></td>
        <td><a href="${pageContext.request.contextPath}/user/account/delete">Usuń konto</a></td>
    </tr>
</table>
<a href="${pageContext.request.contextPath}/user/dashboard">Powrót</a>