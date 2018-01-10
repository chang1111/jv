<%@ page session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta charset="utf-8" />
    <title>테이블 컬럼에 이미지 저장하는 예제</title>
</head>
<body>
    <form action="/upload/imageupload" enctype="multipart/form-data" method="post">
        Upload Directory :
        <input type="text" name="upDir" value="c:/upload/" />
        <br />
        <br />
        <input type="file" name="image" />
        <br />
        <input type="submit" value="이미지저장" />
    </form>
</body>
</html>