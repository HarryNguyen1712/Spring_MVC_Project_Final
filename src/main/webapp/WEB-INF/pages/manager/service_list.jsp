<%--
  Created by IntelliJ IDEA.
  User: speed
  Date: 03/27/22
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport"/>
    <meta name="description" content="Responsive Admin Template"/>
    <meta name="author" content="SmartUniversity"/>
    <title>Management</title>
    <!-- google font -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet" type="text/css"/>
    <!-- icons -->
    <link href="${pageContext.request.contextPath}/resources-management/assets/plugins/simple-line-icons/simple-line-icons.min.css"
          rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources-management/assets/plugins/font-awesome/css/font-awesome.min.css"
          rel="stylesheet" type="text/css"/>
    <!--bootstrap -->
    <link href="${pageContext.request.contextPath}/resources-management/assets/plugins/bootstrap/css/bootstrap.min.css"
          rel="stylesheet" type="text/css"/>
    <!-- Material Design Lite CSS -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources-management/assets/plugins/material/material.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources-management/assets/css/material_style.css">
    <!-- data tables -->
    <link href="${pageContext.request.contextPath}/resources-management/assets/plugins/datatables/plugins/bootstrap/dataTables.bootstrap4.min.css"
          rel="stylesheet" type="text/css"/>
    <!-- animation -->
    <link href="${pageContext.request.contextPath}/resources-management/assets/css/pages/animate_page.css"
          rel="stylesheet">
    <!-- Template Styles -->
    <link href="${pageContext.request.contextPath}/resources-management/assets/css/style.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources-management/assets/css/plugins.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources-management/assets/css/responsive.css" rel="stylesheet"
          type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources-management/assets/css/theme-color.css" rel="stylesheet"
          type="text/css"/>
    <!-- favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources-management/assets/img/favicon.ico"/>
</head>
<body class="page-header-fixed sidemenu-closed-hidelogo page-content-white page-md header-white dark-sidebar-color logo-dark">
<div class="page-wrapper">
    <!-- start header -->
    <jsp:include page="../include/header.jsp"></jsp:include>
    <!-- end header -->
    <!-- start page container -->
    <div class="page-container">
        <!-- start sidebar menu -->
        <jsp:include page="../include/menuManager.jsp"></jsp:include>
        <!-- end sidebar menu -->
        <!-- start page content -->
        <div class="page-content-wrapper">
            <div class="page-content">
                <div class="page-bar">
                    <div class="page-title-breadcrumb">
                        <div class=" pull-left">
                            <div class="page-title">All Services</div>
                        </div>

                    </div>
                </div>
                <div class="tab-content tab-space">
                    <div class="tab-pane active show" id="tab1">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card-box">
                                    <div class="card-head">
                                        <button id="panel-button"
                                                class="mdl-button mdl-js-button mdl-button--icon pull-right"
                                                data-upgraded=",MaterialButton">
                                            <i class="material-icons">more_vert</i>
                                        </button>
                                        <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect"
                                            data-mdl-for="panel-button">
                                            <li class="mdl-menu__item"><i class="material-icons">assistant_photo</i>Action
                                            </li>
                                            <li class="mdl-menu__item"><i class="material-icons">print</i>Another action
                                            </li>
                                            <li class="mdl-menu__item"><i class="material-icons">favorite</i>Something
                                                else here
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="card-body ">

                                        <div class="table-scrollable">
                                            <table class="table table-hover table-checkable order-column full-width"
                                                   id="example4">
                                                <thead>
                                                <tr>

                                                    <th class="center"> Name</th>
                                                    <th class="center"> Description</th>
                                                    <th class="center"> Price</th>
                                                    <th class="center"> Action</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${listService}" var="item">
                                                    <tr class="odd gradeX">

                                                        <td class="center"><c:out value="${item.name}"/></td>
                                                        <td class="center"><c:out value="${item.description}"/></td>
                                                        <td class="center"><c:out value="${item.price}"/></td>
                                                        <td class="center">
                                                            <a href="listImageService?id=${item.id}"
                                                               class="btn btn-tbl-edit btn-xs">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-images" viewBox="0 0 16 16">
                                                                    <path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z"/>
                                                                    <path d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2zM14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1zM2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1h-10z"/>
                                                                </svg>
                                                            </a>
                                                            <a href="editService?id=${item.id}"
                                                               class="btn btn-tbl-edit btn-xs">
                                                                <i class="fa fa-pencil"></i>
                                                            </a>

                                                            <a href="deleteService?id=${item.id}" class="btn btn-tbl-delete btn-xs">
                                                                <i class="fa fa-trash-o "></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- end page content -->
        <!-- start chat sidebar -->

        <!-- end chat sidebar -->
    </div>
    <!-- end page container -->
    <!-- start footer -->
    <jsp:include page="../include/footer.jsp"></jsp:include>
    <!-- end footer -->
</div>
<!-- start js include path -->
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/jquery-blockui/jquery.blockui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- bootstrap -->
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- Common js-->
<script src="${pageContext.request.contextPath}/resources-management/assets/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources-management/assets/js/layout.js"></script>
<script src="${pageContext.request.contextPath}/resources-management/assets/js/theme-color.js"></script>
<!-- data tables -->
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/datatables/plugins/bootstrap/dataTables.bootstrap4.min.js"></script>
<script src="${pageContext.request.contextPath}/resources-management/assets/js/pages/table/table_data.js"></script>
<!-- Material -->
<script src="${pageContext.request.contextPath}/resources-management/assets/plugins/material/material.min.js"></script>
<!-- animation -->
<script src="${pageContext.request.contextPath}/resources-management/assets/js/pages/ui/animations.js"></script>
<!-- end js include path -->
</body>
</html>