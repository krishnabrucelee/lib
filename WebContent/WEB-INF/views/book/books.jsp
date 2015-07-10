<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Books</title>
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

<c:if test="${not empty alert}">
		<c:out value="${alert}" />
	</c:if>
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

					<td><form  action="updateBook" method="get">
                              <input type="submit" value="Update">
                              <input type="hidden" value="${book.id}" name="id">
                              <input type="hidden" value="${book.title}" name="title">
                              <input type="hidden" value="${book.author}" name="author">
                     </form>
                     <td><form  action="deleteBook" method="post">
                              <input type="submit" value="Delete">
                              <input type="hidden" value="${book.id}" name="id">
                              <input type="hidden" value="${book.title}" name="title">
                              <input type="hidden" value="${book.author}" name="author">
                     </form>
                     </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a class="clickMe" href="addBook">Add Book</a>
	</p>
</body>
</html>