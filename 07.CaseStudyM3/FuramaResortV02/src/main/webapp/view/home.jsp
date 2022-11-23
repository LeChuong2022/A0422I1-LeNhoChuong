<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/7/2022
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/bootstrap-5.1.3-dist/css/bootstrap.css" rel="stylesheet">
    <script src="/bootstrap-5.1.3-dist/js/bootstrap.js"></script>
</head>
<body>
<%@ include file="common/header.jsp" %>

<%--main--%>
<div class="row">
    <div class="col-2">
        <div class="list-group" id="list-tab" role="tablist">
            <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list"
               href="#list-home" role="tab" aria-controls="list-home">Home</a>
            <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list"
               href="#list-profile" role="tab" aria-controls="list-profile">Profile</a>
            <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list"
               href="#list-messages" role="tab" aria-controls="list-messages">Messages</a>
            <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list"
               href="#list-settings" role="tab" aria-controls="list-settings">Settings</a>
        </div>
    </div>
    <div class="col-10" style="height: 1000px">
        <div class="tab-content" id="nav-tabContent">
            <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">aaa
            </div>
            <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list"><%@ include file="/view/employee/list.jsp" %>
            </div>
            <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">cccc
            </div>
            <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">ddđ</div>
        </div>
    </div>
</div>

<%--footer--%>
<%@ include file="common/footer.jsp" %>
</body>
</html>

