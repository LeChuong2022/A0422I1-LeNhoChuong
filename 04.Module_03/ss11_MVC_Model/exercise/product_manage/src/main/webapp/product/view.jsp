<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/29/2022
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<P>
    <c:if test="${requestScope['message']}!= null">
        <span class="message">${requestScope['message']}</span>
    </c:if>
</P>

<table>
    <tr>
        <td>Name:</td>
        <td>${requestScope['product'].getName()}</td>
    </tr>
    <tr>
        <td>Price:</td>
        <td>${requestScope['product'].getPrice()}</td>
    </tr>
    <tr>
        <td>Quantity:</td>
        <td>${requestScope['product'].getQuantity()}</td>
    </tr>
</table>

</body>
</html>
