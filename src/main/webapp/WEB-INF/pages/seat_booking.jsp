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
                <i></i>
                <span>Choose your flight</span><br>
                <%--<strong>${flight_route.departureAirport.name}</strong>
                <span> (${flight_route.departureAirport.code}) to </span>
                <strong>${flight_route.destinationAirport.name} </strong><span> (${flight_route.destinationAirport.code})</span>--%>
            </h2>
        </div>
    </div>
</div>
<div id="weather">
    <div class="container">
        <div class="row">
            <div class="wrapper">
                <div class="col-md-12">
                    <div class="weather-content">
                        <div class="row">
                            <div class="col-md-12">
                                <ul class="tabs clearfix info_link">
                                    <%--<li><a style="background-color:#45484b " href="#" aria-readonly="true">Select
                                        Flight</a></li>--%>
                                    <li><a style="background-color: #dcdb40;" href="#" class="disabled_link"
                                           aria-readonly="true">Seat Selection</a></li>
                                    <li><a style="background-color: #45484b;" href="#" class="disabled_link"
                                           aria-readonly="true">Passenger</a></li>
                                    <li><a style="background-color: #45484b;" href="#" class="disabled_link"
                                           aria-readonly="true">Extra</a></li>
                                    <%--<li><a style="background-color: #45484b;" href="#" class="disabled_link"
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
                            <div style="padding-top:5em " class="col-md-12">
                                <div style="padding-top:2em " class="container-sm border border-primary rounded-pill">
                                    <p>- - - - - -You have selected <i id="quantity">0</i> seats for a price of
                                        <i id="price">$0</i> - - - - -
                                        -</p>
                                </div>
                            </div>
                            <c:if test="${check.equals('return')}">
                                <c:set var="flight" value="${booking.returnFlight}"/>
                                <c:set var="seatList" value="${booking.returnSeatList}"/>
                                <c:set var="seatType" value="${booking.flightAndSeat.returnSeatType}"/>
                            </c:if>
                            <c:if test="${check.equals('depart')}">
                                <c:set var="flight" value="${booking.departFlight}"/>
                                <c:set var="seatList" value="${booking.departSeatList}"/>
                                <c:set var="seatType" value="${booking.flightAndSeat.departSeatType}"/>
                            </c:if>
                            <div class="col-md-12">
                                <section id="second-tab-group" class="weathergroup">
                                    <div id="monday">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <div class="plane" style="width: ${(flight.aircraft.col*60)+ 20}px;min-width: 200px">
                                                    <div class="cockpit">
                                                        <h1>${flight.aircraft.name} ${flight.aircraft.number}</h1>
                                                        <h3>${flight.flightRoute.departureAirport.code}
                                                            -> ${booking.departFlight.flightRoute.destinationAirport.code}</h3>
                                                        <h3>${flight.flightRoute.duration.toHoursPart()}h${flight.flightRoute.duration.toMinutesPart()}m</h3>
                                                        <h3>${flight.departureTime}</h3>
                                                    </div>
                                                    <div class="exit exit--front fuselage">
                                                    </div>
                                                    <ol class="cabin fuselage">
                                                        <li class="">
                                                            <ol class="seats" id="seats">
                                                                <c:set var="col"
                                                                       value="${flight.aircraft.col}"/>
                                                                <c:forEach var="item"
                                                                           items="${flight.aircraftSeatsList}"
                                                                           varStatus="i">
                                                                <c:choose>
                                                                <c:when test="${(i.index) % col != 0 }">
                                                                    <c:choose>
                                                                        <c:when test="${(item.seatsStatus.toString() != 'AVAILABLE' && item.seatsStatus.toString() != 'PROCESSING') || item.seatsType.toString() != seatType }">
                                                                            <li class="seat">
                                                                                <input type="checkbox"
                                                                                       id="${item.seat.number}"
                                                                                       disabled/>
                                                                                <label style="padding: 16px 0;"
                                                                                       for="${item.seat.number}">${item.seat.number}</label>
                                                                            </li>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <c:choose>
                                                                                <c:when test="${seatList.contains(item.seat.number)}">
                                                                                    <li class="seat">
                                                                                        <input type="checkbox"
                                                                                               name="selectedSeat"
                                                                                               id="${item.seat.number}"
                                                                                               data-id="${item.seat.number}"
                                                                                               value="${item.price}"
                                                                                               checked/>
                                                                                        <label style="padding: 16px 0;"
                                                                                               for="${item.seat.number}">${item.seat.number}</label>
                                                                                    </li>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <li class="seat">
                                                                                        <input type="checkbox"
                                                                                               name="selectedSeat"
                                                                                               id="${item.seat.number}"
                                                                                               data-id="${item.seat.number}"
                                                                                               value="${item.price}"/>
                                                                                        <label style="padding: 16px 0;"
                                                                                               for="${item.seat.number}">${item.seat.number}</label>
                                                                                    </li>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:when>
                                                                <c:otherwise>
                                                            </ol>
                                                        </li>
                                                        <li class="">
                                                            <ol class="seats">
                                                                <c:choose>
                                                                    <c:when test="${(item.seatsStatus.toString() != 'AVAILABLE' && item.seatsStatus.toString() != 'PROCESSING') || item.seatsType.toString() != seatType }">
                                                                        <li class="seat">
                                                                            <input type="checkbox"
                                                                                   id="${item.seat.number}"
                                                                                   data-id="${item.seat.number}"
                                                                                   value="${item.seat.number}"
                                                                                   name="selectedSeat"
                                                                                   disabled/>
                                                                            <label style="padding: 16px 0;"
                                                                                   for="${item.seat.number}">${item.seat.number}</label>
                                                                        </li>
                                                                    </c:when>
                                                                    <c:when test="${seatList.contains(item.seat.number)}">
                                                                        <li class="seat">
                                                                            <input type="checkbox"
                                                                                   name="selectedSeat"
                                                                                   id="${item.seat.number}"
                                                                                   data-id="${item.seat.number}"
                                                                                   value="${item.price}"
                                                                                   checked/>
                                                                            <label style="padding: 16px 0;"
                                                                                   for="${item.seat.number}">${item.seat.number}</label>
                                                                        </li>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <li class="seat">
                                                                            <input type="checkbox"
                                                                                   id="${item.seat.number}"
                                                                                   data-id="${item.seat.number}"
                                                                                   value="${item.price}"
                                                                                   name="selectedSeat"
                                                                            />
                                                                            <label style="padding: 16px 0;"
                                                                                   for="${item.seat.number}">${item.seat.number}</label>
                                                                        </li>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                                </c:otherwise>
                                                                </c:choose>
                                                                </c:forEach>
                                                            </ol>
                                                        </li>
                                                    </ol>
                                                    <div class="exit exit--back fuselage">
                                                    </div>
                                                </div>
                                                <h1>${check}</h1>
                                                <h1>${roundTrip.toString()}</h1>
                                                <c:choose>
                                                    <c:when test="${check.equals('depart') && roundTrip == true }">
                                                        <a id="submit" href="returnSeatBooking"
                                                           class="btn btn-lg btn-outline-success"
                                                           style="visibility: hidden">
                                                            Select Return Seat
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a id="submit" href="passenger"
                                                           class="btn btn-lg btn-outline-success"
                                                           style="visibility: hidden">
                                                            Continue
                                                        </a>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </div>
                                </section>
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
                <div class="primary-button">
                    <a href="#" class="scroll-top">Back To Top</a>
                </div>
            </div>
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

<script type="text/javascript">
    $(document).ready(function () {

        $('.scroll-top').on('click', function (event) {
            event.preventDefault();
            $('html, body').animate({scrollTop: 0}, 'slow');
        });

        let check = '${check}';
        let temp = $('input:checkbox').not(":disabled");
        let checked = $('input:checkbox:checked');

       /* if (check === 'return') {*/
            if (checked.length === ${booking.flightAndSeat.quantity}) {
                $('input:checkbox:not(:checked)').not(":disabled").attr('disabled', true);
                document.getElementById('submit').style.visibility = 'visible';
            } else {
                temp.removeAttr('disabled');
                document.getElementById('submit').style.visibility = 'hidden';
            }
       /* }
        else{
            if (checked.length > 0) {
                document.getElementById('submit').style.visibility = 'visible';
            } else {
                document.getElementById('submit').style.visibility = 'hidden';
            }
        }*/

        $('input[type="checkbox"]').change(function () {

            let quantity = document.getElementById("quantity");
            /*let quantity = $('#quantity');*/
            let checked = $('input:checkbox:checked');
            quantity.innerHTML = checked.length;
            let btn = $(this);
            let id = btn.data('id');
            let totalPrice = parseFloat(quantity.textContent) * parseFloat(btn.val());
            document.getElementById("price").innerHTML = '$' + totalPrice.toString();

           /* if (check === 'return') {*/
                if (checked.length >= ${booking.flightAndSeat.quantity}) {
                    $('input:checkbox:not(:checked)').not(":disabled").attr('disabled', true);
                    document.getElementById('submit').style.visibility = 'visible';
                } else {
                    temp.removeAttr('disabled');
                    document.getElementById('submit').style.visibility = 'hidden';
                }
           /* }
            else {
                if (checked.length > 0) {
                    document.getElementById('submit').style.visibility = 'visible';
                } else {
                    document.getElementById('submit').style.visibility = 'hidden';
                }
            }*/

            if ($(this).prop("checked") === false) {
                $.ajax({
                    url: 'uncheckSeat',
                    type: 'GET',
                    data: {
                        "seatNumber": id,
                        "flightId": ${flight.id}
                    },
                    success: function (data) {
                        //response from controller
                    }
                })
            } else {
                $.ajax({
                    url: 'checkSeat',
                    type: 'GET',
                    data: {
                        "seatNumber": id,
                        "flightId": ${flight.id}
                    },
                    success: function (data) {
                        //response from controller
                        if(data === false){
                            alert("This seat has been ordered!!!")
                            document.getElementById(id).checked = false;
                            temp.removeAttr('disabled');
                            document.getElementById('submit').style.visibility = 'hidden';
                          /*  window.location.reload();*/
                        }
                    }
                })
            }
        })
        ;
    })
</script>

</body>
</html>
