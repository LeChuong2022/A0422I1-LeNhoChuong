<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1>List students</h1>
<a href="/student/create">Create new student</a>
<p>${mess}</p>
<form action="/student/search" method="get">
    <input name="searchName" value="${searchName}"/>
    <button>Search</button>
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td><a href="/student/edit?id=${student.id}" name="id">${student.id}</a></td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
