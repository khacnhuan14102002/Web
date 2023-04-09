<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ page import="vn.edu.hcmuaf.fit.service.Cart" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<!DOCTYPE html>
<html lang="en">



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

<body>

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
                        <a href="index.jsp" class="logo">
                            <img src="./image/ntt.png" alt="">
                        </a>
                    </div>

                    <div class="page">
                        <p>|GIỎ HÀNG</p>
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
                <h1 class="title">GIỎ HÀNG</h1>
            </div>
            <div class="col-lg-12 col-sm-12 hero-feature">
                <div class="table-responsive">
                    <table class="table table-bordered tbl-cart">
                        <thead>
                        <tr>
                        <%ArrayList<products> giohang = new Cart().getGiohang();%>


                            <td class="hidden-xs mn"   > ẢNH</td>
                            <td class="mn" >TÊN</td>

                            <td class="td-qty mn" >SỐ LƯỢNG</td>
                            <td class="mn">GIÁ</td>
                            <td class="mn">TỔNG</td>
                            <td class="mn">XÓA HÀNG</td>


                        </tr>
                        </thead>
                        <tbody>
                        <% for(int i =0;i <giohang.size();i++){%>
                        <tr>
                            <td class="hidden-xs">
                                <a href="#">
                                    <img src="<%=giohang.get(i).getHinhanh()%>" alt="ĐẠI DƯƠNG" title="" width="47" height="47">
                                </a>
                            </td>
                            <td class="npr"><a href="#"><%=giohang.get(i).getTensp()%></a>
                            </td>


                                <td>
                                    <div class="input-number">
                                        <input type="number" value="1">
                                        <span class="qty-up">+</span>
                                        <span class="qty-down">-</span>
                                    </div>
<!--                                <div class="input-group bootstrap-touchspin"><span class="input-group-btn"></span><span class="input-group-addon bootstrap-touchspin-prefix" style="display: none;"></span><input type="text" name="" value="1" class="input-qty form-control text-center" style="display: block;"><span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span><span class="input-group-btn"></span></div>-->
                            </td>
                            <td class="price"><%=giohang.get(i).getGiamoi()%></td>
                            <td>150.000</td>
                            <td class="text-center">
                                <a href="#" class="remove_cart" rel="1">
                                    <i class="fa fa-trash" aria-hidden="true"></i>
                                </a>
                            </td>
                            <td></td>

                        </tr>
                        <tr>
                            <td colspan="6" align="right">Tổng tiền</td>
                            <td class="total" colspan="1"><b>390.000</b>
                            </td>
                        </tr>
                        <%}%>
                        </tbody>
                    </table>
                </div>
                <div class="btn-group btns-cart">
                    <button type="button" class="bt btn btn-primary"><i class="fa fa-arrow-circle-left"></i><a href="index.jsp"> Tiếp tục mua sắm</a></button>
                    <button type="button" class=" bt btn btn-primary">Cập nhật giỏ hảng</button>
                    <button type="button" class="bt btn btn-primary"><a href="checkout.html">Thanh toán<i class="fa fa-arrow-circle-right"></i></a></button>
                </div>
            </div>
        </div>
        <!-- End Cart -->
    </div>
</div>
<script src="js/main.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>
</body>

</html>