<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 변수 선언</title>
</head>
<body>
    <h3>JSTL 변수 선언 >> jstl02 MVC</h3>
    <c:set var="result" value="${num1*num2}" />
    <p>num1 ${num1} 과 num2 ${num2} 의 곱은 ${result}</p>
    <p>num1 ${num1} 과 num2 ${num2} 의 곱은 ${num1*num2}</p>
</body>
</html>