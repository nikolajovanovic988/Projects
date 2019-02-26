<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='<c:url value="/css/style.css"></c:url>' rel="stylesheet">
<script type="text/javascript" src='<c:url value="/js/demo.js"></c:url>'></script>
</head>
<body>

<a class="demo"href="${pageContext.request.contextPath}/login">Login</a>

<img alt="demo" src='<c:url value="/img/alienfleet.png"></c:url>'>

<a onclick="hello()">Sign up</a>
</body>
</html>