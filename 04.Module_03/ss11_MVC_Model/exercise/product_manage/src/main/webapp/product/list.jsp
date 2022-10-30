<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/27/2022
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Products list</title>
</head>
<body>
<h1>Products List</h1>
<p><a href="/products?action=create">Create new product</a></p>
<form >
    <p>Find product:
        <input name="action" value="search" type="hidden">
        <input type="text" name="search" id="search">
        <input type="submit" value="search">
    </p>
</form>

<table border="1">
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>

    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td>${product.getId()}</td>
            <td><a href="/products?action=view&id=${product.getId()-1}">${product.getName()}</a></td>
            <td>${product.getPrice()}</td>
            <td>${product.getQuantity()}</td>
            <td><a href="/products?action=edit&id=${product.getId()-1}">edit</a></td>
            <td><a href="/products?action=delete&id=${product.getId()-1}">delete</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
