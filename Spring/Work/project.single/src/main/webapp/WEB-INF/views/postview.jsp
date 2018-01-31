<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <style type="text/css">
        body {
            text-align: center;
        }
        #content {
            margin: 20px;
            text-align: justify;
            display: inline-block;
            width: 50%;
            border: 2px solid lightblue;
            padding: 10px 20px 10px 20px;
        }
        #container img {
            width: auto;
        }
    </style>
</head>
<body>
    <div id="container">
        <c:forEach var="post" items="${item }">
        <div id="content">
            <table>
                <tr>
                    <td width="80%">작성자 : ${post.author }</td>
                    <td>날짜 : <fmt:formatDate pattern="yyyy-MM-dd" value="${post.regdate }" /></td>
                </tr>
            </table>
            <hr>
            <img src="/resources/dream01.png"/>
        </div>
        </c:forEach>
    </div>
</body>
</html>