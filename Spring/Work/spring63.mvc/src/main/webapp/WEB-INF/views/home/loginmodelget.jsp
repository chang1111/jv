<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/spring/loginmodel" method="post" enctype="application/x-www-form-urlencoded">
        <label for="id">ID : <input type="text" name="id" value="${id}" /></label><br>
        <label for="pw">PW : <input type="password" name="pw" /></label><br>
        <input type="submit" value="전송">
    </form>
</body>
</html>