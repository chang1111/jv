<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8" />
    <style>
        table, td, th {
            border: 1px solid green;
        }

        th {
            background-color: green;
            color: white;
        }
    </style>
    <script src="/resources/jquery-3.2.1.js"></script>
    <script>
        $(document).ready(function() {
            $("#writeone1").click(function(event) {
                $('form').attr('action', 'test1').submit();
            });
            $("#writeone2").click(function(event) {
                $('form').attr('action', 'test2').submit();
            });
            $("#writeone3").click(function(event) {
                $('form').attr('action', 'test3').submit();
            });
        });
    </script>
</head>
<body>
    <form action="???" method="post" enctype="application/x-www-form-urlencoded">
        <input type="text" name="name" size="50" placeholder="폰 이름" required="required" /> <br>
        <input type="text" name="manufacturer" size="50" placeholder="폰 제조사" required="required" /> <br>
        <input type="text" name="price" size="50" placeholder="폰 가격" required="required" /> <br>
        <input type="button" id="writeone1" value="getParameter" />
        <input type="button" id="writeone2" value="@RequestParam" />
        <input type="button" id="writeone3" value="@ModelAttribute" />
    </form>
    
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
