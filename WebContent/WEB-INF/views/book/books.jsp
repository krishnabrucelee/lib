<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Books</title>
<style>
.clickMe {
	-moz-appearance: button;
	-ms-appearance: button;
	-o-appearance: button;
	-webkit-appearance: button;
	appearance: button;
	text-decoration: none;
	color: #000;
	padding: 0.2em 0.4em;
}
��
</style>
</head>
<body>
	<table>
		<tr>
			<td><a class="clickMe"	href="member">Member</a></td>
			<td><a class="clickMe"	href="book">Book</a></td>
			<td><a class="clickMe"	href="transaction">Transaction</a></td>
			<td><a class="clickMe"	href="search">Search</a></td>
			<td>
				<form method="get" action="logout">
					<button type="submit" value="logout">Logout</button>
				</form>
			</td>
		</tr>
	</table>
	
	<table border=1>
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Title</th>
				<th>Author</th>

				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td><c:out value="${book.id}" /></td>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.author}" /></td>

					<td><a class="clickMe" href="updateBook<c:out value="${book.id}"/>">Update</a></td>
					<td><a class="clickMe" href="deleteBook<c:out value="${book.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a class="clickMe" href="addBook">Add Book</a>
	</p>
</body>
</html>