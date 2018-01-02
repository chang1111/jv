<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 반복문 >> forTokens</title>
</head>
<body>
    <h3>JSTL 반복문 >> forTokens</h3>
    <h3>넘어온 값은?</h3>
    <p>${member}</p>
    <hr />
    <h3>forTokens 을 이용한 자르기</h3>
    <c:forTokens var="member1" items="${member}" delims="^~/">
        ${member1 }<br>
    </c:forTokens>
</body>
</html>