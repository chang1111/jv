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
            margin: auto;
        }
    </style>
    <script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
<!--     <script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
    <script type="text/javascript">
        $(document).ready(function(event) {
            CKEDITOR.replace('content');
        });
    </script> -->
</head>
<body>
    <div id="container">
        <form action="writepost" enctype="multipart/form-data" method="post">
            <label>작성자 : </label><input type="text" name="author" />
            <br>
            내용<br>
            <textarea rows="6" cols="40" name="content"></textarea>
            <br />
            <br />
            <input type="file" name="image" />
            <br />
            <input type="submit" value="글쓰기"/>
        </form>
    </div>
</body>
</html>