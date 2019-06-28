<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String password = request.getParameter("upswd");
		String sex = request.getParameter("sex");
		String[] hobbies = request.getParameterValues("hobbies");
 	%>
 	<h2>注册成功，信息如下：</h2>
 	<p>姓名：<%= name %></p>
 	<p>密码：<%= password %></p>
 	<p>性别：<%= sex %></p>
 	<p>爱好：
 		<%
 			for(String hobby : hobbies){
 				out.print(hobby+"\t");
 			}
 		%>
 	</p>
</body>
</html>