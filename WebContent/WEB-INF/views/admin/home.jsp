<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" href="css/style.css" rel="stylesheet" />
<title>Home</title>
</head>
<body>
	<h2>Admin Dashboard!!</h2>
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
	<p>
		Total Books : 4563 <br> Total Members : 1574 <br> Books
		Lended: 1654 <br>

	</p>
	<table class="GeneratedTable" border="1">
		<thead>
			<tr>
				<th>Book ID</th>
				<th>Title</th>
				<th>Member</th>
				<th>Issue Date</th>
				<th>Due Date</th>
				<th>Over Due(Days)</th>
				<th>Fine</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1001</td>
				<td>Revolution2020</td>
				<td>Krishna</td>
				<td>15-06-2015</td>
				<td>21-06-2015</td>
				<td>3</td>
				<td>3</td>
			</tr>
			<tr>
				<td>1001</td>
				<td>2States</td>
				<td>kumar</td>
				<td>23-07-2015</td>
				<td>27-08-2015</td>
				<td>6</td>
				<td>6</td>
			</tr>
		</tbody>
	</table>
</body>
</html>