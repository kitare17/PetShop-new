<%-- 
    Document   : header
    Created on : Feb 18, 2023, 11:46:07 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PET SHOP</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="img/favicon.ico" rel="icon">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
    <!-- Google Web Fonts -->
    <!--        <link rel="preconnect" href="https://fonts.gstatic.com">-->
    <link href="https://fonts.googleapis.com/css2?family=Poppins&family=Roboto:wght@700&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
    <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/pluscharts.css">
    <script src="https://d3js.org/d3.v5.min.js"></script>
    <script src="dist/pluscharts.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>



</head>
<body>
<!-- Topbar Start -->
<div class="container-fluid border-bottom d-none d-lg-block">
    <div class="row gx-0">
        <div class="col-lg-4 text-center py-2">
            <div class="d-inline-flex align-items-center">
                <i class="bi bi-geo-alt fs-1 text-primary me-3"></i>
                <div class="text-start">
                    <h6 class="text-uppercase mb-1">Địa chỉ</h6>
                    <span>Số 123, Đà Nẵng, Việt Nam</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4 text-center border-start border-end py-2">
            <div class="d-inline-flex align-items-center">
                <i class="bi bi-envelope-open fs-1 text-primary me-3"></i>
                <div class="text-start">
                    <h6 class="text-uppercase mb-1">Địa chỉ email</h6>
                    <span>info@fpt.edu.vn</span>
                </div>
            </div>
        </div>
        <div class="col-lg-4 text-center py-2">
            <div class="d-inline-flex align-items-center">
                <i class="bi bi-phone-vibrate fs-1 text-primary me-3"></i>
                <div class="text-start">
                    <h6 class="text-uppercase mb-1">Số điện thoại liên hệ</h6>
                    <span>+012 345 6789</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Topbar End -->


<!-- Navbar Start -->
<nav class="navbar navbar-expand-lg bg-white navbar-light shadow-sm py-3 py-lg-0 px-3 px-lg-0">
    <a href="index.jsp" class="navbar-brand ms-lg-5">
        <h1 class="m-0 text-uppercase text-dark"><i class="bi bi-shop fs-1 text-primary me-3"></i>Pet Shop</h1>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
        <div class="navbar-nav ms-auto py-0">
            <a href="index.jsp" class="nav-item nav-link active">Trang chủ</a>
            <a href="about.jsp" class="nav-item nav-link">Giới thiệu</a>
            <a href="service.jsp" class="nav-item nav-link">Dịch vụ</a>
            <a href="product" class="nav-item nav-link">Sản phẩm</a>
            <%--           --%>
            <div class="nav-item dropdown">
                <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Tin tức</a>
                <div class="dropdown-menu m-0">
                    <a href="testmonial.jsp" class="dropdown-item">Testimonial</a>
                    <a href="blog.jsp" class="dropdown-item">Blog Grid</a>
                    <a href="detail.jsp" class="dropdown-item">Blog Detail</a>
                </div>
            </div>
            <c:if test="${sessionScope.user==null}">
                <a href="login.jsp" class="nav-item nav-link nav-contact bg-primary text-white px-5 ms-lg-5">Log in <i
                        class="bi bi-arrow-right"></i></a>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle bg-primary text-white px-5 ms-lg-5"
                       data-bs-toggle="dropdown">${sessionScope.user.firstname} ${sessionScope.user.lastname}</a>
                    <div class="dropdown-menu m-0">
                        <a href="profile" class="dropdown-item">Your information</a>
                            <%--                        <c:if test="${sessionScope.user.userRole.equals('admin')}">--%>
                            <%--                            <a href="admin.jsp" class="dropdown-item">Admin</a>--%>
                            <%--                        </c:if>--%>

                        <c:if test="${sessionScope.user.userId.startsWith('E')}">
                            <a href="food-add.jsp" class="dropdown-item">Quản lí sản phẩm</a>
                            <a href="order-list-manager" class="dropdown-item">Quản lí đơn hàng</a>
                            <a href="list-service-manager.jsp"  class="dropdown-item">Quản lí dịch vụ</a>
                            <a href="getserviceorder"  class="dropdown-item">Quản lí đơn dịch vụ</a>
                        </c:if>
                        <c:if test="${sessionScope.user.userId.startsWith('C')}">
                            <a href="cart.jsp" class="dropdown-item">Giỏ hàng</a>
                            <a href="getorderhistory" class="dropdown-item">Lịch sử đặt hàng</a>
                        </c:if>

                        <a href="logout" class="dropdown-item text-danger">Đăng xuất</a>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</nav>
