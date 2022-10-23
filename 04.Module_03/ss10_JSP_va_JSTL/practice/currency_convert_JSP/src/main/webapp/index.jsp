<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/22/2022
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>currency convert JSP</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Convert</h2>
<form method="get" action="converter.jsp">
    <label>Rate: </label><br/>
    <input type="text" name="rate" value="22000" placeholder="RATE"/> <br/>
    <label>USD: </label><br/>
    <input type="text" name="usd" value="0" placeholder="USD"> <br/>
    <input type="submit" id="submit" value="Convert"/>
</form>
</body>
</html>
