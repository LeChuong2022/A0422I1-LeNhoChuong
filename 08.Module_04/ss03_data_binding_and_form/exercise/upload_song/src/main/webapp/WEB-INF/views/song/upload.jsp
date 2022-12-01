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
    <title>Upload new song</title>
</head>
<body>
<h4>Upload new song</h4>
<a href="/song/list">Back List</a>
<form:form action="/song/upload" method="post" modelAttribute="song">
    <table border="1">
        <tr>
            <td>Song's name:</td>
            <td><form:input type="text" path="name"/></td>
        </tr>
        <tr>
            <td>Author:</td>
            <td><form:input type="text" path="author"/></td>
        </tr>
        <tr>
            <td>Type:</td>
            <td><form:select type="text" path="type">
                <form:options items="${typeList}"></form:options>
            </form:select></td>
        </tr>
        <tr>
            <td>Access link:</td>
            <td><form:input type="text" path="accessLink"/></td>
        </tr>
    </table>
    <button type="submit" style="width: 60px; height: 30px">Save</button>
</form:form>
<h4>${mess}</h4>
<h4>${errorMap}</h4>

</body>
</html>
