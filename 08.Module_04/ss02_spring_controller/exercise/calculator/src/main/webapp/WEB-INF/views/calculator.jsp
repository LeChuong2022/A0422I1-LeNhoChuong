<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h4>Calculator</h4>
<form method="post" action="/calculator">
<p><input type="text" placeholder="Enter a number"  name="number1" value="${number1}">
    <input type="text" placeholder="Enter a number"  name="number2" value="${number2}"></p>
<input type="submit" name="cal" value="Addition(+)">
    <input type="submit" name="cal" value="Subtraction(-)">
    <input type="submit" name="cal" value="Multiplication(*)">
    <input type="submit" name="cal" value="Division(/)">
<p><b> Result:</b> ${result}</p>
</form>
</body>
</html>
