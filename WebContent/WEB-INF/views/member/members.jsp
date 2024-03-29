<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	<c:if test= "${not empty alert}">
	<c:out value="${alert}" />
</c:if>
    <table align="left" border="2">
        <thead>
            <tr>
                <th>Member Id</th>
                <th>First Name</th>              
                <th>Email</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${members}" var="member">
                <tr>
                    <td><c:out value="${member.id}" /></td>
                    <td><c:out value="${member.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><a class="clickMe" href="updateMember<c:out value="${member.id}"/>">Update</a></td>
                    <td><a class="clickMe" href="deleteMember<c:out value="${member.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table> 
    
    <p><strong><a class="clickMe" href="addMember">Add Member</a></strong></p>
</body>
</html>