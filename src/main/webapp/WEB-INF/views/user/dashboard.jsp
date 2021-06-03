<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h1>Dashboard</h1>
<a href="${pageContext.request.contextPath}/user/activities">Moje aktywności</a>
<a href="${pageContext.request.contextPath}/user/goals">Moje cele</a>
<a href="${pageContext.request.contextPath}/user/groups">Moje grupy</a>
<a href="${pageContext.request.contextPath}/user/friends">Znajomi</a>
<a href="${pageContext.request.contextPath}/user/account">Moje konto</a>
<a href="${pageContext.request.contextPath}/admin/allUsers">Użytkownicy(tylko dla admina)</a>
