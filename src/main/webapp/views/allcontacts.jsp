<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All contact page</title>
</head>
<body style="width:100%">

	<div>

	<h2>Filter Data Using below fileds</h2>
	<form:form action="getfilteredcontacts" modelAttribute="contact"
		method="POST" style="text-align:center">
		<table>
			<tr>
				<td>Contact Name :</td>
				<td><form:input path="contactName" /></td>
			</tr>
			<tr>
				<td>Contact EMAIL :</td>
				<td><form:input path="contactEmail" /></td>
			</tr>
			<tr>
				<td>Contact Number :</td>
				<td><form:input path="contactNumber" type="number" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Filter"></td>
			</tr>
		</table>

	</form:form><br>
	<button border="3">
		<a type="button" href="/viewallcontacts">Reset All Filters</a>
	</button>


	<h1 style="text-align: center">All Contacts</h1>
	
	</div>

	<table border="3" style="width:100%">
		<thead>
			<tr>
				<td>Contact Name</td>
				<td>Contact Email</td>
				<td>Contact Number</td>
				<td>Created Date</td>
				<td>Updated Date</td>
				<td>Action</td>

			</tr>
		</thead>
		<tbody>
			<a:forEach items="${allcontacts}" var="b">
				<tr>
					<td>${b.contactName}</td>
					<td>${b.contactEmail}</td>
					<td>${b.contactNumber}</td>
					<td>${b.createDate}</td>
					<td>${b.updateDate}</td>

					<td><a type="button" method="PUT"
						href="/deleteById?id=${b.contactId}">delete</a> <a type="button"
						href="/updateById?id=${b.contactId}">Update</a></td>

				</tr>

			</a:forEach>

		</tbody>
	</table>
	<h2>
		<a href="/createcontact">Home</a>
	</h2>

</body>
</html>