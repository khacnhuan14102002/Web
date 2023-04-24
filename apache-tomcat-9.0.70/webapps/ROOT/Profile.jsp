<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>

<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.ProductCart" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<head>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>ShopHandMade</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="css/slick.css"/>
        <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="css/style2.css"/>

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>-->
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<body >

<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +8423658910</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> shopntt@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> Linh Trung, Thủ Đức</a></li>
            </ul>
            <ul class="header-links pull-right">
                <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                %>
                <li><a href="success.jsp"><i class="fa fa-user-o"></i> <%= user.getNameUser() %></a></li>
                <%--    Nếu Roleus = 1 thì là admin hiện chữ tài khoản     --%>
                <%
                    if (user.getRoleUs() == 1) {
                %>
                <li><a href="admin.jsp"><i class="fa fa-cog"></i>Quản lý</a></li>
                <%
                    }
                %>
                <%--					--%>
                <li><a href="logout"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>

                <%
                } else {
                %>
                <li><a href="/login"><i class="fa fa-user-o"></i> Tài Khoản</a></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-4">
                    <div class="header-logo">
                        <a href="/index" class="logo">
                            <img src="./image/ntt.png" alt="">
                        </a>
                    </div>

                    <div class="page">
                        <p>|LỊCH SỬ MUA HÀNG</p>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form>
                            <input class="input" placeholder="Tìm kiếm tại đây">
                            <button class="search-btn">Tìm kiếm</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->

                <!-- Wishlist -->

                <!-- /Wishlist -->

                <!-- Cart -->



                <!-- /Menu Toogle -->


                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>

<div class="container bootdey">
    <div class="row bootstrap snippets">



        <!-- Cart -->
        <div class="col-lg-9 col-md-9 col-sm-12">
            <div class="col-lg-12 col-sm-12">
                <h1 class="title">LỊCH SỬ MUA HÀNG</h1>
            </div>
            <div class="col-lg-12 col-sm-12 hero-feature">
                <div class="table-responsive">
                    <table class="table table-bordered tbl-cart">
                        <thead>
                        <tr>


                            <td class="hidden-xs mn">Id</td>
                            <td class="mn" >Tổng tiền</td>

                            <td class="td-qty mn" >Ngày mua</td>
                            <td class="mn">Trạng thái</td>




                        </tr>
                        </thead>
                    <c:forEach items="${requestScope.listIn}" var="l">

                        <tbody>
                        <tr>
<%--                            id--%>
                            <td class="hidden-xs">
                               ${l.idIn}
                            </td>
<%--                            tông tiền--%>
                            <td class="npr">${l.getTotal()}

                            </td>
<%--                            ngay miu--%>
                            <td>
                                ${l.datecreate}
                            </td>
<%--                            trạng thái--%>
                            <td >${l.getStatusIn()}</td>
            <td ><a href="detailinvoice?Idinvoice=${l.idIn}" >XEM CHI TIẾT</a></td>
                        </tr>



                        </c:forEach>
                        </tbody>

                    </table>
                </div>


                <%--                    <div class="col-lg-6">--%>
                <%--                        <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>--%>

                <%--                        <div class="p-4">--%>
                <%--                            <ul class="list-unstyled mb-4" id="contentTotalMoney">--%>
                <%--                                  <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${totalPrice}</strong></li>--%>
                <%--                                 <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>Free ship</strong></li>--%>
                <%--                                 <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>10 $</strong></li>--%>
                <%--                                 <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>--%>
                <%--                                     <h5 class="font-weight-bold">110 $</h5>--%>
                <%--                                 </li>--%>
                <%--                            </ul>--%>
                <%--                        </div>--%>
                <%--                    </div>--%>
            </div>
            <div class="btn-group btns-cart">
                <button type="button" class="bt btn btn-primary"><i class="fa fa-arrow-circle-left"></i><a href="/index"> Trở về trang chủ</a></button>
            </div>
        </div>
    </div>
    <!-- End Cart -->
</div>
</div>
<!-- Button trigger modal -->

<!-- Modal -->

<script src="js/main.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>





</body>

</html>