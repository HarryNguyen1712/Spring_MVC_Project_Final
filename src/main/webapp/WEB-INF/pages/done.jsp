<%--
  Created by IntelliJ IDEA.
  User: bbb26
  Date: 03/28/22
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Flight - Travel and Tour</title>

    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap4.5/bootstrap.min.css"
          type="text/css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/assets/css/bootstrap4.5/bootstrap-grid.min.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/bootstrap-theme.min.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/datepicker.css"
          type="text/css">
    <link href="${pageContext.request.contextPath}/resources-management/assets/plugins/font-awesome/css/font-awesome.min.css"
          rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/hero-slider.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/owl-carousel.css"
          type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/tooplate-style.css">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet" type="text/css">

    <script src="${pageContext.request.contextPath}/resources/assets/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/seat_plane.css">
    <style>
        .disabled_link:hover {
            cursor: not-allowed;
        }

        #fight_route::before {
            background-image: url("${pageContext.request.contextPath}/resources/assets/img/travel.png");
            background-size: 60px 60px;
            display: inline-block;
            width: 60px;
            height: 60px;
            content: "";
            margin-right: 1em;
        }

        #fight_route span {
            font-size: 16px;
            line-height: 18px;
            font-weight: bold;
            color: #00305B;
        }

        #fight_route {
            margin-top: 20px;
        }

        #weather {
            margin-top: 20px;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-light bg-light" style="min-height: 60px; margin-bottom: 0; border: 0;
                                                background: linear-gradient(90deg, rgba(5,41,48,1) 19%, rgba(107,135,140,1) 42%, rgba(204,235,241,1) 73%);">
    <a class="navbar-brand" href="index">
        <img src="${pageContext.request.contextPath}/resources/assets/img/logo.png"
             alt="Flight Template" class="d-inline-block align-text-top"
             style="max-width: 70%; padding-left: 2rem;">
    </a>
    <div class="clearfix" style="margin-right: 30px">
        <a type="button" class="btn btn-outline-warning btn-lg float-right" href="#">Login</a>
        <a class="float-lg-right" style="font-size: large;margin-right: 30px;text-decoration: none;" href="#">Manage my
            bookings</a>
    </div>
</nav>
<div>
    <h1>Success!!</h1>
    <h1>Please check your email for information!!</h1>
</div>
<div>
    <a class="btn btn-lg btn-outline-primary" href="index" >Return home</a>
</div>

<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="social-icons">
                    <li><a href="https://www.facebook.com/tooplate"><i style="margin-top: 30px;"
                                                                       class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i style="margin-top: 30px;" class="fa fa-twitter"></i></a></li>
                    <li><a href="#"><i style="margin-top: 30px;" class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i style="margin-top: 30px;" class="fa fa-rss"></i></a></li>
                    <li><a href="#"><i style="margin-top: 30px;" class="fa fa-behance"></i></a></li>
                </ul>
            </div>
            <div class="col-md-12">
                <p>Copyright &copy; 2018 Flight Tour and Travel Company

                    | Design: <a href="https://www.tooplate.com/view/2093-flight" target="_parent"><em>Flight</em></a>
                </p>
            </div>
        </div>
    </div>
</footer>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>

</body>
</html>
