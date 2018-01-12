<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="utf-8" />
    <title>file upload demo</title>
    <script src="/resources/jquery-3.2.1.js"></script>
    <script>
        <!-- jquery 로 파일 첨부 input 태그 추가 -->
        $(document).ready(function() {
            //add more file components if Add is clicked
            $('#addFile').click(function() {
                var fileIndex = $('#fileview tr').children().length;
                $('#fileview').append(
                    '<tr><td><span class="deletefile">X</span>' +
                    ' <input type="file" name="files['+ fileIndex +']" />' +
                    '</td></tr>'
                );
            });
            $('#fileview').on('click', '.deletefile', function() {
                $(this).parent().remove();
            });
        });
    </script>
</head>
<body>
    <h3>Spring Single File Upload</h3>
    <form method="post" action="./fileuploadone" enctype="multipart/form-data">
        
        Upload Directory : 
        <input type="text" name="upDir" value="c:/upload/" />
        <br />
        <br />
        <input type="file" name="file" />
        <br />
        <input type="submit" id="uploadone" value="Upload One" />
    </form>
    
    <hr>
    
    <h3>Spring Multi File Upload</h3>
    <form method="post" action="./fileuploadmulti" enctype="multipart/form-data">
        
        Upload Directory :
        <input type="text" name="upDir" value="c:/upload/" />
        <br />
        <br />
        <input type="button" id="addFile" value="File Add" />
        
        <table id="fileview">
            <tr>
                <td>
                    <span class="deletefile">X</span>
                    <input type="file" name="files[0]" />
                </td>
            </tr>
        </table>
        <br /> <input type="submit" id="uploadmulti"
            value="Upload Multi" />
    </form>
    <hr>
    <h3>Drag &amp; Drop Multi File Upload</h3>
    <form method="post" action="" modelAttribute="uploadForm"
        enctype="multipart/formdata"></form>
</body>
</html>