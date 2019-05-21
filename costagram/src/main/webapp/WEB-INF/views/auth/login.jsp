<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="/image/apple.png" />
<form action="/auth/loginProc" method="POST">
	<input type="text" name="username" /> <br />
	<input type="password" name="password" /> <br />
	<input type="submit" value="로그인" />
</form>
</body>
</html>