<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 상세보기" />
    <meta name="Description" content="게시판 상세보기" />
    
    <title>${boardnm }</title>
    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <script type="text/javascript" src="/resources/js/jquery-3.1.1.js">></script>
    <script type="text/javascript">
        $(document).ready(function(event) {
        	$('tr[articleno]').click(function(event) {
        		var articleno = $(this).attr('articleno');
        		location.href = '/board/articleview/${boardcd}/' + articleno + location.search;
        	});
        });
        var goView = function(articleno) {
        	location.href = '/board/articleview/${boardcd}/' + articleno + location.search;
        };
        var goModify = function() {
        	location.href = '/board/articlemodify/${boardcd}/${articleno}';
        };
        var goDelete = function() {
        	// post로 처리해야함
        	// post 처리하는 방법에는 1. ajax, 2. form을 이용하는 방법
        	var f = document.createElement('form');
        	f.setAttribute('method', 'post');
        	f.setAttribute('action', '/board/articledelete/${boardcd}/${articleno}');
        	f.setAttribute('enctype', 'application/x-www-form-urlencoded');
        	document.body.appendChild(f);
        	f.submit();
        	
        	
        };
        var goList = function(curPage, redirect) {
        	if (redirect === false) {
                location.href = '/board/articleview/${boardcd}/${articleno}?curPage=' + curPage;
        	}
        	else {
                location.href = '/board/articlelist/${boardcd}?curPage=' + curPage;
        	}
        };
        var goWrite = function() {
        	location.href = '/board/articlewrite/${boardcd};
        };
    </script>
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
			<div id="url-navi">BBS</div>
            
            <!-- 본문 시작 -->
            <h1>${boardnm }</h1>
            <div id="bbs">
            	<table>
            	<tr>
            		<th style="width: 50px;">TITLE</th>
            		<th style="text-align: left;color: #555;">${thisArticle.title }</th>
            		<th style="width: 50px;">DATE</th>
            		<th style="width: 130px;color: #555;"><fmt:formatDate pattern="yyyy-MM-dd" value="${thisArticle.regdate }" /></th>
            	</tr>	
            	</table>
            
            	<div id="gul-content">
            		<h6>작성자 ${thisArticle.email }, 조회수 ${thisArticle.hit }</h6>
            		<p>${thisArticle.content }</p>
            		<p id="file-list" style="text-align: right;">
            			<c:forEach var="file" items="${attachFileList }" varStatus="status">
            			<a href="javascript:download('${file.filenametemp }')">${file.filenameorig }</a>
            			<a href="javascript:deleteAttachFile('${file.attachfileno }')">x</a>
            			<br />
            			</c:forEach>	
            		</p>		
            	</div>
            	
            	<!--  덧글 반복 시작 -->
                <div id="commentlist">
                	<c:forEach var="comment" items="${commentList }" varStatus="status">	
                    <%@ include file="articleview-commentlistbody.jsp" %>
                	</c:forEach>
                </div>
            	<!--  덧글 반복 끝 -->
                
            	<div id="addComment">
            		<div>
            			<textarea name="memo" rows="7" cols="50" articleno="${articleno}" ></textarea>
            		</div>
            		<div style="text-align: right;">
            			<input type="button" value="덧글남기기" />
            		</div>
            	</div>
            	
            	<div id="next-prev">
            		<c:if test="${nextArticle != null }">
            			<p>다음글 : <a href="javascript:goView('${nextArticle.articleno }')">${nextArticle.title }</a></p>
            		</c:if>
            		<c:if test="${prevArticle != null }">
            			<p>이전글 : <a href="javascript:goView('${prevArticle.articleno }')">${prevArticle.title }</a></p>
            		</c:if>
            	</div>
            	
            	<div id="view-menu">
            		<div class="fl">
            			<input type="button" value="수정" onclick="goModify();" />
            			<input type="button" value="삭제" onclick="goDelete()" />
            		</div>
            		
            		<div class="fr">
            		<c:if test="${nextArticle != null }">		
            			<input type="button" value="다음글" onclick="goView('${nextArticle.articleno }')" />
            		</c:if>
            		<c:if test="${prevArticle != null }">			
            			<input type="button" value="이전글" onclick="goView('${prevArticle.articleno }')" />
            		</c:if>
            			<input type="button" value="목록" onclick="goList(${curPage })" />
            			<input type="button" value="새글쓰기" onclick="goWrite()" />
            		</div>
            	</div>
            
            	<table style="clear: both;">
                	<tr>
                		<th style="width: 60px">NO</th>
                		<th>TITLE</th>
                		<th style="width: 84px;">DATE</th>
                		<th style="width: 60px;">HIT</th>
                	</tr>
                	
                	<!--  반복 구간 시작 -->
                	<c:forEach var="article" items="${articleList }" varStatus="status">
                    <tr articleno="${article.articleno }"> <!-- 사용자 속성 추가: articleno -->
                		<td style="text-align: center;">
                			<c:choose>
                				<c:when test="${articleno == article.articleno }">
                					<img src="/resources/images/arrow.gif" alt="현재글" />
                				</c:when>
                				<c:otherwise>
                					${no - status.index }
                				</c:otherwise>
                			</c:choose>
                		</td>
                		<td>
                			<a href="javascript:goView('${article.articleno }')">${article.title }</a>
                			<c:if test="${article.attachFileNum > 0 }">
                				<img src="/resources/images/attach.png" alt="첨부파일" />
                			</c:if>
                			<c:if test="${article.commentNum > 0 }">
                				<span class="bbs-strong">[${article.commentNum }]</span>
                			</c:if>
                		</td>
                		<td style="text-align: center;"><fmt:formatDate pattern="yyyy-MM-dd" value="${article.regdate }" /></td>
                		<td style="text-align: center;">${article.hit }</td>
                	</tr>
                	</c:forEach>
                	<!--  반복 구간 끝 -->
            	</table>
            		
            	<div id="paging" style="text-align: center;">            		
            		<c:if test="${prevLink > 0 }">
            			<a href="javascript:goList(${prevLink }, false)">[이전]</a>
            		</c:if>
            		
            		<c:forEach var="i" items="${pageLinks }" varStatus="stat">
            			<c:choose>
            			<c:when test="${curPage == i}">
            				<span class="bbs-strong">${i }</span>
            			</c:when>
            			<c:otherwise>
            				<a href="javascript:goList(${i }, false))">${i }</a>
            			</c:otherwise>
            			</c:choose>
            		</c:forEach>
            		
            		<c:if test="${nextLink > 0 }">
            			<a href="javascript:goList(${nextLink }, false))">[다음]</a>
            		</c:if>            		
            	</div>
   
            
            	<div id="list-menu" style="text-align:  right;">
            		<input type="button" value="새글쓰기" onclick="goWrite()" />
            	</div>
            
            	<div id="search" style="text-align: center;">
            		<form id="searchForm" action="${actionurl }" method="get" style="margin: 0;padding: 0;">
            			<p style="margin: 0;padding: 0;">
            				<input type="hidden" name="boardcd" value="${boardcd }" />
            				<input type="text" name="searchWord" value="${searchWord }" size="15" maxlength="30" />
            				<input type="submit" value="검색" />
            			</p>	
            		</form>
            	</div>
            	
            </div>
            <!--  본문 끝 -->
            
		</div>
        <!-- content 끝 -->
        
	</div>
    <!--  container 끝 -->
    <div id="sidebar">
        <%@ include file="bbs-menu.jsp" %>
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
