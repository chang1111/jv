<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 반복문 >> forEach</title>
</head>
<body>
    <h3>JSTL 반복문 >> forEach</h3>
    <h3>String 배열</h3>
    <ul>
        <c:forEach var="dish" items="${array}">
            <li>${dish}</li>
        </c:forEach>
    </ul>
    <hr>
    <h3>ArrayList 배열</h3>
    <ul>
        <c:forEach var="dish" items="${list}">
            <li>${dish}</li>
        </c:forEach>
    </ul>
</body>
</html>