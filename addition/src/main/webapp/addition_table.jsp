<%--
  Created by IntelliJ IDEA.
  User: RapBitch
  Date: 10/29/2023
  Time: 10:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Addition_Table</title>
</head>
<body>
    <h3>Addition Table::</h3>
    <hr>
    <c:choose>
        <c:when test="${param.number1 == null || param.number2 == null}">
            <h3 style="color: red">Error: Please provide valid numbers for addition.
                (number 1: ${param.number1 == null || "" ? "Null/Empty" : param.number1},
                number 2: ${param.number2 == null || "" ? "Null/Empty" : param.number2})
            </h3>
        </c:when>
        <c:otherwise>
            <table>
                <tr>
                    <td colspan="5" style="background-color: aquamarine">Sum of ${param.number1} and ${param.number2}</td>
                </tr>
                <c:forEach begin="1" end="1" var="n">
                    <tr>
                        <td class="number">${param.number1}</td>
                        <td>+</td>
                        <td class="number">${param.number2}</td>
                        <td>=</td>
                        <td class="number">${param.number1 + param.number2}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</body>
</html>
