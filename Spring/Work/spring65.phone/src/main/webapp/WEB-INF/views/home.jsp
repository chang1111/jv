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
     
    
    <h2> PhoneController </h2> 
    <a href="/phone/writeone" target="_blank">/phone/writeone</a> <br />
    <a href="/phone/writelist" target="_blank">/phone/writelist</a> <br />
    <hr>
       
</body>
</html>
