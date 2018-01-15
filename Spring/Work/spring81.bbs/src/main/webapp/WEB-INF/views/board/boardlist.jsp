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
                            <c:forEach var="board" items="${list }" varStatus="status"> 
                            <tr boardcd="${board.boardcd}">
                                <td style="text-align: center;">${status.index}</td>
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
                </div>

                <div style="text-align: left; padding-bottom: 15px;">
                    <input type="button" value="목록" onclick="window.location='/board/boardlist' ;" />
                    <input type="button" value="추가" onclick="window.location='/board/boardwrite' ;" /> 
                </div>
                <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
    
</div>


</body>
</html>
