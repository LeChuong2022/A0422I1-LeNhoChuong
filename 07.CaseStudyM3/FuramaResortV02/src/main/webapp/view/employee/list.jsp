<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 10/19/2022
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
<%--    Link trên mạng của anh Chánh--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"--%>
<%--            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"--%>
<%--            crossorigin="anonymous"></script>--%>
    <%--    Link trên mạng của anh Chánh--%>
    <%--    Link offline--%>
    <link href="/bootstrap-5.1.3-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
    <%--    Link offline--%>


</head>
<body>
<%@ include file="../common/header.jsp" %>

<h1>Employee list</h1>
<div class="row">
    <div class="col-6">
        <%--form search--%>
        <form action="/employee" method="get">
            <input hidden type="text" name="action" value="search">
            <input type="text" name="searchName" placeholder="nhập tên" value="<c:out value='${searchName}'/>">
            <input type="text" name="searchUser" placeholder="nhập usser" value="<c:out value='${searchUser}'/>">
            <select name="searchPositionId">
                <option value="">Select position</option>
                <c:forEach var="position" items="${positionList}">
                    <option value="${position.positionId}" ${position.positionId ==  searchPositionId ? 'selected' : ''}> ${position.positionName}</option>
                </c:forEach>
            </select>

            <select name="searchEducationDegreeId">
                <option value="">Select education degree</option>
                <c:forEach var="ed" items="${educationDegreeModelList}">
                    <option value="${ed.educationDegreeId}" ${ed.educationDegreeId == searchEducationDegreeId ? 'selected' : '' }> ${ed.educationDegreeName}</option>
                </c:forEach>
            </select>

            <button type="submit">Search</button>
        </form>
        <%--form search--%>
    </div>
    <%--    Phân trang--%>
<%--    <div class="col-3">--%>
<%--        <form action="/employee" method="">--%>
<%--            <select name="page">--%>
<%--                <option value="">Select page</option>--%>
<%--                <option value="10" ${page == '10' ? 'selected' : ''}>10</option>--%>
<%--                <option value="20" ${page == '20' ? 'selected' : ''}>20</option>--%>
<%--            </select>--%>
<%--            <button type="submit">Pages</button>--%>
<%--        </form>--%>
<%--    </div>--%>
    <%--    Phân trang--%>
    <%--Sắp xếp theo thứ tự--%>
    <div class="col-3" style="text-align: end">
        <%--form sort--%>
        <form action="/employee" method="sort">
            <input hidden type="text" name="action" value="sort">
            <select name="sortType">
                <option value="">Select type</option>
                <option value="id" ${sortType == 'id' ? 'selected' : ''}>ID</option>
                <option value="name" ${sortType == 'name' ? 'selected' : ''}>Name</option>
                <option value="salary" ${sortType == 'salary' ? 'selected' : ''}>Salary</option>
                <option value="userName" ${sortType == 'userName' ? 'selected' : ''}>User name</option>
            </select>
            <button type="submit">Sort</button>
        </form>
        <%--form sort--%>
    </div>
</div>
<%--Sắp xếp theo thứ tự--%>


<a href="/employee?action=save">Create</a>
<c:if test="${mess !=null}">
    <span class="text-danger">${mess}</span>
</c:if>
<table class="table table-striped">
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Name</th>
        <th>Birthday</th>
        <th>Id Card</th>
        <th>Salary</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Position</th>
        <th>Education Degree</th>
        <th>Division</th>
        <th>UserName</th>
    </tr>
    <c:forEach var="employee" items="${employeeList}" varStatus="status">
        <%--        test thử phân trang --%>
        <c:if test="${( (page == 0) || (page<=10 && (status.count<=page))  || (page>10 && page<=20&& (status.count >10 && status.count<=20))) }">
            <%--        test thử test thử phân trang --%>
            <tr>
                <td>${status.count}</td>
                <td>${employee.getId()}</td>
                <td>${employee.getName()}</td>
                <td>${employee.getBirthday()}</td>
                <td>${employee.getIdCard()}</td>
                <td>${employee.getSalary()}</td>
                <td>${employee.getPhone()}</td>
                <td>${employee.getEmail()}</td>
                <td>${employee.getAddress()}</td>

                <c:forEach var="position" items="${positionList}">
                    <c:if test="${position.positionId==employee.getPositionId()}">
                        <td>${position.positionName}</td>
                    </c:if>
                </c:forEach>

                <c:forEach var="educationDegree" items="${educationDegreeModelList}">
                    <c:if test="${educationDegree.educationDegreeId==employee.getEducationDegreeId()}">
                        <td>${educationDegree.educationDegreeName}</td>
                    </c:if>
                </c:forEach>
                <c:forEach var="division" items="${divisionModelList}">
                    <c:if test="${division.divisionId==employee.getDivisionId()}">
                        <td>${division.divisionName}</td>
                    </c:if>
                </c:forEach>

                    <%--            <td>${employee.getEducationDegreeId()}</td>--%>
                <td>${employee.getUserName()}</td>
                    <%--            <c:if test="${student.isGender()}">--%>
                    <%--                <td>Nam</td>--%>
                    <%--            </c:if>--%>
                    <%--            <c:if test="${!student.isGender()}">--%>
                    <%--                <td>Nữ</td>--%>
                    <%--            </c:if>--%>
                    <%--            <td>${student.getBirthday()}</td>--%>
                    <%--            <td>${student.getPoint()}</td>--%>

                    <%--            <c:choose>--%>
                    <%--                <c:when test="${student.getPoint()>=8}">--%>
                    <%--                    <td>Giỏi</td>--%>
                    <%--                </c:when>--%>
                    <%--                <c:when test="${student.getPoint()>=7}">--%>
                    <%--                    <td>Khá</td>--%>
                    <%--                </c:when>--%>
                    <%--                <c:when test="${student.getPoint()>=5}">--%>
                    <%--                    <td>trung bình</td>--%>
                    <%--                </c:when>--%>
                    <%--                <c:otherwise>--%>
                    <%--                    <td>Yêu sắc yếu</td>--%>
                    <%--                </c:otherwise>--%>
                    <%--            </c:choose>--%>

                    <%--            <td>${student.getAccount()}</td>--%>
                    <%--            <c:if test="${student.getClassId()==0}">--%>
                    <%--                <td></td>--%>
                    <%--            </c:if>--%>
                    <%--            <c:if test="${student.getClassId()!=0}">--%>

                    <%--                <c:forEach var="cls" items="${classList}">--%>
                    <%--                    <c:if test="${cls.id==student.getClassId()}">--%>
                    <%--                        <td>${cls.name}</td>--%>
                    <%--                    </c:if>--%>

                    <%--                </c:forEach>--%>
                    <%--            </c:if>--%>
                    <%--            <td>${student.getEmail()}</td>--%>
                <td>
                    <button type="button" onclick="infoDelete('${employee.getId()}','${employee.getName()}')"
                            class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                        Delete
                    </button>
                </td>
                <td>
                    <button type="button"
                            onclick="location.href='http://localhost:8080/employee?action=edit&id=${employee.getId()}';"
                            class="btn btn-primary">
                        Edit
                    </button>
                </td>
            </tr>
            <%--        test thử --%>
        </c:if>
        <%--        test thử --%>

    </c:forEach>

</table>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/employee" method="get">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input name="action" value="delete" hidden>
                    <input name="deleteId" id="deleteId" hidden>
                    <span class="text-danger">Bạn có muốn xoá sinh viên </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--<div class="modal fade" id="exampleModalEdit" tabindex="-1" aria-labelledby="exampleModalEditLabel" aria-hidden="true">--%>
<%--    <div class="modal-dialog">--%>
<%--        <form action="/employee" method="get">--%>
<%--            <div class="modal-content">--%>
<%--                <div class="modal-header">--%>
<%--                    <h5 class="modal-title" id="exampleModalEditLabel">Modal title</h5>--%>
<%--                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>--%>
<%--                </div>--%>
<%--                <div class="modal-body">--%>
<%--                    <input name="action" value="edit" hidden>--%>
<%--                    <input name="deleteId" id="editId" hidden>--%>
<%--                    <span class="text-danger">Bạn có sửa nhân viên này không? </span><span id="editName"></span>--%>
<%--                </div>--%>
<%--                <div class="modal-footer">--%>
<%--                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                    <button type="submit" class="btn btn-primary">Delete</button>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>
<%--    </div>--%>
<%--</div>--%>

<script>
    function infoDelete(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }

    // function infoEdit(id, name) {
    //     document.getElementById("deleteName").innerText = name;
    //     document.getElementById("edId").value = id;
    // }
</script>
<%--Phân trang--%>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <li class="page-item"><a class="page-link" href="${page == 30 ? '/employee?page=20' : (page == 20 ? '/employee?page=10' : (page == 10 ? '/employee?page=10' : '' ))}">Previous</a></li>
        <li class="page-item"><a class="page-link" href="/employee?page=10">1</a></li>
        <li class="page-item"><a class="page-link" href="/employee?page=20">2</a></li>
        <li class="page-item"><a class="page-link" href="/employee?page=30">3</a></li>
        <li class="page-item"><a class="page-link" href="${page == 10 ? '/employee?page=20' : (page == 20 ? '/employee?page=30' : (page == 30 ? '/employee?page=30' : '' ))}">Next</a></li>
    </ul>
</nav>

<%--Phân trang--%>

<%--footer--%>
<%@ include file="../common/footer.jsp" %>
</body>
</html>
