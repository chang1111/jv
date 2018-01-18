<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 목록" />
    <meta name="Description" content="게시판 목록" />
    <title>게시판 목록</title>
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script>
        $(document).ready( function(event){
        	$('div#bbs > table > tbody > tr').click( function(event){
        		var boardcd = $(this).attr('boardcd');
        		window.location.href = '/board/boardview/' + boardcd;
        	});
        	
        });
        var goList = function(page) {
        	window.location.href = '/board/boardlist?searchWord=${searchWord}&curPage=' + page;
        }
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
                
                <!-- 본문 시작 -->          
                <h1>Board List</h1>
                <div id="bbs">
                    <table>
                        <thead>
                            <tr>
                                <th style="width: 60px;">NO</th>
                                <th>Board Code</th>
                                <th style="width: 84px;">Board Name</th>
                                <th style="width: 84px;">Use YN</th>
                            </tr>    
                        </thead>
                        <tbody>
                            
                            <!--  반복 구간 시작 -->
                            <c:forEach var="board" items="${ list }" varStatus="status"> 
                            <tr boardcd="${board.boardcd}">
                                <td style="text-align: center;">${no - status.index}</td>
                                <td style="text-align: center;"><span class="bbs-strong">${board.boardcd}</span></td>
                                <td style="text-align: center;">${board.boardnm}</td>
                                <td style="text-align: center;"><input type="checkbox" name="UseYN" disabled="disabled" 
                                                                    <c:if test="${board.useYN}">
                                                                        checked="checked"
                                                                    </c:if>  />
                                </td>
                            </tr>
                            </c:forEach>
                            <!--  반복 구간 끝 -->
                        </tbody>
                    </table>  
                    <div id="paging" style="text-align: center;">
                        
                        <c:if test="${prevLink > 0 }">
                            <a href="javascript:goList(${prevLink })">[이전]</a>
                        </c:if>
                
                        <c:forEach var="i" items="${pageLinks }" varStatus="stat">
                            <c:choose>
                            <c:when test="${curPage == i}">
                                <span class="bbs-strong">${i }</span>
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:goList(${i })">${i }</a>
                            </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        
                        <c:if test="${nextLink > 0 }">
                            <a href="javascript:goList(${nextLink })">[다음]</a>
                        </c:if>
                        
                    </div>                  
                    <div id="search" style="text-align: center;">
                        <form id="searchForm" action="./boardlist" method="get" style="margin: 0;padding: 0;">
                            <p style="margin: 0;padding: 0;">
                                <input type="hidden" name="curPage" value="${curPage }" />
                                <input type="text" name="searchWord" value="${searchWord }" size="15" maxlength="30" />
                                <input type="submit" value="검색" />
                            </p>    
                        </form>
                    </div>
                </div>

                <div style="text-align: left; padding-bottom: 15px;">
                    <input type="button" value="목록" onclick="window.location='/board/boardlist' ;" />
                    <input type="button" value="추가" onclick="window.location='/board/boardwrite' ;" /> 
                </div>
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
