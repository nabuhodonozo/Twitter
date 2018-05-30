<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add user</title>
<style>
	span{
		color: red;
	}

</style>
</head>
<body>
	<form:form method="post" modelAttribute="user">
		<div><label> <form:input path="username"/> username</label>          </div>
		<div><form:errors path="username"/></div>
		<div><label> <form:password path="password"/> password</label>          </div>
		<div><form:errors path="password"/></div>
		<div><label> <form:input type="email" path="email"/>  email  </label>          </div>
		<div><form:errors path="email"/></div>
		<div><label> <input type="submit"/>        </label>          </div>
	</form:form>
</body>
</html>