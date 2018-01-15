<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="수정하기 폼" />
    <meta name="Description" content="수정하기 폼" />
    <title>${boardnm }</title>
    
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
   
</head>
<body>

    <div id="wrap">    

        <div id="container">
            <div id="content" style="min-height: 800px;">

                <!-- 본문 시작 -->
                <div id="bbs">
                    <h2>수정</h2>
                    <form id="modifyForm" action="${actionurl}" method="post" enctype="application/x-www-form-urlencoded" onsubmit="return check()">
                        <div>                        
                            <p style="margin: 0; padding: 0;">
                                Borad Code :
                                <input type="text" id="boardcd"  name="boardcd" value="${model.boardcd}" readonly="readonly" />
                            </p>
                        </div>
                        
                        <div>
                            <p style="margin: 0; padding: 0;">
                                Board Name : 
                                <input type="text" id="boardnm"  name="boardnm" value="${model.boardnm}" />
                            </p>
                        </div>
                        
                        <div>
                            <p style="margin: 0; padding: 0;">
                                Use YN : 
                                <input type="checkbox" id="UseYN" name="UseYN" <c:if test="${model.useYN}">checked="checked"</c:if> />
                            </p>
                        </div>

                        <div style="text-align: left; padding-bottom: 15px;">
                            <input type="submit" value="전송" /> 
                            <input type="button" value="상세보기" onclick="window.location='/board/boardview' ;" /> 
                            <input type="button" value="목록" onclick="window.location='/board/boardlist' ;" />
                            <input type="reset" value="취소" />
                        </div>
                    </form>
                </div>
                <!--  본문 끝 -->

            </div>
            <!-- content 끝 -->
            
        </div>
        <!--  container 끝 -->

    </div>


</body>
</html>
