<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#"><img src="view/common/logo.png" alt="" style="height: 50px"/></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </div>
    <div style="width: 1200px; text-align: end">
        <h6 style="color: black">Lê Nho Chương </h6>
    </div>
</nav>

<nav class="navbar navbar-expand-lg navbar-light " style="background-color: #0f5132">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/home" style="color: white">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/employee" style="color: white">Employee</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/customer" style="color: white">Customer</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/service" style="color: white">Service</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="/contract" style="color: white">Contract</a>
            </li>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link" href="#">Link</a>--%>
            <%--            </li>--%>
            <%--            <li class="nav-item dropdown">--%>
            <%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown"--%>
            <%--                   aria-expanded="false">--%>
            <%--                    Dropdown--%>
            <%--                </a>--%>
            <%--                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">--%>
            <%--                    <li><a class="dropdown-item" href="#">Action</a></li>--%>
            <%--                    <li><a class="dropdown-item" href="#">Another action</a></li>--%>
            <%--                    <li>--%>
            <%--                        <hr class="dropdown-divider">--%>
            <%--                    </li>--%>
            <%--                    <li><a class="dropdown-item" href="#">Something else here</a></li>--%>
            <%--                </ul>--%>
            <%--            </li>--%>
            <%--            <li class="nav-item">--%>
            <%--                <a class="nav-link disabled">Disabled</a>--%>
            <%--            </li>--%>
        </ul>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit" style="color: white">Search</button>
        </form>
    </div>
</nav>