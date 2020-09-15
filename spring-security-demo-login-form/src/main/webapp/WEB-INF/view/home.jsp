<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title> Demo page </title>
</head>
<body>
<h2> Some thing is displayed</h2>

<form:form action="${pageContext.request.contextPath}/logout" method="POST">
<input type="submit" value = "logout"/>

</form:form>
</body>
</html>