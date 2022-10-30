<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/29/2022
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<h1>Delete product</h1>
<p><a href="/products">Back to product list</a></p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope['product'].getName()}</td>
            </tr>
            <tr>
                <td>Price: </td>
                <td>${requestScope['product'].getPrice()}</td>
            </tr>
            <tr>
                <td>Quantity: </td>
                <td>${requestScope['product'].getQuantity()}</td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/products">Back to product list</a> </td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
