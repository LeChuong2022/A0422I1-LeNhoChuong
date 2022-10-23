<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/23/2022
  Time: 11:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer list</title>
</head>
<body>
<h1>Customer list</h1>
<table border="1">
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Day of birth</th>
        <th>Address</th>
        <th>Picture</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${status.getID}</td>
            <td>${status.getName}</td>
            <td>${status.getDayOfBirth}</td>
            <td>${status.getAddress}</td>
            <td>${status.getPicture}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
