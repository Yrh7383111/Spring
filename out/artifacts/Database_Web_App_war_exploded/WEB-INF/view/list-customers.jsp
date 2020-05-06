<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>

	<!-- CSS Reference -->
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>


<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>


	<div id="container">
		<div id="content">
			<!-- Add Customer button -->
			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"/>

			<!--  Add search box -->
			<form:form action="search" method="GET">
				<input type="submit" value="Search Customer" class="add-button" />

				<label>
					<input type="text" name="searchName" />
				</label>
			</form:form>

			<table>
				<tr>
					<%-- Table heading --%>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>

				<%-- Iterate through all the customers --%>
				<c:forEach var="customer" items="${customers}">
					<!-- Construct an "update" URL with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>

					<!-- Construct an "delete" URL with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>

					<tr>
						<%-- Table data --%>
						<td> ${customer.firstName} </td>
						<td> ${customer.lastName} </td>
						<td> ${customer.email} </td>
						<td>
							<!-- Display the Update link -->
							<a href="${updateLink}">Update</a>

							<span>|</span>

							<!-- Display the Update link -->
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>

</html>