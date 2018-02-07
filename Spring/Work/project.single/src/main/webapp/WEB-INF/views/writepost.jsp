<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <style>
        #container {
            width: 800px;
            margin: 40px auto 0;
        }
    </style>
    <script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
    <div id="container">
        <form action="writepost" enctype="multipart/form-data" method="post">
            <input type="text" name="author" placeholder="작성자" />
            <br>
            <br>
            <textarea id="content" name="content"></textarea>
            <script type="text/javascript">
                CKEDITOR.replace('content', {
                	height: '400px'
                });
            </script>
            <br />
            사진 선택 <input type="file" name="image" />
            <br />
            <br />
            <input type="submit" value="글쓰기"/>
        </form>
    </div>
</body>
</html>