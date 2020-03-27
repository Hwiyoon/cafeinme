<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>MAIN</h1>
	
	<h1> MEMBER LOGIN OK </h1>
	
	
	<c:if test="${empty member}">
		<a href="${cp}/member/joinForm">JOIN</a> &nbsp;&nbsp; 
		<a href="${cp}/member/loginForm">LOGIN</a> &nbsp;&nbsp; 
	</c:if>
	
	<c:if test="${!empty member}">
		<a href="${cp}/board/bean/beanList">BEAN</a> &nbsp;&nbsp; 
		<a href="${cp}/member/logout">로그아웃</a> &nbsp;&nbsp;
	</c:if>
	

	
</body>
</html>