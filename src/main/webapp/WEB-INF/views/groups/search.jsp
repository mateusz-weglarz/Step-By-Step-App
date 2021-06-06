<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Szukaj grupy</title>
</head>
<body>
<style>
    .errors {
        color: red;
    }
</style>
</body>
<h2>Wyszukaj grupę:</h2>
<form:form method="get" action="/user/groups/search-result" modelAttribute="group">
    <br><label for="name">Podaj nazwę grupy</label>
    <form:input path="name" type="text" id="name"/>
    <br><button name="button" type="submit" value="search" >Szukaj</button>
    <button name="button" type="submit" value="cancel">Anuluj</button>
</form:form>
</html>