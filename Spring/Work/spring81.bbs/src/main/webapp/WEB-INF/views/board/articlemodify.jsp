<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="게시판 수정하기 폼" />
    <meta name="Description" content="게시판 수정하기 폼" />
    
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
					<h2>수정</h2>
					<form id="modifyForm" action="articlemodify" method="post" enctype="multipart/form-data" onsubmit="return check()">
						<p style="margin: 0; padding: 0;">
							<input type="hidden" name="articleno" value="${articleno }" />
							<input type="hidden" name="boardcd" value="${boardcd }" />
							<input type="hidden" name="curPage" value="${curPage }" />
							<input type="hidden" name="searchWord" value="${searchWord }" />
						</p>
						<table id="write-form">
							<tr>
								<td>제목</td>
								<td><input type="text" name="title" size="50"
									value="${thisArticle.title }" /></td>
							</tr>
							<tr>
								<td colspan="2"><textarea name="content" rows="17">${thisArticle.content }</textarea>
								</td>
							</tr>
							<tr>
								<td>파일첨부</td>
								<td><input type="file" name="upload" /></td>
							</tr>
						</table>
						<div style="text-align: center; padding-bottom: 15px;">
							<input type="submit" value="전송" /> 
							<input type="button" value="상세보기" onclick="goView()" /> 
							<input type="button" value="목록" onclick="goList()" />
						</div>
					</form>

				</div>
				<!-- bbs 끝 -->
				<!--  본문 끝 -->
			</div>
			<!-- content 끝 -->
		</div>
		<!--  container 끝 -->

	</div>


</body>
</html>
