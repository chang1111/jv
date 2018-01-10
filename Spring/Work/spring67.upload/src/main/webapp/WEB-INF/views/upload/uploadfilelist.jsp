<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <style>
        table, td, th { border: 1px solid green; }
        th { background-color: green; color: white; }
    </style>
    <script>
        var download = function download(filenametemp, filenameorig) {
            var f = document.createElement('form');
            f.style.visibility = "hidden";
            f.setAttribute('method','post');
            f.setAttribute('action','/download');
            f.setAttribute('enctype','application/x-www-form-urlencoded');
            document.body.appendChild(f);
            var i = document.createElement('input'); //input element, text
            i.type = 'text';
            i.name = 'filenametemp';
            i.value = filenametemp;
            f.appendChild(i);
            var i = document.createElement('input'); //input element, text
            i.type = 'text';
            i.name = 'filenameorig';
            i.value = filenameorig;
            f.appendChild(i);
            f.submit();
        };
    </script>
</head>
<body>
    <table>
        <tr>
            <th>no</th>
            <th>fileNameOrig</th>
            <th>fileNameTemp</th>
            <th>download </th>
        </tr>
        <!-- 반복 구간 시작 -->
        <c:forEach var="file" items="${files }" varStatus="status">
            <tr>
                <td>${file.uploadFileNo}</td>
                <td>${file.fileNameOrig}</td>
                <td>${file.fileNameTemp}</td>
                <td><a href="javascript:download('${file.fileNameTemp }',
                '${file.fileNameOrig }')">download</a></td>
            </tr>
        </c:forEach>
        <!-- 반복 구간 끝 -->
    </table>
</body>
</html>
