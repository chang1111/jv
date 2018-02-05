<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <style type="text/css">
        .post {
            margin: 20px;
            text-align: justify;
            border: 2px solid lightblue;
            padding: 10px 20px 10px 20px;
        }
        #container {
            width: 800px;
            margin: auto;
        }
        #container img {
            width: auto;
        }
        #write {
            display: inline;
            text-align: center;
            padding:20px 0 20px 0;
            background-color: lightgray;
            position: fixed;
            width:100px;
            top:40px;
            left:80%;
            
        }
    </style>
    <script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        $(document).ready(function(event) {
		    imageload($('div.post').eq(0).attr('postno'));
		    imageload($('div.post').eq(1).attr('postno'));
		    imageload($('div.post').eq(2).attr('postno'));
		    imageload($('div.post').eq(3).attr('postno'));
		    imageload($('div.post').eq(4).attr('postno'));
		    var count = 5;
		    
		    $(window).scroll(function(event) {
                var scrollTop = $(window).scrollTop();
                var windowHeight = $(window).height();
                var height = $(document).height();
                if (height === scrollTop + windowHeight) {
                	$.ajax({
                	    url : '/rest/scrollautoadd',  // 호출되는 서버 주소.
                	    data: {'num':count+1},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
                	    type: 'post',       // request method: get, post
                	    timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
                	    dataType: 'html',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                	    beforeSend : function() {
                	        // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
                	    }
                	}).done( function(data, textStatus, xhr ){
                	    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                	    $('#container').append(data);
                	    imageload($('div.post').eq(count++).attr('postno'));
                	}).fail( function(xhr, textStatus, error ) {
                	    // 통신이 실패했을 때 이 함수를 타게 된다.
                	}).always( function(data, textStatus, xhr ) {
                	    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
                	});
                }
		    });
		    $('#write').click(function(event) {
		    	  location.href = 'writepost';
		    });
        });
        var imageload = function(postno) {
        	$.ajax({
        	    url : '/rest/imageload',  // 호출되는 서버 주소.
        	    data: {'postno':Number(postno)},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
        	    type: 'post',       // request method: get, post
        	    timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
        	    dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
        	    beforeSend : function() {
        	        // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
        	    }
        	}).done( function(data, textStatus, xhr ){
        	    if (data.attachimageno) {
        	    	$('div.post[postno="' + data.postno + '"] .image').html('<img src="data:' + data.contentType + ';base64,' + data.imageBase64 + '" />');
        	    }
        	}).fail( function(xhr, textStatus, error ) {
        	    // 통신이 실패했을 때 이 함수를 타게 된다.
        	}).always( function(data, textStatus, xhr ) {
        	    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
        	});

        };
    </script>
</head>
<body>
    <div id="container">
        <c:forEach var="post" items="${item }">
        <div class="post" postno="${post.postno }">
            <table>
                <tr>
                    <td width="80%">작성자 : ${post.author }</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${post.regdate }" /></td>
                </tr>
            </table>
            <hr>
            <div class="image"></div>
            <hr>
            <div> ${post.content }</div>
        </div>
        </c:forEach>
    </div>
    <input type="button" id="write" value="글쓰기" />
</body>
</html>