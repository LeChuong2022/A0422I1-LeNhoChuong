<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/25/2022
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<%--<c:redirect url="calculator"></c:redirect>--%>

<h1>Simple Calculator</h1>
<form method="get" action="/calculate">
  <table>
    <tr>
      <td>First operand</td>
      <td><input type="text" name="firstOperand"></td>
    </tr>
    <tr>
      <td>Operator</td>
      <td><select name="cal">
        <option>Add</option>
        <option>Sub</option>
        <option>Mul</option>
        <option>Div</option>
      </select></td>
    </tr>
    <tr>
      <td>Second operand</td>
      <td><input type="text" name="secondOperand"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" id="submit" value="Calculate"></td>
    </tr>
  </table>
</form>
</body>
</html>
