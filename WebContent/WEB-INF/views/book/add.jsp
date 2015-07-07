<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new book</title>
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
	<form method="POST" action='book' name="frmAddBook">
		Book ID : <input type="text" readonly="readonly" name="id" value="<c:out value="${book.id}" />" /> <br />
		 Title : <input	type="text" name="title" value="<c:out value="${book.title}" />" /> <br /> 
		 Author : <input type="text" name="author" value="<c:out value="${book.author}" />" /> <br />
		  <input type="submit" value="Submit" />
	</form>
	
</body>
</html>