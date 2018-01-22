<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL 선택문</title>
</head>
<body>
    <h3>jstl if 사용법</h3>
    <c:if test="${ param.val == 0 }">
        if 문 적용됨. <br />
    </c:if>
    안녕하세요.
</body>
</html>