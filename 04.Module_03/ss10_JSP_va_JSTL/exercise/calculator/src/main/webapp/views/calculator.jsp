<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10/25/2022
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>calculator</title>
</head>
<body>
<h2>Result</h2>
<% float firstOperand = Float.parseFloat(request.getParameter("firstOperand"));
    float secondOperand = Float.parseFloat(request.getParameter("secondOperand"));
%>
<c:choose>
    <c:when test="${param.cal == 'Add'}">
        <p><%=firstOperand%> + <%=secondOperand%> = <%=firstOperand + secondOperand%></p>
    </c:when>
    <c:when test="${param.cal == 'Sub'}">
        <p><%=firstOperand%> - <%=secondOperand%> = <%=firstOperand - secondOperand%></p>
    </c:when>
    <c:when test="${param.cal == 'Mul'}">
        <p><%=firstOperand%> * <%=secondOperand%> = <%=firstOperand * secondOperand%></p>
    </c:when>
    <c:when test="${param.cal == 'Div'}">
        <p><%=firstOperand%> / <%=secondOperand%> = <%=firstOperand / secondOperand%></p>
    </c:when>

</c:choose>

</body>
</html>
