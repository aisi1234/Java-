<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! int day = 3; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>if...else实例</h3>	
	<% if(day==1 | day==7){ %>
			<p>今天是周末</p>
	<% 	}else{ %>
			<p>今天不是周末</p>
	<% } %>
	<h3>switch-catch实例</h3>
</body>
</html>