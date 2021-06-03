<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Logowanie</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css" rel="stylesheet" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form class="form-signin" method="post" action="login">
        <h2 class="form-signin-heading">Logowanie użytkownika</h2>
        <p>
            <label for="username" class="sr-only">Nazwa użytkownika</label>
            <input type="text" id="username" name="username" class="form-control" placeholder="Nazwa użytkownika"
                   required="" autofocus="">
        </p>
        <p>
            <label for="password" class="sr-only">Hasło</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Hasło" required="">
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj się</button>

    </form>
    <p>Aby zalogować się na testowego użytkownika użyj-> username: testuser, haslo: haslotest</p>
    <p>Aby zalogować się na testowego admina użyj-> username: admin, haslo: haslo123</p>
</div>
</body>
</html>