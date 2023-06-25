<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.ProductCart" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Thanh Toán</title>
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <%@page contentType="text/html" pageEncoding="UTF-8" %>
</head>
<body>
<header>
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i>0723658910</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> shopntt@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> Linh Trung, Thủ Đức</a></li>
            </ul>
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
    <div id="header">
        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <div class="header-logo">
                        <a href="/index" class="logo">
                            <img src="./image/ntt.png" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="header-search">
                        <form>
                            <input class="input" placeholder="Tìm kiếm tại đây">
                            <button class="search-btn">Tìm kiếm</button>
                        </form>
                    </div>
                </div>
                <div class="col-md-3 clearfix">
                    <div class="header-ctn">
                        <div>
                            <a href="/wishlist">
                                <i class="fa fa-heart-o"></i>
                                <span>Yêu thích</span>
                                <div class="qty"><%=request.getAttribute("sizeW")%>
                                </div>
                            </a>
                        </div>
                        <div class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                <i class="fa fa-shopping-cart"></i>
                                <span>Giỏ hàng</span>
                                <div class="qty">${cart.size() > 0 ? cart.size() : 0}</div>
                            </a>
                            <div class="cart-dropdown">
                                <div class="cart-list">
                                </div>
                            </div>
                            <div class="menu-toggle">
                                <a href="#">
                                    <i class="fa fa-bars"></i>
                                    <span>Menu</span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<nav id="navigation">
    <div class="container">
        <div id="responsive-nav">
            <ul class="main-nav nav navbar-nav">
                <ul class="main-nav nav navbar-nav">
                    <li><a href="/index">Trang chủ</a></li>
                    <li><a href="/store">Sản phẩm</a></li>
                    <li><a href="/about">Về chúng tôi</a></li>
                    <li><a href="/contactControl">Liên hệ</a></li>
                </ul>
            </ul>
        </div>
    </div>
</nav>
<div id="breadcrumb" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3 class="breadcrumb-header">Thanh toán</h3>
                <ul class="breadcrumb-tree">
                    <li><a href="/index">Trang chủ</a></li>
                    <li class="active">Thanh toán</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<form action="/checkout" method="post">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <div class="billing-details">
                        <div class="section-title">
                            <h3 class="title">Thủ tục thanh toán</h3>
                        </div>
                        <%
                            User us = (User) session.getAttribute("user");
                        %>
                        <div class="form-group">
                            <input class="input" type="text" name="name" placeholder="Họ và tên">
                        </div>
                        <div class="form-group">
                            <select id="select-province" class="input" name="address">
                                <option>Tỉnh/Thành Phố</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <select id="select-district" class="input">
                                <option>Quận/Huyện</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <select id="select-ward" class="input">
                                <option>Phường/Xã</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input class="input" type="tel" name="tel" placeholder="Số điện thoại">
                        </div>
                    </div>
                </div>
                <div class="col-md-5 order-details">
                    <div class="section-title text-center">
                        <h3 class="title">Đơn hàng của bạn</h3>
                    </div>
                    <div class="order-summary">
                        <div class="order-col">
                            <div><strong>Sản phẩm</strong></div>
                            <div><strong>Số lượng</strong></div>
                            <div><strong>Giá</strong></div>
                        </div>
                        <c:if test="${cart != null}">
                            <% HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) request.getAttribute("cart");
                                for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
                                    Integer key = entry.getKey();
                                    ProductCart productcart = entry.getValue();
                            %>
                            <div class="order-products">
                                <div class="order-col">
                                    <div><%=productcart.pro.getNameProduct()%>
                                    </div>
                                    <div><%=productcart.quantity%>
                                    </div>
                                    <div><%=productcart.pro.getPriceNew()%>
                                    </div>
                                </div>
                            </div>
                            <%}%>
                        </c:if>
                        <div class="order-col">
                            <div>Thời gian giao hàng</div>
                            <div><strong id="lead-time"></strong></div>
                        </div>
                        <div class="order-col">
                            <div>Phí giao hàng</div>
                            <div><strong id="fee">0</strong></div>
                        </div>
                        <div class="order-col">
                            <div><strong>Giá</strong></div>
                            <div><strong class="order-total">${total}</strong></div>
                        </div>
                    </div>
<%--                    <% String option = request.getParameter("type"); %>--%>
<%--                    <% if (option.equals("Chuyển khoản")) { %>--%>
<%--                    <p>Bạn đã chọn "Có". Đang chuyển hướng...</p>--%>
<%--                    <%--%>
<%--                        // Chuyển hướng sang trang khác nếu cần thiết--%>
<%--                        response.sendRedirect("ck.jsp");--%>
<%--                   %>--%>
                    <div class="payment-method">
                        <h3>Phương thức thanh toán</h3>
                        <select name="type">
                            <option value="ck">Chuyển khoản</option>
                            <option value="tt">Thanh toán khi nhận hàng</option>
                        </select>
                    </div>
                    <div class="input-checkbox">
                        <input type="checkbox" id="terms">
                    </div>
                    <button type="submit">Thanh toán</button>
                </div>
            </div>
        </div>
    </div>
</form>
<div id="newsletter" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Đăng ký <strong>để nhận thông báo</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="NHẬP EMAIL CỦA BẠN">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i>Đăng ký</button>
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
    </div>
</div>
<footer id="footer">
    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Về chúng tôi</h3>
                        <p>Đây là shop có tên là shop</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>Linh Trung, Thủ Đức</a></li>
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
                            <li><a href="#">Về chúng tôi</a></li>
                            <li><a href="#">Liên hệ với chúng tôi</a></li>
                            <li><a href="#">Chính sách bảo mật</a></li>
                            <li><a href="#">Đặt và trả hàng</a></li>
                            <li><a href="#">Điều khoản và điều kiện</a></li>
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
    </div>
    <div id="bottom-footer" class="section">
        <div class="container">
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
        </div>
    </div>
</footer>
<%--<script src="js/jquery.min.js"></script>--%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js" integrity="sha512-8Z5++K1rB3U+USaLKG6oO8uWWBhdYsM3hmdirnOEWp8h2B1aOikj5zBzlXs8QOrvY9OxEnD2QDkbSKKpfqcIWw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script><script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<%--<script src="js/jquery.zoom.min.js"></script>--%>
<script src="js/checkout.js"></script>
<%--<script src="js/main.js"></script>--%>

</body>
</html>
