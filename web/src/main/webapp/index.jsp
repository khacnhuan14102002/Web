<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.Soluongbanra" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="project" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Trang chủ</title>

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
    <link rel="stylesheet" href="css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i>0723658910</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> shopntt@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i>Linh Trung, Thủ Đức</a></li>

            </ul>

            <%--			Đăng nhập thành công thay thế dòng chữ TÀI KHOẢN--%>
            <ul class="header-links pull-right">
                <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                %>
                <li><a href="/successAccount"><i class="fa fa-user-o"></i> <%= user.getNameUser() %>
                </a></li>
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
                <li><a href="logout"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>

                <%
                } else {
                %>
                <li><a href="/login"><i class="fa fa-user-o"></i>Tài Khoản</a></li>
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
                        <a class="logo">
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
                                <%
                                    User user1 = (User) session.getAttribute("user");
                                    if (user1 != null) {
                                %>
                                <div class="qty"><%=request.getAttribute("sizeW")%>
                                </div>
                                <%}%>
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
                            <a>
                                <i class="fa fa-bars"></i>
                                <span>Menu</span>
                            </a>
                        </div>
                        <!-- /Cart -->

                        <!-- Menu Toogle -->
                        <div class="menu-toggle">
                            <a>
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
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
            <!-- NAV -->
            <ul class="main-nav nav navbar-nav">
                <li class="active"><a>Trang chủ</a></li>
                <li><a href="${project}/store">Sản phẩm</a></li>
                <li><a href="/about">Về chúng tôi</a></li>
                <li><a href="/contactController">Liên hệ</a></li>
                <li><a href="/contactControl">Liên hệ</a></li>
                <!-- /NAV -->
            </ul>
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="./image/mockhoago.jpg" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Móc khóa<br>Bộ sưu tập</h3>
                        <a href="storemockhoa.html" class="cta-btn">Mua ngay<i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="./image/dc8.jpg" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Dreamcatcher<br>Bộ sưu tập</h3>
                        <a href="/store" class="cta-btn">Mua ngay<i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="shop">
                    <div class="shop-img">
                        <img src="./image/oplunn.jpg" alt="">
                    </div>
                    <div class="shop-body">
                        <h3>Ốp lưng<br>Bộ sưu tập</h3>
                        <a href="storeop.html" class="cta-btn">Mua ngay<i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Sản phẩm mới</h3>
                    <div class="section-nav">

                    </div>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab1" class="tab-pane active">
                            <div class="products-slick" data-nav="#slick-nav-1">
                                <!-- product -->
                                <%
                                    List<products> listnew = (List<products>) request.getAttribute("isNew");
                                    for (products pr : listnew) {
                                %>
                                <div class="product">
                                    <div class="product-img">
                                        <img src="<%=pr.getImage()%>" alt="">
                                        <div class="product-label">
                                            <%if (pr.getDiscount() > 0) {%>

                                            <span class="sale">-10%</span>
                                            <%}%>
                                            <% if (pr.getIsnew() == 1) {%>
                                            <span class="new">Mới</span>
                                            <%}%>
                                        </div>
                                    </div>
                                    <div class="product-body">
                                        <h3 class="product-name"><a
                                                href="detail?pid=<%=pr.getIdProduct()%>"><%=pr.getNameProduct()%>
                                        </a></h3>
                                        <h4 class="product-price"><%=pr.getPriceNew()%>
                                            <del class="product-old-price"><%=pr.getPriceOld()%>
                                            </del>
                                        </h4>
                                        <div class="product-rating">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-wishlist"><a
                                                    href="addwish?proid=<%=pr.getIdProduct()%>"><i
                                                    class="fa fa-heart-o"></i></a><span class="tooltipp">Thêm vào yêu thích</span>
                                            </button>
                                            <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="add-to-cart">
                                        <a href="addcart?proid=<%=pr.getIdProduct()%>"><i
                                                class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                    </div>
                                </div>
                                <%}%>
                                <!-- /product -->
                            </div>
                            <div id="slick-nav-1" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- HOT DEAL SECTION -->
<!--		cái backgound bên phần style #hot-deal.section-->
<div id="Contact_us" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="Contact_us">

                    <h1 style="margin-top: -24px;
						color: #e1efea;
						margin-bottom: 25px;">Về cửa hàng chúng tôi</h1>
                    <p style="text-transform: uppercase;
						font-size: 14px;
						color: white;">Nếu bạn là một người đam mê các món quà tặng hoặc vật dụng được làm thủ công bằng
                        tay thì chào mừng bạn đến với shop của chúng tôi nơi đây là chỗ bạn có thể thỏa mãn sự sáng tạo
                        của chính mình.</n></br>
                        shop chúng tôi luôn cập nhật xu hướng mới nhất vào sản phẩm khiến cho khách hàng không cảm thấy
                        nhàm chán và điều quan trọng nhất là shop tha thiết muốn đưa những sản phẩm thủ công mang trong
                        mình giá trị quí báu của lao động đến tận tay các bạn trẻ Việt Nam, góp thêm sắc màu làm đẹp đời
                        sống.</p>
                </div>
            </div>
        </div>
    </div>
    <!-- /row -->
</div>
<!-- /container -->
</div>
<!-- /HOT DEAL SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Bán chạy nhất</h3>
                    <div class="section-nav">

                    </div>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab2" class="tab-pane fade in active">
                            <div class="products-slick" data-nav="#slick-nav-2">
                                <!-- product -->
                                <%
                                    List<Soluongbanra> list10 = (List<Soluongbanra>) request.getAttribute("top10");
                                    for (Soluongbanra sl : list10) {
                                %>
                                <%
                                    List<products> listpro = (List<products>) request.getAttribute("pro");
                                    for (products pr : listpro) {
                                %>
                                <% if (sl.getProductID() == pr.getIdProduct()) {%>

                                <div class="product">
                                    <div class="product-img">
                                        <img src="<%=pr.getImage()%>" alt="">
                                    </div>
                                    <div class="product-body">
                                        <h3 class="product-name"><a href="productspop1.html"><%=pr.getNameProduct()%>
                                        </a></h3>
                                        <h4 class="product-price"><%=pr.getPriceNew()%>
                                            <del class="product-old-price"><%=pr.getPriceOld()%>
                                            </del>
                                        </h4>
                                        <div class="product-rating">
                                        </div>
                                        <div class="product-btns">
                                            <button class="add-to-wishlist"><a
                                                    href="addwish?proid=<%=pr.getIdProduct()%>"><i
                                                    class="fa fa-heart-o"></i></a><span class="tooltipp">Thêm vào yêu thích</span>
                                            </button>
                                            <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="add-to-cart">
                                        <a href="addcart?proid=<%=pr.getIdProduct()%>"><i
                                                class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</a>
                                    </div>
                                </div>
                                <%}%>
                                <%}%>
                                <%}%>
                                <!-- /product -->
                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- /Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->

<h1 style="text-align: center;margin-bottom: 25px">Bạn có thể ghé thăm cửa hàng của chúng tôi qua địa chỉ</h1>
<div id="map" style="width:800px;height:450px;margin-left: 385px">
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.214594666049!2d106.7895730147193!3d10.87127639225723!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3175276398969f7b%3A0x9672b7efd0893fc4!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBOw7RuZyBMw6JtIFRwLiBI4buTIENow60gTWluaA!5e0!3m2!1svi!2s!4v1667629178457!5m2!1svi!2s"
            width="1150" height="450" style="border:0;" allowfullscreen="" loading="lazy"
            referrerpolicy="no-referrer-when-downgrade"></iframe>
</div>

<!-- /SECTION -->

<!-- NEWSLETTER -->
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
<!-- /NEWSLETTER -->

<!-- FOOTER -->
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
                        <p>ShopHandMade</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>Ling Trung, Thủ Đức</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>0723658910</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>shopntt@email.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Thể loại</h3>
                        <ul class="footer-links">
                            <li><a href="#">Giảm giá sốc</a></li>
                            <li><a href="#">Ốp lưng</a></li>
                            <li><a href="#">Móc khóa</a></li>
                            <li><a href="#">Thiệp</a></li>
                            <li><a href="#">Dreamcatcher</a></li>
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
                            <li><a>Giảm giá sốc</a></li>
                            <li><a>Ốp lưng</a></li>
                            <li><a>Móc khóa</a></li>
                            <li><a>Thiệp</a></li>
                            <li><a>Dreamcatcher</a></li>
                        </ul>
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
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>