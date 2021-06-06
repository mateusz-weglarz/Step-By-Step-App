<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Dashboard</h1>
<h2>Witaj ${user.firstName}, zrobiłeś już ${globalNumberOfSteps} kroków.</h2>
<a href="${pageContext.request.contextPath}/user/activities">Moje aktywności</a>
<a href="${pageContext.request.contextPath}/user/goals">Moje cele</a>
<a href="${pageContext.request.contextPath}/user/groups/list">Moje grupy</a>
<a href="${pageContext.request.contextPath}/user/friends">Znajomi</a>
<a href="${pageContext.request.contextPath}/user/account/show">Moje konto</a>
<sec:authorize access="hasRole('ADMIN')">
    <a href="${pageContext.request.contextPath}/admin/allUsers">Użytkownicy(tylko dla admina)</a>
</sec:authorize>
<a href="${pageContext.request.contextPath}/logout">Wyloguj</a>
