<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>JSTL 선택문</title>
</head>
<body>
    <h2>
	   jstl if 사용법
    </h2>
    <c:if test="${ val == 0 }">
        if 문 적용됨. <br />
    </c:if>
    안녕하세요
</body>
</html>
