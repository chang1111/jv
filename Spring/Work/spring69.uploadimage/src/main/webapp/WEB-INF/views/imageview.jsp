<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>helloworld</title>
</head>
<body>
    <!-- img 태그의 src 경로는 byte 이미지 가져오는 컨트롤러 호출(/getImageByte) -->
    <img alt="" src="/upload/getphoto/${attachfileno}" />
    <hr />
    <img src="data:${contentType};base64,${imageBase64}" />
</body>
</html>