<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
    <style>
    div { background-color: #CCCCCC; layer-background-color: #CCCCCC; border: 1px dotted red; width:800px; }
    div#static_include    { position: absolute; left: 375px; top: 60px; padding : 5px; }
    div#dynamic_include   { position: absolute; left: 375px; top: 250px; padding : 5px; }
	div#redirect_forward  { }
    </style>
</head>
<body>   
    <p>  The time on the server is ${serverTime}. </p>
    <hr />
    
    <dl>
        <dt>JSTL 변수 선언</dt>
        <dd> <a href="./jstl/jstl01"  target="_blank">/jstl/jstl01</a> </dd>
        <dd> <a href="./jstl/jstl02"  target="_blank">/jstl/jstl02</a> </dd>     
        <dd> <a href="./jstl/jstl03?code=s1b1&name=aaa&price=1000"  target="_blank">/jstl/jstl03?code=s1b1&name=aaa&price=1000</a> </dd>    
    </dl>
    <dl>
        <dt>JSTL 선택문</dt>
        <dd> <a href="./jstl/jstl11"        target="_blank">/jstl/jstl11      </a> </dd>
        <dd> <a href="./jstl/jstl11?val=0"  target="_blank">/jstl/jstl11?val=0</a> </dd>
        <dd> <a href="./jstl/jstl11?val=1"  target="_blank">/jstl/jstl11?val=1</a> </dd>
        <br>
        <dd> <a href="./jstl/jstl12"        target="_blank">/jstl/jstl12      </a> </dd>
        <dd> <a href="./jstl/jstl12?num=0"  target="_blank">/jstl/jstl12?num=0</a> </dd>
        <dd> <a href="./jstl/jstl12?num=1"  target="_blank">/jstl/jstl12?num=1</a> </dd> 
        <dd> <a href="./jstl/jstl12?num=2"  target="_blank">/jstl/jstl12?num=2</a> </dd> 
        <br/>
        <dd> <a href="./jstl/jstl13?errorMessage="        target="_blank">errorMessage가 없을 때</a> </dd>
        <dd> <a href="./jstl/jstl13?errorMessage=error"   target="_blank">errorMessage가 있을 때</a> </dd>    
    </dl>
    <dl>
        <dt>JSTL 반복문</dt>
        <dd> <a href="./jstl/jstl21for"        target="_blank">/jstl/jstl21 for       </a> </dd>
        <dd> <a href="./jstl/jstl22foreach"    target="_blank">/jstl/jstl22 foreach   </a> </dd>
        <dd> <a href="./jstl/jstl23fortokens"  target="_blank">/jstl/jstl23 fortokens </a> </dd>                 
    </dl>
    <dl>
        <dt>JSTL import, redirect, forward
      </dt>
        <dd> <a href="./jstl/jstl31includefile"  target="_blank">include file  </a> </dd>
        <dd> <a href="./jstl/jstl32includepage"  target="_blank">include page   </a> </dd>
        <dd> <a href="./jstl/jstl33import"       target="_blank">import   </a> </dd>
    </dl>
    <dl>
        <dt>redirect and forward</dt>
        <dd> <a href="./jstl/jstl41redirect"     target="_blank">redirect </a> </dd>
        <dd> <a href="./jstl/jstl42forward"      target="_blank">forward  </a> </dd>
    </dl>
    <dl>
        <dt>JSTL scope</dt>
        <dd> <a href="./jstl/jstl61scope"      target="_blank">/jstl/jstl61 scope</a> </dd>
        <dd> <a href="./jstl/jstl63session"    target="_blank">/jstl/jstl63 session scope</a> </dd>
        <dd> <a href="./jstl/jstl64fn"         target="_blank">/jstl/jstl64 fn splite</a> </dd>
    </dl>
    <dl>
        <dt>JSTL 연습문제</dt>
        <dd> <a href="./jstl/jstl71checkbox"      target="_blank">jstl과 단일 체크박스</a> </dd>
        <dd> <a href="./jstl/jstl72checkbox"      target="_blank">jstl과 멀티 체크박스</a> </dd>
        <br>
        <dd> <a href="./jstl/jstl73radio"      target="_blank">jstl과 라디오버튼 </a> </dd>
        <br>
        <dd> <a href="./jstl/jstl74select"      target="_blank">jstl과 SELECT </a> </dd>
    </dl>
    
    <dl>
        <dt>El 연습</dt>
        <dd> <a href="./el/el01" target="_blank"> /el/el01</a> </dd>
        <dd> <a href="./el/el02" target="_blank"> /el/el02</a> </dd>
        <dd> <a href="./el/el03?id=pinksung" target="_blank"> /el/el03?id=pinksung</a> </dd>
    </dl>
    <hr />
   
<div id="static_include"> 
    <h4>정적 include</h4>          
    <pre>
    &lt;%@ include file="" %&gt;
        정적 include
        선합후컴 : include될 파일을 include하는 파일에 삽입시켜 내용을 합치고 실행한다.
        이 파일은 "하나의" 파일처럼 동작하기 때문에 사용하고자 하는 변수는 서로 공유된다.
    </pre>        
</div>

<div id="dynamic_include">
    <h4>동적 include</h4>        
    <pre>
    &lt;jsp:include page="" /&gt;
        동적 include 
        선컴후합 : 각각 실행한 후 두 파일의 실행 결과를 한 곳에 합쳐서 출력한다. 
        이 파일들은 완전히 "별도로" 동작하며 사용하고자 하는 변수는 파라미터로 따로 넘겨주어야 합니다.
    
    &lt;c:import url="" /&gt;
        동적 include 
        &lt;jsp:include&gt;의 확장 버전으로 동작 방식 또한 &lt;jsp:include&gt;와 같습니다. 
        &lt;jsp:include&gt;처럼 사용하고자 하는 변수는 파라미터로 따로 넘겨주어야 합니다. 
        &lt;jsp:include&gt;와 구분되는 특징은 외부 서버에 있는 url을 사용할 수 있다는 점입니다. 
        &lt;c:import url="" /&gt;는 외부 사이트에서 콘텐트를 가져올 때 사용하면 됩니다.

        - imports the content of a URL-based resource. Action may include nested &lt;c:param&gt;
        tags to specify the query string (unless the varReader attribute is specified).
    
        &lt;c:import url="includes/header.jsp"&gt;
            &lt;c:param name="title"&gt;Hello World&lt;/c:param&gt;
        &lt;/c:import&gt;

    ※ 같은 사이트에 있으면 &lt;jsp:include&gt;를 사용하고  다른 사이트에 있으면 &lt;c:import url="" /&gt;를 사용하면 됩니다.
             
       &lt;jsp:include&gt;액션 태그는 현재 위치에 무조건 결과를 출력하는 반면, 
       &lt;c:import&gt;태그는 EL변수에 보관한 뒤 필요에 따라 알맞은 처리를 할 수 있다.
    </pre>        
</div>

<div id="redirect_forward">
    <h4>forward  vs  redirect</h4>        
    <pre>
    &lt;jsp:forward page="" /&gt;
                    
        &lt;c:if test="${empty user}"&gt;
            &lt;jsp:forward page="pnRequestNewResult.jsp"&gt;
                &lt;jsp:param name="dateAdd" value="&lt;%= sdf.format(now) %&gt;"/&gt;
            &lt;/jsp:forward&gt;
        &lt;/c:if&gt;    
    
    &lt;c:redirect url="" /&gt;
        - sends the client a response to redirect to the specified URL. This action will abort 
        processing of the current page. Action may include nested &lt;c:param&gt; tags to specify the query string.
            
        &lt;c:if test="${empty user}"&gt;
            &lt;c:redirect url="login.do" &gt;
                &lt;c:param name="dateAdd" value="&lt;%= sdf.format(now) %&gt;"/&gt;
            &lt;c:redirect&gt;                
        &lt;/c:if&gt;
    </pre>        
</div>

</body>
</html>
