<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 상세보기" />
    <meta name="Description" content="게시판 상세보기" />
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <title>${boardNm }</title>
   
</head>
<body>

<div id="wrap">

    <div id="container">
        <div id="content" style="min-height: 800px;">
            
            <!-- 본문 시작 -->
            <h1>Board View</h1>
            <div id="bbs">
                <table>
                    <tr>
                        <th style="text-align: left; width: 100px;">Borad Name</th>
                        <th style="text-align: left; color: #555;">${board.boardnm }</th>
                    </tr>
                    <tr>
                        <th style="text-align: left; width: 100px;">Board Code</th>
                        <th style="text-align: left; color: #555;">${board.boardcd }</th>
                    </tr>
                    <tr>
                        <th style="text-align: left; width: 100px;">Use YN</th>
                        <th style="text-align: left; color: #555;"><input type="checkbox" name="UseYN" readonly="readonly" <c:if test="${board.useYN}">checked="checked"</c:if> /> </th>
                    </tr>   
                </table>
            </div>

            <div style="text-align: left; padding-bottom: 15px;"> 
                <input type="button" class="boardlist"   value="목록" />
                <input type="button" class="boardwrite"  value="추가" />
                <input type="button" class="boardmodify" value="수정" />
                <input type="button" class="boarddelete" value="삭제" />
            </div>
            <!--  본문 끝 -->
            
        </div>
        <!-- content 끝 -->
        
    </div>
    <!--  container 끝 -->
    
</div>


</body>
</html>
