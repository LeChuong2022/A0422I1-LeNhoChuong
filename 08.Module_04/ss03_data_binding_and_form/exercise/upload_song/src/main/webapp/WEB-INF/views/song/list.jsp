<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Song</title>
</head>
<body>
<h1>List songs</h1>
<p>${mess}</p>
<a href="/song/upload">Upload song</a>
<table border="1">
    <tr>
        <th>No.</th>
        <th>Song's name</th>
        <th>Author</th>
        <th>Type</th>
        <th>Access Link</th>
    </tr>
    <c:forEach items="${song}" var="song" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${song.name}</td>
            <td>${song.author}</td>
            <td>${song.type}</td>
            <td><a href="${song.accessLink}">${song.accessLink}</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
