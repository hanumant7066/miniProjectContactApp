<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All contact page</title>
</head>
<body>
	<h1>All Contacts</h1>

	<table border="3">
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
					
					<td><a type="button" method="PUT" href="/deleteById?id=${b.contactId}">delete</a>
					<a type="button" href="/updateById?id=${b.contactId}">Update</a></td>
					
				</tr>
				
			</a:forEach>
		
		</tbody>
	</table>
	<h2>
		<a href="/createcontact">Home</a>
	</h2>

</body>
</html>