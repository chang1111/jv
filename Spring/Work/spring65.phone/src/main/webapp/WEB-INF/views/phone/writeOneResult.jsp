<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
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
            <th>name</th>
            <th>manufacturer</th>
            <th>price</th>
        </tr>
        <tr>
            <td>${phone.name}</td>
            <td>${phone.manufacturer}</td>
            <td>${phone.price}</td>
        </tr>
    </table>
</body>
</html>