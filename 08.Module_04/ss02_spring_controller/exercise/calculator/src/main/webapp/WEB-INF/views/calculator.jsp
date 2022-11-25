<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h4>Từ điển Anh Việt</h4>
<form method="post" action="/dictionary">
<p><b> English: </b><input type="text" placeholder="Enter a world"  id="inputEnglishWord" name="inputE" value="${inputE}"></p>
<input type="submit" value="Translate">
<p id="vietnamese"><b> Vietnamese:</b></p>
    <p>${result}</p>
</form>
</body>
</html>
