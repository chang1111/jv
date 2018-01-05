<%@ page session="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="utf-8" /> 
    <title>Home</title>
</head>
<body>  
    <p>  The time on the server is ${serverTime}. </p>
      

    <h2> HomeController </h2> 
    <a href="spring/helloworld" target="_blank">/spring/helloworld</a> <br />
    <a href="spring/sayhello" target="_blank">/spring/sayhello</a> <br />  
    <hr />
    
    <a href="spring/redirect" target="_blank">/spring/helloworld redirect 테스트</a> <br />
    <a href="spring/forward" target="_blank">/spring/helloworld forward 테스트</a> <br />
    <hr>
    
    <a href="spring/querystring?name=test&price=1244" target="_blank">/spring/querystring?name=test&phone=1244</a> <br />
    <a href="spring/querystring2?name=qna&price=200" target="_blank">/spring/querystring?name=qna&phone=200</a> <br />
    <a href="spring/querypath/test" target="_blank">/spring/querypath/test</a> <br />
    <a href="spring/pathvalue/test/1244" target="_blank">/spring/pathvalue/test/1244</a> <br />
    <hr />
    
    <a href="spring/login" target="_blank">@RequestParam 을 이용한 /spring/login</a> <br /> 
    <hr>
    
    <a href="spring/loginmodel" target="_blank">@ModelAttribute 를 이용한 /spring/login</a> <br /> 
    <hr>
    
    <h2> PhoneController </h2> 
    <a href="/phone/writeone" target="_blank">/phone/writeone</a> <br />
    <a href="/phone/writelist" target="_blank">/phone/writelist</a> <br />
    <hr>
    
    <h2> RestController </h2> 
    <a href="/rest/ajaxone"   target="_blank">/rest/ajaxone </a> <br />
    <a href="/rest/ajaxlist"  target="_blank">/rest/ajaxlist</a> <br />
    <a href="/rest/newversion"   target="_blank">/rest/newversion </a> <br />
    <a href="/rest/uploadimage"  target="_blank">/rest/uploadimage</a> <br />
    <hr>
    
    
    <h2> UploadController, DownloadController 만들기 </h2>
    <a href="./upload/fileupload"    target="_blank">./upload/fileupload </a> <br> 
    <a href="./upload/filedownload"  target="_blank">./upload/filedownload </a> <br>
    <hr />
    
    <h2> 테이블의 BLOB,CLOB 컬럼에 이미지 저장하고 가져오기</h2>   
    <a href="./upload/imageupload"   target="_blank">./upload/imageupload </a> <br>
    <a href="./upload/imageview/1"   target="_blank">./upload/imageview/1 </a> <br>
    <hr>
    
    <h2> PersonController </h2>
    <a href="/person/" target="_blank">/person/ </a> <br />  
    <hr>
        
</body>
</html>
