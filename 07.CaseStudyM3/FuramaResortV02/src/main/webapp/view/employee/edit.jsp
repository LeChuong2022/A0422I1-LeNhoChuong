<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 10/21/2022
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="row">
    <div class="col-1"></div>
    <div class="col-11">
        <%--        Sửa so với create --%>
        <h1>Edit employee ${employee.name} </h1>
        <a href="/employee">Back list</a>
        <p>${mess}</p>
        <%--        Sửa so với create --%>

        <form action="/employee?action=edit" method="post">
                    <pre hidden>ID:   <input type="text" name="id" value="<c:out value='${employee.id}'/>"/></pre>
            <pre>User name:    <input type="text" name="user" value="<c:out value='${employee.userName}'/> " disabled/> </pre>
            <pre>Name:     <input type=" text" name="name" value="<c:out value='${employee.name}'/>"/> </pre>
            <%--    <pre>Gender :  <input type="radio" name="gender" value="true">Nam <input type="radio" value="false" name="gender"> Nữ </pre>--%>
            <pre>Birthday: <input type="date" name="birthday" value="<c:out value='${employee.birthday}'/>"/> </pre>
            <pre>Id card: <input type=" text" name="idCard" value="<c:out value='${employee.idCard}'/>"/> </pre>
            <pre>Salary:    <input type="text" name="salary" value="<c:out value='${employee.salary}'/>"/> </pre>
            <pre>Phone:    <input type=" text" name="phone" value="<c:out value='${employee.phone}'/>"/> </pre>
            <%--    <pre>Account:  <input type="text" name="account"> </pre>--%>
            <pre>Email:    <input type="text" name="email" value="<c:out value='${employee.email}'/>"/> </pre>
            <pre>Address:    <input type=" text" name="address" value="<c:out value='${employee.address}'/>"> </pre>
            <pre>Position id:  <select name="positionId">
                     <option value="">Select position</option>
                          <c:forEach var="position" items="${positionList}">
                              <%--                              <option value="${position.positionId}" ${position.positionId == employee.positionId ? 'selected' : ''}>${position.positionName}</option>--%>
                              <%--                              <option value="${position.positionId}" > ${position.positionName}</option>--%>
                              <option value="${position.positionId}" ${position.positionId == employee.positionId ? 'selected' : '' }> ${position.positionName}</option>

                          </c:forEach>
                </select>
            </pre>
            <pre>Education Degree id:  <select name="educationDegreeId">
                     <option value="">Select education degree</option>
                          <c:forEach var="ed" items="${educationDegreeList}">
                              <option value="${ed.educationDegreeId}" ${ed.educationDegreeId == employee.positionId ? 'selected' : '' }> ${ed.educationDegreeName}</option>
                          </c:forEach>
                    </select>
    </pre>
            <pre>Division id:  <select name="divisionId">
                     <option value="">Select division</option>
                          <c:forEach var="division" items="${divisionList}">
                              <option value="${division.divisionId}" ${division.divisionId == employee.positionId ? 'selected' : '' }> ${division.divisionName}</option>
                          </c:forEach>
                    </select>
    </pre>

            <pre>           <button>Save</button></pre>
        </form>


    </div>


</div>

<%@ include file="../common/footer.jsp" %>

</body>
</html>
