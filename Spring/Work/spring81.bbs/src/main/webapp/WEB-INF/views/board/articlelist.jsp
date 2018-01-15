<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 목록" />
    <meta name="Description" content="게시판 목록" />
    
    <title>${boardNm }</title>
    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
             
</head>
<body>

<div id="wrap">

	<div id="container">
		<div id="content" style="min-height: 800px;">
			<div id="url-navi">BBS</div>
                
                <!-- 본문 시작 -->			
                <h1>${boardNm }</h1>
                <div id="bbs">
                	<table>
                	<tr>
                		<th style="width: 60px;">NO</th>
                		<th>TITLE</th>
                		<th style="width: 84px;">DATE</th>
                		<th style="width: 60px;">HIT</th>
                	</tr>
                	<!--  반복 구간 시작 -->
                	<c:forEach var="article" items="${articleList }" varStatus="status">	
                	<tr>
                		<td style="text-align: center;">${no - status.index}</td>
                		<td>
                			<a href="javascript:goView('${article.articleno }')">${article.title }</a>
                			<c:if test="${article.attachFileNum > 0 }">
                				<img src="/resources/images/attach.png" alt="첨부파일" />
                			</c:if>
                			<c:if test="${article.commentNum > 0 }">
                				<span class="bbs-strong">[${article.commentNum }]</span>
                			</c:if>
                		</td>
                		<td style="text-align: center;">
                            <fmt:formatDate pattern="yyyy-MM-dd" value="${article.regdate }" />
                        </td>
                		<td style="text-align: center;">${article.hit }</td>
                	</tr>
                	</c:forEach>
                	<!--  반복 구간 끝 -->
                	</table>
                		
                	<div id="paging" style="text-align: center;">
                		
                		<c:if test="${prevLink > 0 }">
                			<a href="javascript:goList('${prevPage }')">[이전]</a>
                		</c:if>
                
                		<c:forEach var="i" items="${pageLinks }" varStatus="stat">
                			<c:choose>
                			<c:when test="${curPage == i}">
                				<span class="bbs-strong">${i }</span>
                			</c:when>
                			<c:otherwise>
                				<a href="javascript:goList('${i }')">${i }</a>
                			</c:otherwise>
                			</c:choose>
                		</c:forEach>
                		
                		<c:if test="${nextLink > 0 }">
                			<a href="javascript:goList('${nextPage }')">[다음]</a>
                		</c:if>
                		
                	</div>
                
                	<div id="list-menu" style="text-align:  right;">
                		<input type="button" value="새글쓰기" onclick="goWrite()" />
                	</div>
                
                	<div id="search" style="text-align: center;">
                		<form id="searchForm" action="./articlelist" method="get" style="margin: 0;padding: 0;">
                			<p style="margin: 0;padding: 0;">
                				<input type="hidden" name="boardcd" value="${boardcd }" />
                				<input type="text" name="searchWord" size="15" maxlength="30" />
                				<input type="submit" value="검색" />
                			</p>	
                		</form>
                	</div>
                	
                </div>
                <!--  본문 끝 -->

		</div><!-- content 끝 -->
	</div><!--  container 끝 -->


</div>

</body>
</html>
