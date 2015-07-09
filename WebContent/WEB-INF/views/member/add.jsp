<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Add new Member</title>
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
	<form method="POST" action='addMember' name="frmAddUser">
		Member ID : <input type="text" readonly="readonly" name="id"
			value="<c:out value="${member.id}" />" />
		 <br />
		Name : <input type="text" name="name" value="<c:out value="${member.name}" />" />
		<br />
		Email : <input type="text" name="email"
			value="<c:out value="${member.email}" />" />
			<br />
			<input type="submit" value="Submit" />
	</form>
</body>
</html>