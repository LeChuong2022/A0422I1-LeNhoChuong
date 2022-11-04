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
    <meta http–equiv=“Content-Type” content=“text/html; charset=UTF-8”>
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
            <td>${customer.getId()}</td>
            <td>${customer.getName()}</td>
            <td>${customer.getDayOfBirth()}</td>
            <td>${customer.getAddress()}</td>
            <td><img src="${customer.getPicture()}" width="50px" height="50px"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>