<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Join Success</title>
</head>
<body>
	<h1> MEMBER JOIN OK </h1>
	
	NAME : ${member.MNAME} <br />
	ID : ${member.MID} <br />
	PW : ${member.MPW} <br />
	BIRTH : ${member.MBIRTH} <br />
	
	<P>  The time on the server is ${serverTime}. </P>
	
	<a href="${cp}/member/loginForm"> LOGIN </a>
</body>
</html>
