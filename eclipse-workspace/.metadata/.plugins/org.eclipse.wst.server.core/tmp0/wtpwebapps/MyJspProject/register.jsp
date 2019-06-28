<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="show.jsp">
		用户名：<input type="text" name="uname"/><br/>
		密码：<input type="password" name="upswd" /><br/>
		性别：<input type="radio" name="sex" value="男生"/>男生
			<input type="radio" name="sex" value="女生"/>女生<br/>
		爱好：<input type="checkbox" name="hobbies" value="足球"/>足球&nbsp;&nbsp;
			<input type="checkbox" name="hobbies" value="篮球"/>篮球&nbsp;&nbsp;
			<input type="checkbox" name="hobbies" value="乒乓球"/>乒乓球&nbsp;&nbsp;
			<input type="checkbox" name="hobbies" value="跆拳道"/>跆拳道<br/>
			<input type="submit" name="提交"/>
	</form>
</body>
</html>