
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
 <title> List Customers</title>
 <link type="text/css" rel = "stylesheet"
 href ="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>


<div id = "wrapper">
	<div id = "header">
		<h2> Customer relationship Manager</h2>
	</div>

	<div id = "container">
	
		<div id = "content">
			<input type="button" value = "Add Customer"
			onclick="window.location.href = 'showFormForAdd'; return false;"
			class = "add-button" />
			<table>
				<tr>
					<th> First Name</th>
					<th> Last Name</th>
					<th> Email</th>
					<th> Action</th>
				
				</tr>
				<c:forEach var= "tempCustomer" items="${customers}">
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
				<c:url var="deleteLink" value="/customer/deleteCustomer">
					<c:param name="customerId" value="${tempCustomer.id}"></c:param>
				</c:url>
					<tr>
						<td> ${tempCustomer.firstName }</td>
						<td> ${tempCustomer.lastName }</td>
						<td> ${tempCustomer.email }</td>
						<td> 
							<a href="${updateLink}">Update</a> | <a href="${deleteLink}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		
		</div>
	</div>
</div>
</body>
</html>