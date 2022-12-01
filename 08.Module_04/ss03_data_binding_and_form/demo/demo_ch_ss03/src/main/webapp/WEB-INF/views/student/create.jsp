<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/26/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new student</title>
</head>
<body>
<h4>Create new student</h4>
<a href="/student/list">Back List</a>
<form:form action="/student/create" method="post" modelAttribute="student">
    <table border="1">
        <tr>
            <td>ID:</td>
            <td><form:input type="text" path="id"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><form:input type="text" path="age"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><form:input type="text" path="address"/></td>
        </tr>
    </table>
    <button type="submit" style="width: 60px; height: 30px">Save</button>
</form:form>

</body>
</html>
