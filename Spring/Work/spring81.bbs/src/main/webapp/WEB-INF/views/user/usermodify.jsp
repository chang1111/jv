<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="Keywords" content="내 정보 수정" />
    <meta name="Description" content="내 정보 수정" />
    <title>내 정보 수정</title>
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css"  />
   
</head>
<body>

<div id="wrap">

    <div id="container">
        <div id="content" style="min-height: 800px;">
        
            <!-- 본문 시작 -->
            <div id="url-navi">회원</div>
            <h1>내 정보 수정</h1>
            <c:if test="${not empty msg }">
            <p style="color: red;">정보 수정에 실패했습니다.</p>
            </c:if> 
            
            <p>
            비밀번호외의 자신의 계정 정보를 수정할 수 있습니다.<br />
            비밀번호는 <a href="./changepassword">비밀번호 변경</a>메뉴를 이용하세요.<br />
            </p>
            
            <form id="editAccountForm" action="./usermodify" method="post" onsubmit="return check()">
            <p>
                <input type="hidden" name="userid" value="${user.userid }" />
            </p>
            <table>
                <tr>
                    <td>이름(Full Name)</td>
                    <td><input type="text" name="name" value="${user.name }" /></td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td><input type="text" name="email" value="${user.email }" /></td>
                </tr>
                <tr>
                    <td>이동전화(Mobile)</td>
                    <td><input type="text" name="mobile" value="${user.mobile }" /></td>
                </tr>
                <tr>
                    <td>현재 비밀번호(Password)</td>
                    <td><input type="password" name="passwd" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="전송" /></td>
                </tr>
            </table>
            </form>
            <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
   
</div>

</body>
</html>
