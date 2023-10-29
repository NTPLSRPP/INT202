<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28-Oct-23
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Theme</title>
    <style>
        body {
            background-color: ${cookie.bgColor.value};
            color: ${cookie.txtColor.value};
        }
    </style>
</head>
<body>
    <h1>Color</h1>
    <hr>
    <h3>Select color ::</h3>
    <form action="set-theme" method="post">
        <c:forEach items="${requestScope.theme.colors}" var="color" varStatus="vs">
            <label style="background-color: ${color.bgColor}; color: ${color.txtColor}; border: 1px solid black;">
                <input type="radio" name="selectedColor" value="${vs.index}">${color.title}
            </label>
            <br>
        </c:forEach>
        <input type="submit" value="confirm">
    </form>
</body>
</html>
