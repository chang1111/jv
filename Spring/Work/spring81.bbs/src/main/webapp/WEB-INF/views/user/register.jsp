<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <meta name="Keywords" content="회원 가입" />
    <meta name="Description" content="회원 가입" />
    <title>회원 가입</title>
    <link rel="stylesheet" href="/resources/css/screen.css" type="text/css" />
    <script src="/resources/js/jquery-3.1.1.js"></script>
    <script>
        $(document).ready( function(event){
        	$('#checkuserid').click( function(event){
        		
        		// ajax로 /rest/checkuserid REST 서비스 호출.
        		var userid  = $('#userid').val();
        		
        		if( userid === '' ) {
        			alert("아이디를 입력하세요") ;
        			return false;
        		}
        		
        		$.ajax({
        		    url : '/rest/checkuserid'
        		    , data: {'userid' :  userid }        // 사용하는 경우에는 { data1:'test1', data2:'test2' }
        		    , type: 'get'       // get, post
        		    , timeout: 30000    // 30초
        		    , dataType: 'json'  // text, html, xml, json, jsonp, script
        		    , beforeSend : function() {
        		        // 통신이 시작되기 전에 이 함수를 타게 된다. 이미지 표출
        		    }
        		}).done( function(data, textStatus, xhr ){
        		    // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
        		    if( data === 0 ) {
        		    	alert('사용할수 있는 아이디');
                        $('#signUpForm input').prop('disabled', false);
        		    	return false;
        		    }
        		    else { 
                        alert('사용할수 없는 아이디');
                        return false;
        		    	
        		    }
        		}).fail( function(xhr, textStatus, error ) {
        		    // 통신이 실패했을 때 이 함수를 타게 된다.
        		}).always( function(data, textStatus, xhr ) {
        		    // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        		});
        	});
        	
        	$('#signUpForm input[type="submit"]').click( function(e) { 
        		
        		var list = $('.req_input');
        		for( var i=0; i<list.length; i++) {
        			if( $( list[i] ) .val() === '' ) {
        				list[i].focus();
        				$( list[i] ).after( '<label>입력하세요</label>' );
        				return false;
        			}
        		}
        		
        		// 패스워드 일치 여부 확인.
        		
        		
        		$('#signUpForm').submit();
        	});
        	
        	$('.req_input').keyup( function(event){
        		// 출력된 오류 메시지 삭제
        		if( $(this).val() !== '' ) {
        			$(this).next('label').remove(); // label 태그 삭제.
        		} 
        	});
        });
    
    </script>
            
</head>
<body>

<div id="wrap">

    <div id="header">
        <%@ include file="../inc/header.jsp" %>
    </div>

    <div id="main-menu">
        <%@ include file="../inc/main-menu.jsp" %>
    </div> 
    
    <div id="container">
        <div id="content" style="min-height: 800px;">

            <!-- 본문 시작 -->
            <div id="url-navi">회원</div>
            
            <h1>회원 가입</h1>
            <form id="signUpForm" action="register" method="post" enctype="application/x-www-form-urlencoded" >
                <table>
                    <tr>
                        <td style="width: 200px;">사용자 아이디</td>
                        <td style="width: 390px">
                            <input type="text" name="userid" style="width: 70%;" id="userid"  class="req_input"/>
                            <input type="button" value="아이디 중복 조회" id="checkuserid" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 200px;">이름(Full Name)</td>
                        <td style="width: 390px"><input type="text" name="name" style="width: 99%;" disabled="disabled"   class="req_input"/></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" style="width: 99%;" disabled="disabled"   class="req_input"/></td>
                    </tr>
                    <tr>
                        <td>비밀번호(Password)</td>
                        <td><input type="password" name="passwd" style="width: 99%;" disabled="disabled"  class="req_input"/></td>
                    </tr>
                    <tr>
                        <td>비밀번호 확인(Confirm)</td>
                        <td><input type="password" name="confirm" style="width: 99%;" disabled="disabled"   class="req_input"/></td>
                    </tr>
                    <tr>
                        <td>이동전화(Mobile)</td>
                        <td><input type="text" name="mobile" style="width: 99%;" disabled="disabled"  class="req_input" /></td>
                    </tr>
                </table>
                <div style="text-align: center;padding-bottom: 15px;">
                    <input type="submit" value="확인" />
                </div>
            </form>
            <!--  본문 끝 -->

        </div><!-- content 끝 -->
    </div><!--  container 끝 -->
   
   
    <div id="sidebar">
        <%@ include file="../inc/bbs-menu.jsp" %>
    </div>
    
    <div id="extra">
        <%@ include file="../inc/extra.jsp" %>
    </div>

    <div id="footer">
        <%@ include file="../inc/footer.jsp" %>
    </div>  
</div>

</body>
</html>
