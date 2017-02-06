<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login Form</title>
</head>
<body>
		<h3>User Registration Form</h3>
		<form:form modelAttribute = "addNewUser">
			<table>
				<tr>
					<td>Username:</td>
					<td><form:input path = "username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path = "password" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><form:input path = "name" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path = "email" /></td>
				</tr>
				<tr>
					<td>Contact:</td>
					<td><form:input path = "contact" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path = "address" /></td>
				</tr>
				<tr>
					<td>Date Of Birth:</td>
					<td><form:input path = "dateOfBirth" /></td>
				</tr>
			</table>
			<input type="submit" value="Registration"/> 
		</form:form>
</body>
</html>