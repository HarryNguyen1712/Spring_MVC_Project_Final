<%--
  Created by IntelliJ IDEA.
  User: bbb26
  Date: 03/28/22
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

        .pass-info input, select, option {
            height: 4rem;
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
        <sec:authorize access="isAuthenticated()">
            <sec:authorize access="hasRole('ROLE_USER')">
                <a type="button" class="btn btn-outline-warning btn-lg float-right" href="logout">Logout</a>
                <a class="btn btn-outline-primary btn-lg float-right mr-5" href="user/home">Manage Account</a>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a type="button" class="btn btn-outline-warning btn-lg float-right" href="logout">Logout</a>
                <a class="btn btn-outline-primary btn-lg float-right mr-5" href="admin/home">Manager</a>
            </sec:authorize>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <a type="button" class="btn btn-outline-warning btn-lg float-right" href="login">Login</a>
        </sec:authorize>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h2 id="fight_route">
                <%--                <i></i>
                                <span>Choose your flight</span><br>
                                <strong>Ho Chi Minh</strong>
                                <span> (SGN) to </span> <strong>Da Nang </strong><span> (DAD)</span>
                            </h2>--%>
        </div>
    </div>
</div>
<br>
<div id="weather">
    <div class="container">
        <div class="row">
            <div class="wrapper">
                <div class="col-md-12">
                    <div class="weather-content">
                        <div class="row">
                            <div class="col-md-12">
                                <ul class="tabs clearfix info_link">
                                    <%--<li><a style="background-color: #45484b" class="disabled_link" >Select Flight</a></li>--%>
                                    <li><a style="background-color: #45484b;" href="seat_booking">Seat Selection</a>
                                    </li>
                                    <li><a style="background-color: #dcdb40;" class="disabled_link"
                                           aria-readonly="true">Passenger</a></li>
                                    <li><a style="background-color: #45484b;" class="disabled_link"
                                           aria-readonly="true">Extra</a></li>
                                    <%--<li><a style="background-color: #45484b;"  class="disabled_link"
                                           aria-readonly="true">Payment</a></li>--%>
                                </ul>
                            </div>
                            <div style="margin: 2em auto 2em auto" class="col-md-12">
                                <div style="padding-top:2em " class="container-sm border border-primary rounded-pill">
                                    <p>- Your personal data collected on this page are processed by Vietnam Airlines for
                                        the purposes and the conditions listed in Vietnam Airlines Privacy Policy. </p>
                                    <p>- To know more about how your personal data are processed and about your rights
                                        (right to access, right to be forgotten, right to object...), please read and
                                        accept our Privacy Policy.</p>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="row">
                                    <div style="margin-bottom: 2em" class="col-md-12">
                                        <h2>Passenger Information</h2>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="row">
                                    <div style="margin-bottom: 2em" class="col-md-12">
                                        <div class="weather-item">
                                            <c:set var="value" value=""/>
                                            <form:form action="savePassenger" modelAttribute="book" class="pass-info"
                                                       method="post">
                                                <div class="container">
                                                    <h2>Person booking</h2>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-2">
                                                            <label for="inputPrefix">Prefix</label>
                                                            <select style="height: 4rem"
                                                                    id="inputPrefix"
                                                                    name="bookingInfo.genderEnum"
                                                                    class="form-control" required>
                                                                <option value="">Choose...</option>
                                                                <c:forEach var="item" items="${genderList}">
                                                                    <c:choose>
                                                                        <c:when test="${sessionScope.booking.booking.genderEnum == item}">
                                                                            <option value="${item}"
                                                                                    selected>${item}</option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="${item}">${item}</option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                        <div class="form-group col-md-10">
                                                            <label for="inputFullName">FullName</label>
                                                            <input class="form-control" type="text"
                                                                   id="inputFullName"
                                                                   name="bookingInfo.fullName"
                                                                   value="${sessionScope.booking.booking.fullName}"
                                                                   required>
                                                        </div>
                                                    </div>
                                                    <div class="form-row">
                                                        <div class="form-group col-md-3">
                                                            <label for="inputBirthday">Birthday</label>
                                                            <input type="date" class="form-control"
                                                                   id="inputBirthday"
                                                                   name="bookingInfo.birthday"
                                                                   value="${sessionScope.booking.booking.birthday}"
                                                                   max="2015-12-31"
                                                                   required>
                                                        </div>
                                                        <div class="form-group col-md-3">
                                                            <label for="inputPhoneNumber">Phone
                                                                Number</label>
                                                            <input type="tel" id="inputPhoneNumber"
                                                                   class="form-control"
                                                                   name="bookingInfo.phoneNumber"
                                                                   placeholder="10 digits"
                                                                   value="${sessionScope.booking.booking.phoneNumber}"
                                                                   pattern="[0-9]{10}" required>
                                                        </div>
                                                        <div class="form-group col-md-12">
                                                            <label for="inputEmail">Email</label>
                                                            <input type="email" class="form-control"
                                                                   id="inputEmail"
                                                                   name="bookingInfo.email"
                                                                   value="${sessionScope.booking.booking.email}"
                                                                   placeholder="Email cannot be empty!" required>
                                                        </div>
                                                        <div class="form-group col-md-12">
                                                            <label for="inputAddress">Address</label>
                                                            <input type="text" class="form-control"
                                                                   id="inputAddress"
                                                                   name="bookingInfo.address"
                                                                   value="${sessionScope.booking.booking.address}"
                                                                   placeholder="1234 Main St">
                                                        </div>
                                                    </div>
                                                </div>
                                                <c:forEach var="passenger" items="${sessionScope.booking.departSeatList}"
                                                           varStatus="status">
                                                    <c:if test="${sessionScope.booking.booking.bookingDetailEntity != null && sessionScope.booking.booking.bookingDetailEntity.size() >0 }">
                                                        <c:set var="value"
                                                               value="${sessionScope.booking.booking.bookingDetailEntity.get(status.index).passengersEntity.genderEnum}"/>
                                                        <c:set var="value1"
                                                               value="${sessionScope.booking.booking.bookingDetailEntity.get(status.index).passengersEntity.fullName}"/>
                                                        <c:set var="value2"
                                                               value="${sessionScope.booking.booking.bookingDetailEntity.get(status.index).passengersEntity.birthday}"/>
                                                        <c:set var="value3"
                                                               value="${sessionScope.booking.booking.bookingDetailEntity.get(status.index).passengersEntity.phoneNumber}"/>
                                                        <c:set var="value4"
                                                               value="${sessionScope.booking.booking.bookingDetailEntity.get(status.index).passengersEntity.idenCode}"/>
                                                        <c:set var="value5"
                                                               value="${sessionScope.booking.booking.bookingDetailEntity.get(status.index).passengersEntity.email}"/>
                                                        <c:set var="value6"
                                                               value="${sessionScope.booking.booking.bookingDetailEntity.get(status.index).passengersEntity.address}"/>
                                                    </c:if>
                                                    <div class="container">
                                                        <h2>Person ${status.index + 1}</h2>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-2">
                                                                <label for="inputPrefix${status.index}">Prefix</label>
                                                                <select style="height: 4rem"
                                                                        id="inputPrefix${status.index}"
                                                                        name="passengersEntityList[${status.index}].genderEnum"
                                                                        class="form-control form-select" required>
                                                                    <option value="">Choose...</option>
                                                                    <c:forEach var="item" items="${genderList}">
                                                                        <c:choose>
                                                                            <c:when test="${value == item}">
                                                                                <option value="${item}"
                                                                                        selected>${item}</option>
                                                                            </c:when>
                                                                            <c:otherwise>
                                                                                <option value="${item}">${item}</option>
                                                                            </c:otherwise>
                                                                        </c:choose>
                                                                    </c:forEach>
                                                                </select>
                                                            </div>
                                                            <div class="form-group col-md-10">
                                                                <label for="inputFullName${status.index}">FullName</label>
                                                                <input class="form-control" type="text"
                                                                       id="inputFullName${status.index}"
                                                                       name="passengersEntityList[${status.index}].fullName"
                                                                       value="${value1}"
                                                                       required>
                                                            </div>
                                                        </div>
                                                        <div class="form-row">
                                                            <div class="form-group col-md-3">
                                                                <label for="inputBirthday${status.index}">Birthday</label>
                                                                <input type="date" class="form-control"
                                                                       id="inputBirthday${status.index}"
                                                                       name="passengersEntityList[${status.index}].birthday"
                                                                       value="${value2}"
                                                                       max="2015-12-31"
                                                                       required>
                                                            </div>
                                                            <div class="form-group col-md-3">
                                                                <label for="inputPhoneNumber${status.index}">Phone
                                                                    Number</label>
                                                                <input type="tel" id="inputPhoneNumber${status.index}"
                                                                       class="form-control"
                                                                       name="passengersEntityList[${status.index}].phoneNumber"
                                                                       placeholder="10 digits"
                                                                       value="${value3}"
                                                                       pattern="[0-9]{10}" required>
                                                            </div>
                                                            <div class="form-group col-md-3">
                                                                <label for="inputIdentityCode${status.index}">Identity
                                                                    Code</label>
                                                                <input type="tel" id="inputIdentityCode${status.index}"
                                                                       class="form-control"
                                                                       name="passengersEntityList[${status.index}].idenCode"
                                                                       value="${value4}"
                                                                       pattern="[0-9]{10}" required>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <label for="inputEmail${status.index}">Email</label>
                                                                <input type="email" class="form-control"
                                                                       id="inputEmail${status.index}"
                                                                       name="passengersEntityList[${status.index}].email"
                                                                       value="${value5}"
                                                                       placeholder="Email cannot be empty!" required>
                                                            </div>
                                                            <div class="form-group col-md-12">
                                                                <label for="inputAddress${status.index}">Address</label>
                                                                <input type="text" class="form-control"
                                                                       id="inputAddress${status.index}"
                                                                       name="passengersEntityList[${status.index}].address"
                                                                       value="${value6}"
                                                                       placeholder="1234 Main St">
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <br>
                                                    <br>
                                                    <%-- <c:if test="${status.index > 0}">
                                                         <div class="container">
                                                             <h2>Person ${status.index + 1}</h2>
                                                             <div class="form-row">
                                                                 <div class="form-group col-md-2">
                                                                     <label for="inputPrefix${status.index}">Prefix</label>
                                                                     <select style="height: 4rem" id="inputPrefix${status.index}"
                                                                             name = "passengersEntityList[${status.index}].genderEntity.id"
                                                                             class="form-control" required>
                                                                         <option value="">Choose...</option>
                                                                         <c:forEach var="item" items="${genderList}">
                                                                             <c:choose>
                                                                                 <c:when test="${value == item.id}">
                                                                                     <option value="${item.id}" selected>${item.genderEnum}</option>
                                                                                 </c:when>
                                                                                 <c:otherwise>
                                                                                     <option value="${item.id}">${item.genderEnum}</option>
                                                                                 </c:otherwise>
                                                                             </c:choose>
                                                                         </c:forEach>
                                                                     </select>
                                                                 </div>
                                                                 <div class="form-group col-md-10">
                                                                     <label for="inputFullName${status.index}">Full Name</label>
                                                                     <input class="form-control" type="text" id="inputFullName${status.index}" name="passengersEntityList[${status.index}].fullName"
                                                                            value="${value1}"
                                                                            required>
                                                                 </div>
                                                             </div>
                                                             <div class="form-row">
                                                                 <div class="form-group col-md-3">
                                                                     <label for="inputBirthday${status.index}">Birthday</label>
                                                                     <input type="date" class="form-control"
                                                                            id="inputBirthday${status.index}"
                                                                            name="passengersEntityList[${status.index}].birthday"
                                                                            value="${value2}"
                                                                            max="2015-12-31"
                                                                            required>
                                                                 </div>
                                                                 <div class="form-group col-md-3">
                                                                     <label for="inputPhoneNumber${status.index}">Phone Number</label>
                                                                     <input type="tel" id="inputPhoneNumber${status.index}"
                                                                            class="form-control"
                                                                            name="passengersEntityList[${status.index}].phoneNumber"
                                                                            value="${value3}"
                                                                            placeholder="10 digits"
                                                                            pattern="[0-9]{10}" required>
                                                                 </div>
                                                                 <div class="form-group col-md-3">
                                                                     <label for="inputIdentityCode${status.index}">Identity Code</label>
                                                                     <input type="tel" id="inputIdentityCode${status.index}"
                                                                            class="form-control"
                                                                            name="passengersEntityList[${status.index}].idenCode"
                                                                            value="${value4}"
                                                                            pattern="[0-9]{10}" required>
                                                                 </div>
                                                             </div>
                                                         </div>
                                                         <br>
                                                         <br>
                                                     </c:if>--%>
                                                </c:forEach>
                                                <div class="form-group col-md-2">
                                                    <button type="submit"
                                                            class="form-control btn btn-secondary btn-lg ">
                                                        Save
                                                    </button>
                                                </div>
                                            </form:form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/assets/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap4.5/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap4.5/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/datepicker.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/main.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>
<script>
    $(function () {
        $('.info_link a').click(function () {
            if ($(this).attr('href') != null)
                window.location.href = $(this).attr('href');
        });
    });

    $(document).ready(function() {
        $('select.form-select').click(function(event) {
            // this.append wouldn't work
            let pid = $(this).attr('id');
            let id = pid.substring(11);
            let text = "inputIdentityCode";
            let iid = text.concat(id);

             /*document.getElementById(iid);*/
            let element = document.getElementById(iid);
            if ($(this).val() === 'CHILD'){
                element.removeAttribute('required');
                element.setAttribute('disabled','');
            }
            else {
                element.setAttribute('required','');
                element.removeAttribute('disabled');
            }
        });
    });

</script>
</body>
</html>
