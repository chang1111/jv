<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url var="url" value="http://search.naver.com/search.naver">
<c:param name="where" value="nextearch" />
<c:param name="query" value="iphone" />
<c:param name="sm" value="top_hty" />
<c:param name="fbm" value="1" />
</c:url>
<c:redirect url="${url}" />