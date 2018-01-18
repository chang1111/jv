<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="Keywords" content="탈퇴" />
<meta name="Description" content="탈퇴" />
<title>탈퇴</title>
<link rel="stylesheet" href="/resources/css/screen.css" type="text/css" />
        
</head>
<body>

<div id="wrap">

    <div id="header">
        <%@ include file="../inc/header.jsp" %>
    </div>

    <div id="main-menu">
        <%@ include file="../inc/main-menu.jsp" %>
    </div> 
    
    <div id="container">
        <div id="content" style="min-height: 800px;">

            <!-- 본문 시작 -->
            <div id="url-navi">회원</div>
            
            <h1>탈퇴</h1>
            <form id="byeForm" action="./unregister" method="post" onsubmit="return check()">
            <table>
            <tr>
                <td>이메일</td>
                <td><input type="text" name="email" /></td>   
            </tr>
            <tr>
                <td>비밀번호</td>
                <td><input type="password" name="passwd" /></td>  
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="확인" /></td>
            </tr>
            </table>
            </form>
            <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->

    <div id="sidebar">
        <%@ include file="../inc/bbs-menu.jsp" %>
    </div>
    
    <div id="extra">
        <%@ include file="../inc/extra.jsp" %>
    </div>

    <div id="footer">
        <%@ include file="../inc/footer.jsp" %>
    </div> 
</div>

</body>
</html>
