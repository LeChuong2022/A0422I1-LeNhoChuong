<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/26/2022
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit student</title>
</head>
<body>
<h4>Edit student</h4>
<a href="/student/list">Back List</a>
<form action="/student/edit" method="post">
    <table border="1">
        <tr>
            <td>ID:</td>
            <td><input type="text" name="id" value="${student.id}"/></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${student.name}"/></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><input type="text" name="age" value="${student.age}"/></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="${student.address}"/></td>
        </tr>
    </table>
    <button type="submit" style="width: 60px; height: 30px">Save</button>
</form>

</body>
</html>
