<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28-Oct-23
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <style>
        body {
            background-color: ${cookie.bgColor.value};
            color: ${cookie.txtColor.value};
        }
        a {
            color: ${cookie.txtColor.value};
        }
    </style>
</head>
<body>
    <h1>Result</h1>
    <hr>
    <h2>Your score is ${requestScope.score}</h2>
    <a href="reset-quiz">reset</a>
</body>
</html>
