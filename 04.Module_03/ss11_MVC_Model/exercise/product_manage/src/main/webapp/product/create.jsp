<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/29/2022
  Time: 6:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<style>
    .message {
        color: red;
    }
</style>
<body>
<h1>Create new product</h1>
<p><c:if test="${requestScope['message']!=null}">
    <span class="message">${requestScope['message']}</span>
</c:if></p>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" id="name"></td>
            </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price" id="price"></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="number" name="quantity" id="quantity"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save product"></td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
