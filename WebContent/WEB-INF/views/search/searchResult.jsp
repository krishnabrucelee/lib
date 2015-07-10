 <%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Search Result</title>
<link type="text/css" href="css/style.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td><a class="clickMe" href="member">Member</a></td>
			<td><a class="clickMe" href="book">Book</a></td>
			<td><a class="clickMe" href="transaction">Transaction</a></td>
			<td><a class="clickMe" href="search">Search</a></td>
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

					<td><a class="clickMe"
						href="updateBook<c:out value="${book.id}"/>">Update</a></td>
					<td><a class="clickMe"
						href="deleteBook<c:out value="${book.id}"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>