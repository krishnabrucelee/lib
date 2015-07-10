<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" href="css/style.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Transaction</title>
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

	Member Id:<input type="text" name="id" /><br />

	<c:if test="${not empty alert}">
		<c:out value="${alert}" />
	</c:if>
<table>
	<tr>
		<td><form  action="issue" method="get">
			<input type="submit" value="Issue">
		</form></td>

        <td><form  action="renewal" method="get">
            <input type="submit" value="Renewal">
       </form></td>

       <td><form  action="return" method="get">
            <input type="submit" value="Return">
       </form></td>
     </tr>
</table>
</body>
</html>