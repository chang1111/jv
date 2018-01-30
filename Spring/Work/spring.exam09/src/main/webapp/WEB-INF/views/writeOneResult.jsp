<%@ page session="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="utf-8" /> 
    <style>
        table, td, th { border: 1px solid green; }        
        th { background-color: green; color: white; }
    </style>
</head>
<body>
    
    <table>
        <tr>
            <th>no</th>
            <th>name</th>
            <th>manufacturer</th>
            <th>price</th>
        </tr>   

        <c:forEach var="phone" items="${phone }" varStatus="status"> 
        <tr>
            <td>${status.index + 1}</td>
            <td>${phone.phname}</td>
            <td>${phone.phfactory}</td>
            <td>${phone.phprice}</td>
        </tr>
        </c:forEach>
    </table> 

</body>
</html>