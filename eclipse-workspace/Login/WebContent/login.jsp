<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
	<script>
		function check(){
			var uname = document.getElementById("uname");
			var upassword = document.getElementById("upassword");
			if(uname.value == "admin" && upassword.value == "123456") return true;
			else{
				alert("用户名或密码错误");
				return false;
			}
		}
	</script>
</head>
	<% request.setCharacterEncoding("UTF-8"); %>
<body>
	<form action="success.jsp" method="get" onsubmit="return check()" >
		用户名：<input type="text" name="uname" id="uname" />
		密码：<input type="password" name="upassword" id="upassword"/><br>
		<input type="submit" value="提交"/>
		<input type="reset" value="重置"/>
	</form>
</body>
</html>