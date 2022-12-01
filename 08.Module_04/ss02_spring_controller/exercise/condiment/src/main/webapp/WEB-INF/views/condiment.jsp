<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Condiments</title>
</head>
<body>
<h4>Sandwich Condiments</h4>
<form method="post" action="/condiment">
        <p><input type="checkbox" name="condiment" value="Lettuce"
        <c:forEach var="condiment" items="${condimentList}">
            ${condiment.equals("Lettuce") ? "checked='checked'" : ""}
        </c:forEach>
        >Lettuce</p>

        <p><input type="checkbox" name="condiment" value="Tomato"
        <c:forEach var="condiment" items="${condimentList}">
            ${condiment.equals("Tomato") ? "checked='checked'" : ""}
        </c:forEach>
        >Tomato</p>

        <p><input type="checkbox" name="condiment" value="Mustard"
        <c:forEach var="condiment" items="${condimentList}">
            ${condiment.equals("Mustard") ? "checked='checked'" : ""}
        </c:forEach>
        >Mustard</p>

        <p><input type="checkbox" name="condiment" value="Sprouts"
        <c:forEach var="condiment" items="${condimentList}">
            ${condiment.equals("Sprouts") ? "checked='checked'" : ""}
        </c:forEach>
        >Sprouts</p>


<input type="submit" value="Save">
    <p><c:if test="${result!=null}">
       Condiments were selected: ${result}
    </c:if></p>
</form>

</body>
</html>
