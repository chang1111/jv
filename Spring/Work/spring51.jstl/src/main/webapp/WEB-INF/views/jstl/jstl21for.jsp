<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 코어 라이브러리 : forEach 실습</title>
</head>
<body>
    <c:forEach var="cnt" begin="2" end="20" step="2">
        <font size="${cnt/2}"> ${cnt/2} 야~호~</font><br>
    </c:forEach>
</body>
</html>