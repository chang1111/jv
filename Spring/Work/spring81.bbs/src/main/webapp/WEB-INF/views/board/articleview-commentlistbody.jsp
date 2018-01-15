<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="comments" commentno="${comment.commentno }">
    <h4>${comment.email }</h4>
    <h5><fmt:formatDate pattern="yyyy-MM-dd" value="${comment.regdate }" /></h5>
    <h6>
        <a href="javascript:commentModifyShowHide('${comment.commentno }')">수정</a> 
        |
        <a href="javascript:commentdelete('${comment.commentno }')">삭제</a>
    </h6>

    <p id="comment${comment.commentno}">${comment.memo }</p>
    
    <div class="modify-comment" style="display: none;">
        <div class="fr">
                <a href="javascript:commentupdate( '${comment.commentno }' )">수정하기</a>
                | 
                <a href="javascript:commentModifyShowHide( '${comment.commentno }' )">취소</a>
        </div>
        <div>
            <textarea class="modify-comment-ta" name="memo" rows="7" cols="50">${comment.memo }</textarea>
        </div>
    </div>
</div>

