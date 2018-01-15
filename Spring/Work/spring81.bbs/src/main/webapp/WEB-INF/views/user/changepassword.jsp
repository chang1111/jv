<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="Keywords" content="비밀번호 변경" />
    <meta name="Description" content="비빌번호 변경" />
    <title>비밀번호 변경</title>
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css"  />
 
</head>
<body>

<div id="wrap">

    <div id="container">
        <div id="content" style="min-height: 800px;">

            <!-- 본문 시작 -->
            <div id="url-navi">회원</div>
            <h1>비밀번호 변경</h1>
                ${user.name }<br />
                ${user.mobile }<br />
                
            <div id="error_message">
            </div>
            
            <form id="changePasswordForm" action="./changepassword" method="post">
                <table>
                <tr>
                    <td>현재 비밀번호</td>
                    <td><input type="password" name="currentPasswd" /></td>   
                </tr>
                <tr>
                    <td>변경 비밀번호</td>
                    <td><input type="password" name="newPasswd" /></td>
                </tr>
                <tr>
                    <td>변경 비밀번호 확인</td>
                    <td><input type="password" name="confirm" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="button" value="확인" /></td>
                </tr>
                </table>
            </form>
            <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->


</div>

</body>
</html>
