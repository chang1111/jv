<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <div class="post" postno="${post.postno }">
            <table>
                <tr>
                    <td width="80%">${post.author }</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${post.regdate }" /></td>
                </tr>
            </table>
            <hr>
            <c:if test="${not empty post.image }">
                <div class="image">
                    <img src="data: ${ post.image.contentType } ;base64, ${post.image.imageBase64 }" />
                </div>
            </c:if>
            <div> ${post.content }</div>
            <hr>
            <div class="comment">
                <a href="javascript:comments('${post.postno }')">댓글</a>
                <c:if test="${post.commentNum > 0 }">
                    <span class="strong">[<span class="commentNum">${post.commentNum }</span>]</span>
                </c:if>
                <div class="goodbad">
                    <a href="javascript:good()">Good</a><span class="good">${post.countgood }</span>
                    <a href="javascript:bad()">Bad</a><span class="bad">${post.countbad }</span>
                </div>
            </div>
            <div class="commentbody" style="display: none;">
                <c:forEach var="comment" items="${post.comment }" varStatus="status">    
                    <%@ include file="commentlistbody.jsp" %>
                </c:forEach>
            </div>
            <div class="addComment" style="display: none;">
                <div><textarea name="memo" rows="7" cols="50"></textarea></div>
                <div style="text-align: right;"><input type="button" value="댓글남기기" /></div>
            </div>
        </div>
