<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <style>
        table, td, th { border: 1px solid green; }
        th { background-color: green; color: white; }
    </style>
    <script type="text/javascript">
        var goList = function(pageno) {
        	// window.location.href : 현재 페이지 url 
        	window.location.href = "/phone/writeoneresult?curPage=" + pageno;
        }
    </script>
</head>
<body>
    <table>
        <tr>
            <th>no</th>
            <th>name</th>
            <th>manufacturer</th>
            <th>price</th>
        </tr>
        <c:forEach var="phone" items="${list }" varStatus="status">
            <tr>
                <td>${no - status.index}</td>
                <td>${phone.name}</td>
                <td>${phone.manufacturer}</td>
                <td>${phone.price}</td>
            </tr>
        </c:forEach>
    </table>
    
    <!-- 페이징 처리 -->
    <div id="paging" style="text-align: center;">
        
        <c:if test="${prevLink > 0 }">
            <a href="javascript:goList('${prevLink }')">[이전]</a>
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
            <a href="javascript:goList('${nextLink }')">[다음]</a>
        </c:if>
        
    </div>

</body>
</html>