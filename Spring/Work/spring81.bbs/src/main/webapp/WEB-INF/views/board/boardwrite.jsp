<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <meta name="Keywords" content="새글쓰기" />

    <title>${boardnm }</title>

    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" media="screen" />
    <style>
        #content { min-height: 800px; }
        p { margin: 0; padding: 0; }
        form div {text-align: left; padding-bottom: 15px; }
    </style>    
    
</head>
<body>

    <div id="wrap">
    
        <div id="container">
            <div id="content" >

                <!-- 본문 시작 -->
                <div id="bbs">
                    <h2>글쓰기</h2>
                    <form id="writeForm" action="boardwrite" method="post" enctype="application/x-www-form-urlencoded" >
                        <div>                        
                            <p> Borad Code :
                                <input type="text" id="boardcd"  name="boardcd" value="${model.boardcd}" />
                            </p>
                        </div>
                        
                        <div>
                            <p> Board Name : 
                                <input type="text" id="boardnm" name="boardnm" value="${model.boardnm}" />
                            </p>
                        </div>
                        
                        <div>
                            <p> Use YN : 
                                <input type="checkbox" id="UseYN" name="UseYN" <c:if test="${model.useYN}">checked="checked"</c:if> />
                            </p>
                        </div>

                        <div>
                            <input id="btnSubmit" type="submit" value="전송" /> 
                            <input id="btnView"   type="button" value="상세보기" /> 
                            <input id="btnList"   type="button" value="목록" />
                            <input id="btnReset"  type="reset" value="취소" />
                        </div>
                    </form>
                </div> <!--  본문 끝 -->

            </div> <!-- content 끝 -->
            
        </div> <!--  container 끝 -->

    </div>

</body>
</html>
