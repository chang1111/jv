<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

        <div class="post" postno="${post.postno }">
            <table>
                <tr>
                    <td width="80%">작성자 : ${post.author }</td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" value="${post.regdate }" /></td>
                </tr>
            </table>
            <hr>
            <div class="image"></div>
            <hr>
            <div> ${post.content }</div>
        </div>
