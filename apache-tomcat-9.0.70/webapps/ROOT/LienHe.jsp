<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta
            name="viewport"
            content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no"
    />
    <title>Liên hệ</title>
    <link href="css/LienHe.css" rel="stylesheet" type="text/css" />
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
            crossorigin="anonymous"
    />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

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
    <link type="text/css" rel="stylesheet" href="css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<body>
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a><i class="fa fa-phone"></i>0723658910</a></li>
                <li><a><i class="fa fa-envelope-o"></i>shopntt@email.com</a></li>
                <li><a><i class="fa fa-map-marker"></i>Linh Trung, Thủ Đức</a></li>
            </ul>
            <ul class="header-links pull-right">
                <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                %>
                <li><a href="/successAccount"><i class="fa fa-user-o"></i> <%= user.getNameUser() %></a></li>
                <li><a href="/historyinvoice"><i class="fa fa-bars"></i>Lịch sử mua hàng</a></li>
                <%--    Nếu Roleus = 1 thì là admin hiện chữ tài khoản     --%>
                <%
                    if (user.getRoleUs() == 1) {
                %>
                <li><a href="/adminpage"><i class="fa fa-cog"></i>Quản lý</a></li>
                <%
                    }
                %>
                <%--					--%>
                <li><a href="logout"><i class="fa fa-sign-out"></i>Đăng xuất</a></li>

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
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="/index" class="logo">
                            <img src="./image/ntt.png" alt="">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-6">
                    <div class="header-search">
                        <form action="search" meathod="get">

                            <input name="txt" type="text" class="input" placeholder="Tìm kiếm tại đây">
                            <button type="submit" class="search-btn">Tìm kiếm</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <!-- Wishlist -->
                        <div>
                            <a href="/wishlist">
                                <i class="fa fa-heart-o"></i>
                                <span>Yêu thích</span>
                                <div class="qty"><%=request.getAttribute("sizeW")%></div>
                            </a>
                        </div>
                        <!-- /Wishlist -->

                        <!-- Cart -->
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Giỏ hàng</span>
                                <div class="qty">${cart.size() > 0 ? cart.size() : 0}</div>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-btns">
                                    <a href="/cart">Xem giỏ hàng</a>
                                    <a href="/invoice">Thanh toán<i class="fa fa-arrow-circle-right"></i></a>
                                </div>
                            </div>
                        </div>
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a href="#">
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Menu Toogle -->
                    </div>
                </div>
                <!-- /ACCOUNT -->
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li><a href="/index">Trang chủ</a></li>
                <li><a href="${project}/store">Sản phẩm</a></li>
                <li><a href="/about">Về chúng tôi</a></li>
                <li class="active"><a href="/contactControl">Liên hệ</a></li>
                <!-- /NAV -->
            </ul>
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<div id="breadcrumb" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">

                <ul class="breadcrumb-tree">
                    <li><a href="/index">Trang chủ</a></li>
                    <li class="active">Liên hệ</li>
                </ul>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<div class="contact-wrap">
    <div class="contact-in">
        <h1>Liên hệ</h1>
        <h2><i class="fa fa-phone" aria-hidden="true"></i>Số điện thoại</h2>
        <p>0723658910</p>
        <h2><i class="fa fa-envelope" aria-hidden="true"></i>Email</h2>
        <p>shopntt@email.com</p>
        <h2><i class="fa fa-map-marker" aria-hidden="true"></i>Địa chỉ</h2>
        <p>Linh Trung, Thủ Đức</p>
        <ul>
            <li>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-google" aria-hidden="true"></i></a>
            </li>
            <li>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
            </li>
        </ul>
    </div>
    <div class="contact-in">
        <h1>Gửi lời nhắn</h1>
        <form>
            <input type="text" placeholder="Họ và tên" class="contact-in-input" />
            <input type="text" placeholder="Email" class="contact-in-input" />
            <input type="text" placeholder="Tiêu đề" class="contact-in-input" />
            <textarea
                    placeholder="Nội dung"
                    class="contact-in-textarea"
            ></textarea>
            <input type="submit" value="Gửi" class="contact-in-btn" />
        </form>
    </div>
    <div class="contact-in">
        <iframe
                src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.214594666049!2d106.7895730147193!3d10.87127639225723!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRwLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1667629178457!5m2!1svi!2s"
                width="100%"
                height="auto"
                frameborder="0"
                style="border: 0"
                allowfullscreen=""
                aria-hidden="false"
                tabindex="0"
        ></iframe>
    </div>
</div>
<div id="newsletter" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Đăng ký để nhận <strong>thông báo</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="NHẬP EMAIL CỦA BẠN">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Đăng ký</button>
                    </form>
                    <ul class="newsletter-follow">
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Về chúng tôi</h3>
                        <p>Đây là shop có tên là NTT</p>
                        <ul class="footer-links">
                            <li><a><i class="fa fa-map-marker"></i>Linh Trung, Thủ Đức</a></li>
                            <li><a><i class="fa fa-phone"></i>0723658910</a></li>
                            <li><a><i class="fa fa-envelope-o"></i>shopntt@email.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Thể loại</h3>
                        <ul class="footer-links">
                            <li><a>Giảm giá sốc</a></li>
                            <li><a>Ốp lưng</a></li>
                            <li><a>Móc khóa</a></li>
                            <li><a>Thiệp</a></li>
                            <li><a>Dreamcatcher</a></li>
                        </ul>
                    </div>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Thông tin</h3>
                        <ul class="footer-links">
                            <li><a>Về chúng tôi</a></li>
                            <li><a>Liên hệ với chúng tôi</a></li>
                            <li><a>Chính sách bảo mật</a></li>
                            <li><a>Đặt và trả hàng</a></li>
                            <li><a>Điều khoản và điều kiện</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Dịch vụ</h3>
                        <ul class="footer-links">
                            <li><a href="#">Tài khoản</a></li>
                            <li><a href="#">Giỏ hàng</a></li>
                            <li><a href="#">Yêu thích</a></li>
                            <li><a href="#">Theo dõi đơn hàng</a></li>
                            <li><a href="#">Trợ giúp</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->

    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>

                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
</body>
</html>
