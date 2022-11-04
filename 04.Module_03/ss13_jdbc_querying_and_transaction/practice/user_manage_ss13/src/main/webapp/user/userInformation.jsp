<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/31/2022
  Time: 11:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Information</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="get">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    User information in <c:out value='${user.country}'/>
                </h2>
            </caption>
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}'/>"/>
            </c:if>
            <tr>
                <th>ID</th>
                <th>User Name</th>
                <th>User Email</th>
                <th>Country</th>
            </tr>
            <c:forEach var="user" items="${userByCountry}">
                <tr>
                    <td>
                        <p><c:out value='${user.id}'/></p>
                    </td>
                    <td>
                        <p><c:out value='${user.name}'/></p>
                    </td>
                    <td>
                        <p><c:out value='${user.email}'/></p>
                    </td>
                    <td>
                        <p><c:out value='${user.country}'/></p>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </form>
</div>
</body>
</html>
