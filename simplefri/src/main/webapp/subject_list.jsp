<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08-Sep-23
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Subject List</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Subject Code</th>
            <th>Subject Title</th>
            <th>Subject Credit</th>
        </tr>
        <c:forEach items="${subjects}" var="subject">
            <tr>
                <td>${subject.id}</td>
                <td>${subject.title}</td>
                <td>${subject.credit}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
