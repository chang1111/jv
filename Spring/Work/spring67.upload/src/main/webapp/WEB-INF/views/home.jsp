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
      
    <h2> UploadController, DownloadController 만들기 </h2>
    <a href="./upload/fileupload"    target="_blank">./upload/fileupload </a> <br> 
    <a href="./upload/filedownload"  target="_blank">./upload/filedownload </a> <br>
    <hr />
    
    <h2> 테이블의 BLOB,CLOB 컬럼에 이미지 저장하고 가져오기</h2>   
    <a href="./upload/imageupload"   target="_blank">./upload/imageupload </a> <br>
    <a href="./upload/imageview/1"   target="_blank">./upload/imageview/1 </a> <br>
    <hr>
       
</body>
</html>
