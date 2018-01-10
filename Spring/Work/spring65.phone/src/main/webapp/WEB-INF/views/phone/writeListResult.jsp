<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
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
        <!-- 반복 구간 시작 -->
        <c:forEach var="phone" items="${list}" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${phone.name}</td>
                <td>${phone.manufacturer}</td>
                <td>${phone.price}</td>
            </tr>
        </c:forEach>
        <!-- 반복 구간 끝 -->
    </table>
</body>
</html>