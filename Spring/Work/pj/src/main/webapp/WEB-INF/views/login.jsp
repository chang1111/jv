<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>eNno Bootstrap Template</title>

    <!-- Bootstrap -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/animate.css">
    <link rel="stylesheet" href="/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/jquery.bxslider.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="/resources/css/set1.css" />
    <link href="/resources/css/overwrite.css" rel="stylesheet">
    <link href="/resources/css/style.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        form label {
            width: 80px;
        }
    </style>
    <script src="/resources/js/jquery-2.1.1.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/wow.min.js"></script>
    <script src="/resources/js/jquery.easing.1.3.js"></script>
    <script src="/resources/js/jquery.isotope.min.js"></script>
    <script src="/resources/js/jquery.bxslider.min.js"></script>
    <script src="/resources/js/functions.js"></script>
    <script type="text/javascript">
        $(document).ready(function(event) {
        	$('#login').click(function(event) {
        		if ($('input[name="userid"]').val() === '') {
        			alert('아이디를 입력하세요');
        		} else if ($('input[name="passwd"]').val() === '') {
        			alert('비밀번호를 입력하세요');
        		}
        		$('form').submit();
        	});
            $('#registor').click(function(event) {
                location.href = 'register';
            });
        });
    </script>
  </head>
  <body>
    <%@ include file="header.jsp"%>


    <div style="height: 200px;">
        
    </div>
    
    <div align="center">
        <c:if test="${not empty msg }">
        <p style="color: red;">로그인에 실패했습니다.</p>
        </c:if>      
        <div class="login" style="display: inline-block; border: 2px solid green; padding: 30px 30px; margin : 100px;">
            <form action="login" method="post" enctype="application/x-www-form-urlencoded">
                <label>아이디</label><input type="text" name="userid" /><br>
                <label>비밀번호</label><input type="password" name="passwd" /><br><br>
                <input type="button" id="login" value="로그인">&nbsp;
                <input type="button" id="registor" value="회원가입">
            </form>
        </div>
    </div>
    <%@ include file="footer.jsp"%>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  </body>
</html>
