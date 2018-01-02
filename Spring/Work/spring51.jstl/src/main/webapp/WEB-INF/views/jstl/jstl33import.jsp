<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="https://www.naver.com/index.html" var="url" />
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 코어 라이브러리 : import / url 실습</title>
</head>
<body>
    내용출력
    <hr>
    <textarea rows="30" cols="130">
        ${url}<br>
    </textarea>
</body>
</html>