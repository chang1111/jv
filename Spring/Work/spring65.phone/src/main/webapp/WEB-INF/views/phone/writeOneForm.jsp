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
                $('form').attr('action', 'writeone1').submit();
            });
            $("#writeone2").click(function(event) {
                $('form').attr('action', 'writeone2').submit();
            });
            $("#writeone3").click(function(event) {
                $('form').attr('action', 'writeone3').submit();
            });
            $("#writeone4").click(function(event) {
                /* Act on the event */
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
        <input type="button" id="writeone2" value="@RequestParam" /> <br />
        <input type="button" id="writeone3" value="@ModelAttribute" />
        <input type="button" id="writeone4" value="Repository 패턴" /> <br />
    </form>
</body>
