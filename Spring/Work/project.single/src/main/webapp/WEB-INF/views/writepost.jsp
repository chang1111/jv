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
    <script type="text/javascript">
        $(document).ready(function(event) {
        	$('input[type="button"]').click(function(event) {
                $('form').submit();
/*        		$.ajax({
        		    url : '/fcm/send',  // 호출되는 서버 주소.
        		    data: null,  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
        		    type: 'get',       // request method: get, post
        		    timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
        		    dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
        		    beforeSend : function() {
        		        // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
        		    }
        		}).done( function(data, textStatus, xhr ){
        		    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
        		}).fail( function(xhr, textStatus, error ) {
        		    // 통신이 실패했을 때 이 함수를 타게 된다.
        		}).always( function(data, textStatus, xhr ) {
        		    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
        		}); */
        	});
        });
    </script>
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
            <input type="button" value="글쓰기"/>
        </form>
    </div>
</body>
</html>