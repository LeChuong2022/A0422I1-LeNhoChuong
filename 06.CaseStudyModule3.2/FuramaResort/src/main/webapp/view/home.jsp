<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/6/2022
  Time: 1:51 PM
  To change this template use File | Settings | File Templates.
--%>

<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Home</title>
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />


<%--    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>--%>
<%--    <link href="<c:url value='template/css/bootstrap.min.css'/>" rel="stylesheet"/>--%>
<%--    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>--%>

    <%--    --%>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- favicon
		============================================ -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
    <!-- Google Fonts
		============================================ -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/bootstrap.min.css'/>">
    <!-- Bootstrap CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/font-awesome.min.css' />">
    <!-- owl.carousel CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/owl.carousel.css' />">
    <link rel="stylesheet" href="<c:url value='template/css/owl.theme.css' />">
    <link rel="stylesheet" href="<c:url value='template/css/owl.transitions.css' />">
    <!-- meanmenu CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/meanmenu/meanmenu.min.css' />">
    <!-- animate CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/animate.css' />">
    <!-- normalize CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/normalize.css'/>">
    <!-- mCustomScrollbar CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/scrollbar/jquery.mCustomScrollbar.min.css'/>">
    <!-- jvectormap CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/jvectormap/jquery-jvectormap-2.0.3.css'/>">
    <!-- notika icon CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/notika-custom-icon.css'/>">
    <!-- wave CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/wave/waves.min.css'/>">
    <!-- main CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/main.css'/>">
    <!-- style CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/style.css'/>">
    <!-- responsive CSS
		============================================ -->
    <link rel="stylesheet" href="<c:url value='template/css/responsive.css'/>">
    <!-- modernizr JS
		============================================ -->
    <script src="<c:url value='template/js/vendor/modernizr-2.8.3.min.js'/>"></script>

</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="row" style="height: 1000px">
<div class="border-end bg-white col-lg-2 col-md-2 col-sm-2 col-xs-2" id="sidebar-wrapper" >
    <div class="list-group list-group-flush">
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Item1</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Item2</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Item3</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Item4</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Item5</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Item6</a>
    </div>
</div>
</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>
