<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h1>Submitted Employee Informtion</h1>
<table border="1">
    <tr>
        <td>Name: </td>
        <th>${name}</th>
    </tr>
     <tr>
        <td>ID: </td>
        <th>${id}</th>
    </tr>
     <tr>
        <td>Contact Number: </td>
        <th>${contactNumber}</th>
    </tr>

</table>
</body>
</html>
