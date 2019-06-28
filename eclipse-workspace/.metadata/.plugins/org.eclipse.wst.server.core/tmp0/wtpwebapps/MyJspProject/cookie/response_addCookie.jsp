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
		//模拟添加cookie，由服务器创建cookie对象，然后通过response的addCookie方法添加，发送到客户端
		//客户端通过request的getCookies获取Cookie的集合
		Cookie cookie1 = new Cookie("uname","tom");
		Cookie cookie2 = new Cookie("upswd","123456");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.sendRedirect("show.jsp");
	%>
</body>
</html>