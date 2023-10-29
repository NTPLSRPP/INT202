<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 9/22/2023
  Time: 11:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MultiplicationTable</title>
    <style>
        td {
            border-spacing: 0px;
            padding: 0px;
            height: 16px;
            text-align: center;
            width: 20%;
        }
        table {
            border: 1px solid darkcyan;
            width: 20%;
        }
        .number {
            text-align: center;
            padding-left: 12px;
        }
    </style>
</head>
<body>
<h3>Multiplication Table::</h3><hr>

<c:if test="${error == null}">
    <table>
        <tr>
            <td colspan="5" style="background-color: cadetblue"> MT for ${param.number}</td>
        </tr>
        <c:forEach begin="1" end="12" var="n">
            <c:choose>
                <c:when test="${n%3==1}">
                    <c:set var="bg" scope="page" value="white"/>
                </c:when>
                <c:when test="${n%3==2}">
                    <c:set var="bg" scope="page" value="lightgray"/>
                </c:when>
                <c:otherwise>
                    <c:set var="bg" scope="page" value="gray"/>
                </c:otherwise>
            </c:choose>
            <tr style="background-color: ${bg}">
                <td class="number"> ${param.number}</td>
                <td> x </td>
                <td class="number"> ${n} </td>
                <td> = </td>
                <td class="number"> ${param.number * n} </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${error != null}">
    <h3 style="color: red">
        Error: ${requestScope.error}
        (${param.number == null || param.number == '' ? "Null/Empty" : param.number})
    </h3>
</c:if>

</body>
</html>
