<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title> My Login page </title>
</head>
<body>
<h2> Enter the credentials</h2>
<form:form action="${pageContext.request.contextPath}/authenticateTheUser">

<c:if test="${param.logout != null }">
<i> You have been logged out</i>
</c:if>
<c:if test="${param.error != null }">
<i> Sorry! You entered invalid username/password.</i>
</c:if>

<p>
User name: <input type="text" name="username"/>
</p>
<p>
Password: <input type="password" name="password"/>
</p>

<input type="submit" value = "Login"/>
</form:form>
</body>
</html>