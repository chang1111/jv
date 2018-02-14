<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title></title>
    <style type="text/css">
        .post {
            margin: 20px;
            text-align: justify;
            border: 2px solid lightblue;
            padding: 10px 20px 10px 20px;
        }
        #container {
            width: 800px;
            margin: auto;
        }
        #container img {
            width: auto;
        }
        td {
            font-size: 14px;
        }
        #write {
            display: inline;
            text-align: center;
            padding:20px 0 20px 0;
            background-color: lightgray;
            position: fixed;
            width:100px;
            top:40px;
            left:85%;
            
        }
        #gotop {
            display: inline;
            text-align: center;
            position: fixed;
            left: 90%;
            bottom: 40px;
            
        }
        .comment > .goodbad {
            display: inline;
        }
        .goodbad > a, .goodbad  span{
            text-decoration: none;
            font-size: 14px;
        }
        .commentbody a {
            text-decoration: none;
        }
        .strong {
            font-weight: bold;
        }
        .comment > a {
            color: black;
            text-decoration: none;
        }
        .comments {
            margin: 10px;
        }
        .comments a {
            text-decoration: none;
            font-size: 14px;
        }
    </style>
    <script type="text/javascript" src="/resources/jquery-3.2.1.js"></script>
    <script type="text/javascript">
        var postcount = 1;
        window.onload = function(event) {
            var windowHeight = $(window).height();
            var height = $(document).height();
            
            if (height === windowHeight ) {
                scrollautoadd(postcount++);
            }
        };
        
        $(document).ready(function(event) {
		    
		    
		    $(window).scroll(function(event) {
                var scrollTop = $(window).scrollTop();
                var windowHeight = $(window).height();
                var height = $(document).height();
                if (height === scrollTop + windowHeight ) {
                	scrollautoadd(postcount++);
                }
		    });
		    $('#write').click(function(event) {
		    	  location.href = 'writepost';
		    });
/*		    $('.post input[type="button"]').click(function(event) {
		    	var postno = $(this).parent('div').parent('.addComment').parent('.post').attr('postno');
		    	var memo = $(this).parent('div').prev('div').children('textarea').val();
		    	addComment(postno, memo);
		    }); */
		    $('body').on('click', '.post .goodbad > a', function(event) {
		    	var index = $(this).index();
		    	var postno = $(this).parents('.post').attr('postno');
		        if (index === 0) {
	                $.ajax({
	                    url : '/rest/addcountgood',  // 호출되는 서버 주소.
	                    data: {'postno':Number(postno)},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
	                    type: 'post',       // request method: get, post
	                    timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
	                    dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
	                    beforeSend : function() {
	                        // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
	                    }
	                }).done( function(data, textStatus, xhr ){
	                    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
	                    $('.post[postno="' + postno + '"] .good').text(data);
	                }).fail( function(xhr, textStatus, error ) {
	                    // 통신이 실패했을 때 이 함수를 타게 된다.
	                }).always( function(data, textStatus, xhr ) {
	                    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
	                });

		        }
		        else if (index === 2) {
                    $.ajax({
                        url : '/rest/addcountbad',  // 호출되는 서버 주소.
                        data: {'postno':Number(postno)},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
                        type: 'post',       // request method: get, post
                        timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
                        dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                        beforeSend : function() {
                            // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
                        }
                    }).done( function(data, textStatus, xhr ){
                        // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                        $('.post[postno="' + postno + '"] .bad').text(data);
                    }).fail( function(xhr, textStatus, error ) {
                        // 통신이 실패했을 때 이 함수를 타게 된다.
                    }).always( function(data, textStatus, xhr ) {
                        // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
                    });
		        	
		        }
		    });
		    $('body').on('click', 'input[type="button"]', function(event) {
		        var postno = $(this).parent('div').parent('.addComment').parent('.post').attr('postno');
                var memo = $(this).parent('div').prev('div').children('textarea').val();
                addComment(postno, memo);
                $(this).parent('div').prev('div').children('textarea').val('');
		    });
		    $('#gotop').click(function(event) {
                $('html').animate({scrollTop:0});
		    });
		    
        });
        var scrollautoadd = function(count) {
            $.ajax({
                url : '/rest/scrollautoadd',  // 호출되는 서버 주소.
                data: {'num':count+1},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
                type: 'post',       // request method: get, post
                timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
                dataType: 'html',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                $('#container').append(data);
//                imageload($('div.post').eq(count).attr('postno'));
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
//                var scrollTop = $(window).scrollTop();
                var windowHeight = $(window).height();
                var height = $(document).height();
                
                if (height === windowHeight ) {
                    scrollautoadd(postcount++);
                }
            });
        };
        var comments = function(postno) {
        	$('.post[postno="' + postno + '"] .commentbody').toggle();
        	$('.post[postno="' + postno + '"] .addComment').toggle();
        };
        var addComment = function(postno, memo) {
            $.ajax({
                url : '/rest/insertcomment',  // 호출되는 서버 주소.
                data: {'postno':Number(postno), 'memo':memo},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
                type: 'post',       // request method: get, post
                timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
                dataType: 'html',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                $('.post[postno="' + postno + '"] .commentbody').prepend(data);
                var commentNum = $('.post[postno="' + postno + '"] .commentNum').text();
                if (commentNum) {
                    $('.post[postno="' + postno + '"] .commentNum').text(Number(commentNum) + 1);
                }
                else {
                    $('.post[postno="' + postno + '"] .comment > a').after('<span class="strong"> [<span class="commentNum">1</span>]</span>');
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
            });
        }
        var commentModifyShowHide = function(commentno) {
        	$('.comments[commentno="' + commentno + '"] .modify-comment').toggle();
        };
        var commentupdate = function(commentno) {
        	var memo = $('.comments[commentno="' + commentno + '"] .modify-comment-ta').val();
            $.ajax({
                url : '/rest/updatecomment',  // 호출되는 서버 주소.
                data: {'commentno':Number(commentno), 'memo':memo},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
                type: 'post',       // request method: get, post
                timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
                dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data === 1) {
                    $('#comment' + commentno).text(memo);
                    $('.comments[commentno="' + commentno + '"] .modify-comment-ta').val('');
                    commentModifyShowHide(commentno);
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
            });
        };
        var commentdelete = function(commentno) {
        	var f = confirm('삭제하시겠습니까?');
        	var postno = $('.comments[commentno="' + commentno + '"]').parents('.post').attr('postno');

        	if (!f) {
        		return false;
        	}
            $.ajax({
                url : '/rest/commentdelete',  // 호출되는 서버 주소.
                data: {'commentno':Number(commentno)},  // 서버로 보내지는 데이터.사용하는 경우에는 { data1:'test1', data2:'test2' }
                type: 'post',       // request method: get, post
                timeout: 30000,    // 최대 대기 시간: 30초. 30초 이상이 되면 fail 부분이 실행됨.
                dataType: 'json',  // response로 넘어오는 데이터 형태: text, html, xml, json, jsonp, script
                beforeSend : function() {
                    // 통신이 시작되기 전에 이 함수를 타게 된다. 화면에 시계 표출.
                }
            }).done( function(data, textStatus, xhr ){
                // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
                if (data === 1) {
                    $('.comments[commentno="' + commentno + '"]').remove();
                    var count = Number($('.post[postno="' + postno + '"] .commentNum').text());
                    if (count === 1) {
                    	$('.post[postno="' + postno + '"] .commentNum').parent('span').remove();
                    }
                    else {
                    	$('.post[postno="' + postno + '"] .commentNum').text(--count);
                    }
                }
            }).fail( function(xhr, textStatus, error ) {
                // 통신이 실패했을 때 이 함수를 타게 된다.
            }).always( function(data, textStatus, xhr ) {
                // 통신이 실패했어도 성공했어도 이 함수를 타게 된다. 표출된 시계 감추기..
            });
        };
    </script>
</head>
<body>
    <div id="container">
        <c:forEach var="post" items="${item }">
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
        </c:forEach>
    </div>
    <input type="button" id="write" value="글쓰기" />
    <input type="button" id="gotop" value="▲" />
</body>
</html>