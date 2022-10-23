<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/22/2022
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>product discount calculator</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  <body>
  <h1>Product discount calculator</h1>
  <form action="\discount" method="get">
    <label>Product description: </label><br/>
    <input type="text" name="productDescription" placeholder="product description"/><br/>
    <label>List Price: </label><br/>
    <input type="text" name="listPrice" placeholder="price"> <br/>
    <label>Discount percent: </label><br/>
    <input type="text" name="discountPercent" placeholder="discount percent">
    <input type="submit" id="submit" value="Calculation Discount">
  </form>
  </body>
</html>
