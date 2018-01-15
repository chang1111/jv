<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1 style="float: left; width: 150px;">
	<a href="../"></a>
</h1>
<div id="memberMenu" style="float: right; position: relative; top: 7px;">
	<c:choose>
		<c:when test="${empty user}">
			<input type="button" value="로그인" onclick="location.href='/user/login'" />
			<input type="button" value="회원가입" onclick="location.href='/user/register'" />
		</c:when>
		<c:otherwise>
			<input type="button" value="로그아웃" onclick="location.href='/user/logout'" />
			<input type="button" value="내정보수정" onclick="location.href='/user/usermodify'" />
		</c:otherwise>
	</c:choose>
</div>