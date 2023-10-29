<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 28-Oct-23
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz</title>
    <style>
        body {
            background-color: ${cookie.bgColor.value};
            color: ${cookie.txtColor.value};
        }
    </style>
</head>
<body>
    <h1>Quiz</h1>
    <br>
    <h3>${requestScope.currentQuestion.title}</h3> <%-- get data from request --%>
    <c:if test="${!requestScope.isAnswer}">
        <p style="color: red">Please select option</p>
    </c:if>
    <form action="quiz-controller" method="post"> <%-- used to map a controller and select doGet or doPost --%>
        <c:forEach items="${requestScope.currentQuestion.options}" var="option" varStatus="vs"> <%-- loop a list of options --%>
            <label>
                <input type="radio" name="option" value="${vs.index}">${option}
            </label>
            <br>
        </c:forEach>
        <input type="submit" value="send"> <%-- submit data to controller --%>
    </form>
</body>
</html>
