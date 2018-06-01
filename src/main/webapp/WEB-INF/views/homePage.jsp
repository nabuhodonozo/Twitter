<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>Home Page!</h1>
	<a href="addUser">Add new User</a>
	<form:form modelAttribute="tweet">
		<form:textarea path="message"/>
		<input type="submit" value="Add tweet"/>
	</form:form>
	<!--
	<c:forEach items="${tweets}" var="tweety">
		<c:out value="${tweety.user }"></c:out>
		<c:out value="${tweety.message }"></c:out>
	</c:forEach>
	-->
</body>
</html>