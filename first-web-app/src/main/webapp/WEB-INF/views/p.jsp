<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/p.do" method="post">
Enter your name<input type="text" name="name">
Enter your number<input type="text" name="num"><input type="submit" value="ADD"/>
</form>
<ol>
	<c:forEach items="${data}" var="da">
		<li>${da.name} &nbsp; &nbsp; <a href="/delete-data.do?name=${da.name}&num=${da.num}">Delete</a></li>
	</c:forEach>
	
</ol>
</body>
</html>