<%@ page import="vn.edu.hcmuaf.fit.bean.category" %>
<%@ page import="vn.edu.hcmuaf.fit.service.LoaiService" %>
<%@ page import="vn.edu.hcmuaf.fit.service.ProductService" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>

<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
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
	<link type="text/css" rel="stylesheet" href="css/style.css"/>

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
				<div class="col-md-3">
					<div class="header-logo">
						<a href="index.jsp" class="logo">
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
							<a href="#">
								<i class="fa fa-heart-o"></i>
								<span>Yêu thích</span>
								<div class="qty">2</div>
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
								<div class="cart-list">
									<div class="product-widget">
										<div class="product-img">
											<img src="./image/dc2.jpg" alt="">
										</div>
										<div class="product-body">
											<h3 class="product-name"><a href="productdream3.html">Đại dương</a></h3>
											<h4 class="product-price"> 150.000<del class="product-old-price">250.000</del></h4>
										</div>
										<button class="delete"><i class="fa fa-close"></i></button>
									</div>

									<div class="product-widget">
										<div class="product-img">
											<img src="./image/dc6.jpg" alt="">
										</div>
										<div class="product-body">

											<h3 class="product-name"><a href="productdream1.html">Mị</a></h3>
											<h4 class="product-price">240.000<del class="product-old-price">260.000</del></h4>
										</div>
										<button class="delete"><i class="fa fa-close"></i></button>
									</div>
								</div>
								<div class="cart-summary">
									<small>2 sản phẩm đã chon</small>
									<h5>Giá tiền: 390.000</h5>
								</div>
								<div class="cart-btns">
									<a href="/cart">Xem giỏ hàng</a>
									<a href="checkout.html">Thanh toán<i class="fa fa-arrow-circle-right"></i></a>
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
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
	<!-- container -->
	<div class="container">
		<!-- responsive-nav -->
		<div id="responsive-nav">
			<!-- NAV -->


			<ul class="main-nav nav navbar-nav">
				<li ><a href="#">Trang chủ</a></li>
				<li class="active"><a href="store.jsp">Sản phẩm</a></li>
				<li><a href="#">Về chúng tôi</a> </li>
				<li><a href="#">Liên hệ</a></li>

				<!-- /NAV -->
			</ul>
			<!-- /NAV -->
		</div>
		<!-- /responsive-nav -->
	</div>
	<!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- BREADCRUMB -->
<div id="breadcrumb" class="section">
	<!-- container -->
	<div class="container">
		<!-- row -->
		<div class="row">
			<div class="col-md-12">
				<ul class="breadcrumb-tree">
<
					<li><a href="index.jsp">Trang chủ</a></li>
					<li><a href="#">Sản phẩm</a></li>


				</ul>
			</div>
		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
</div>
<!-- /BREADCRUMB -->

<!-- SECTION -->
<div class="section">
	<!-- container -->
	<div class="container">
		<!-- row -->
		<div class="row">
			<!-- ASIDE -->
			<div id="aside" class="col-md-3">
				<!-- aside Widget -->
				<div class="aside">
					<h3 class="aside-title">Danh mục</h3>

					<div class="checkbox-filter">

						<ul >



									<c:forEach items="${requestScope.listCC}" var="c">
										<li><a href="category?cid=${c.idCat}">${c.nameCat}</a></li>
									</c:forEach>

<%--									<%--%>
<%--										List<category> listCC = (List<category>) request.getAttribute("listCC");--%>
<%--										for (category cat : listCC) {--%>
<%--									%>--%>

<%--									<li><a href="<%=cat.getIdCat()%>"><%=cat.getNameCat()%></a></li>--%>
<%--									<%}%>--%>


						</ul>

						<div class="input-checkbox">


						</div>

					</div>
				</div>
				<!-- /aside Widget -->

				<!-- aside Widget -->
				<div class="aside">
					<h3 class="aside-title">   Giá </h3>
					<div class="price-filter">
						<div id="price-slider"></div>
						<div class="input-number price-min">
							<input id="price-min" type="number" >
							<span class="qty-up">+</span>
							<span class="qty-down">-</span>
						</div>
						<span>-</span>
						<div class="input-number price-max">
							<input id="price-max" type="number">
							<span class="qty-up">+</span>
							<span class="qty-down">-</span>
						</div>
					</div>
				</div>
				<!-- /aside Widget -->

				<!-- aside Widget -->
				<!--                  <div class="aside">-->
				<!--                     <h3 class="aside-title">Brand</h3>-->
				<!--                     <div class="checkbox-filter">-->
				<!--                        <div class="input-checkbox">-->
				<!--                           <input type="checkbox" id="brand-1">-->
				<!--                           <label for="brand-1">-->
				<!--                              <span></span>-->
				<!--                              SAMSUNG-->
				<!--                              <small>(578)</small>-->
				<!--                           </label>-->
				<!--                        </div>-->
				<!--                        <div class="input-checkbox">-->
				<!--                           <input type="checkbox" id="brand-2">-->
				<!--                           <label for="brand-2">-->
				<!--                              <span></span>-->
				<!--                              LG-->
				<!--                              <small>(125)</small>-->
				<!--                           </label>-->
				<!--                        </div>-->
				<!--                        <div class="input-checkbox">-->
				<!--                           <input type="checkbox" id="brand-3">-->
				<!--                           <label for="brand-3">-->
				<!--                              <span></span>-->
				<!--                              SONY-->
				<!--                              <small>(755)</small>-->
				<!--                           </label>-->
				<!--                        </div>-->
				<!--                        <div class="input-checkbox">-->
				<!--                           <input type="checkbox" id="brand-4">-->
				<!--                           <label for="brand-4">-->
				<!--                              <span></span>-->
				<!--                              SAMSUNG-->
				<!--                              <small>(578)</small>-->
				<!--                           </label>-->
				<!--                        </div>-->
				<!--                        <div class="input-checkbox">-->
				<!--                           <input type="checkbox" id="brand-5">-->
				<!--                           <label for="brand-5">-->
				<!--                              <span></span>-->
				<!--                              LG-->
				<!--                              <small>(125)</small>-->
				<!--                           </label>-->
				<!--                        </div>-->
				<!--                        <div class="input-checkbox">-->
				<!--                           <input type="checkbox" id="brand-6">-->
				<!--                           <label for="brand-6">-->
				<!--                              <span></span>-->
				<!--                              SONY-->
				<!--                              <small>(755)</small>-->
				<!--                           </label>-->
				<!--                        </div>-->
				<!--                     </div>-->
				<!--                  </div>-->
				<!-- /aside Widget -->

				<!-- aside Widget -->
				<div class="aside">
					<h3 class="aside-title">Bán chạy nhất</h3>
					<div class="product-widget">
						<div class="product-img">
							<img src="./image/dc8.jpg" alt="">
						</div>
						<div class="product-body">
							<p class="product-category">Dreamcatcher</p>
							<h3 class="product-name"><a href="#">Ánh sáng</a></h3>
							<h4 class="product-price">250.000<del class="product-old-price">280.000</del></h4>
						</div>
					</div>

					<div class="product-widget">
						<div class="product-img">
							<img src="./image/dc11.jpg" alt="">
						</div>
						<div class="product-body">
							<p class="product-category">Dreamcatcher</p>
							<h3 class="product-name"><a href="#">Đêm trăng</a></h3>
							<h4 class="product-price">240.000<del class="product-old-price">250.000</del></h4>
						</div>
					</div>

					<div class="product-widget">
						<div class="product-img">
							<img src="./image/dc6.jpg" alt="">
						</div>
						<div class="product-body">
							<p class="product-category">Dreamcatcher</p>
							<h3 class="product-name"><a href="productdream1.html">Mị</a></h3>
							<h4 class="product-price">240.000<del class="product-old-price">260.000</del></h4>
						</div>
					</div>
				</div>
				<!-- /aside Widget -->
			</div>
			<!-- /ASIDE -->

			<!-- STORE -->
			<div id="store" class="col-md-9">
				<!-- store top filter -->
				<div class="store-filter clearfix">
					<div class="store-sort">
						<label>
							Sắp xếp theo:
							<select class="input-select">
								<option value="0">Phổ biến</option>
								<option value="1">Vị trí</option>
							</select>
						</label>


					</div>
					<ul class="store-grid">
						<li class="active"><i class="fa fa-th"></i></li>
						<li><a href="#"><i class="fa fa-th-list"></i></a></li>
					</ul>
				</div>
				<!-- /store top filter -->

				<!-- store products -->
				<div class="row">



				<div class="row">
					<c:forEach var="p" items="${requestScope.listP}">
						<div class="col-md-4 col-xs-6">
							<div class="product">
								<div class="product-img">
									<img src="${p.image}" alt="">
									<div class="product-label">
										<c:if test="${p.discount != 0}">
											<span class="sale">-${p.discount}%</span>
										</c:if>
										<c:if test="${p.isnew != 0}">
											<span class="new">Mới</span>
										</c:if>

									</div>
								</div>
								<div class="product-body">

									<h3 class="product-name"><a href="detail?pid=${p.idProduct}">${p.nameProduct}</a></h3>
									<h4 class="product-price"> <del class="product-old-price"></del></h4>

									<div class="product-btns"><button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">Thêm vào yêu thích</span></button>
										<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">So sánh</span></button>
									</div>
								</div>
								<div class="add-to-cart">

									<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><a herf="#">Thêm vào giỏ hàng</a></button>
								</div>
							</div>
						</div>
						<%--					<%}%>--%>
					</c:forEach>
<%--					<!-- product -->--%>
<%--					<% if(catid==null){--%>
<%--						for(products listpro : pro.getListProductALL()){%>--%>

<%--					<div class="col-md-4 col-xs-6">--%>
<%--						<div class="product">--%>
<%--							<div class="product-img">--%>
<%--								<img src="<%=listpro.getHinhanh()%>" alt="">--%>
<%--								<div class="product-label">--%>
<%--									<span class="sale">-40%</span>--%>
<%--									<span class="new">Mới</span>--%>
<%--								</div>--%>
<%--							</div>--%>
<%--							<div class="product-body">--%>

<%--								<h3 class="product-name"><a href="detail.jsp?masp=<%=listpro.getMasp()%>"><%=listpro.getTensp()%></a></h3>--%>
<%--								<h4 class="product-price"><%=listpro.getGiamoi()%> <del class="product-old-price"><%=listpro.getGiacu()%></del></h4>--%>

<%--								<div class="product-btns"><button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">Thêm vào yêu thích</span></button>--%>
<%--									<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">So sánh</span></button>--%>
<%--								</div>--%>
<%--							</div>--%>
<%--							<div class="add-to-cart">--%>

<%--								<button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i><a herf="GiohangcontrolGiohangcontrol?command=insert@msp=<%=listpro.getMasp()%>&cartid=<%=System.currentTimeMillis()%>">Thêm vào giỏ hàng</a></button>--%>
<%--							</div>--%>
<%--						</div>--%>
<%--					</div>--%>

<%--					<% }--%>
<%--					}else{--%>
<%--						for(products pr : ProductService.getListProductByLoai(catid)){--%>
<%--					%>--%>
<%--					<div class="col-md-4 col-xs-6">--%>
<%--						<div class="product">--%>
<%--							<div class="product-img">--%>
<%--								<img src="<%=pr.getHinhanh()%>" alt="">--%>
<%--								<div class="product-label">--%>
<%--									<span class="sale">-40%</span>--%>
<%--									<span class="new">Mới</span>--%>
<%--								</div>--%>
<%--						</div>--%>
<%--							<div class="product-body">--%>

<%--								<h3 class="product-name"><a href="detail.jsp?masp=<%=pr.getMasp()%>"><%=pr.getTensp()%></a></h3>--%>
<%--								<h4 class="product-price"><%=pr.getGiamoi()%><del class="product-old-price"><%=pr.getGiacu()%></del></h4>--%>

<%--								<div class="product-btns"><button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">Thêm vào yêu thích</span></button>--%>
<%--									<button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">So sánh</span></button>--%>

<%--								</div>--%>
<%--							</div>--%>
<%--							<div class="add-to-cart">--%>

<%--								<button onclick="location.href='store.jsp=+<%=pr.getMasp()%>';" class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>Thêm vào giỏ hàng</button>--%>

<%--							</div>--%>
<%--						</div>--%>
<%--					</div>--%>
<%--					<%}--%>


<%--					}%>--%>
		</div>
				</div>
				<!-- /store products -->

				<!-- store bottom filter -->
				<div class="store-filter clearfix">

					<ul class="store-pagination">

						<li class="active"><a href="#">1</a></li>
						<li class="active"><a href="#">2</a></li>
						<li class="active"><a href="#">3</a></li>
						<li><a href="#"><i class="fa fa-angle-right"></i></a></li>
					</ul>
				</div>

				<!-- /store bottom filter -->
			</div>
			<!-- /STORE -->
		</div>
		<!-- /row -->
	</div>
	<!-- /container -->
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
					<p>Đăng kí để nhận <strong>thông báo</strong></p>
					<form>
						<input class="input" type="email" placeholder="NHẬP EMAIL CỦA BẠN">
						<button class="newsletter-btn"><i class="fa fa-envelope"></i> Đăng kí</button>
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
						<p>Đây là shop có tên là NTT</p>
						<ul class="footer-links">
							<li><a href="#"><i class="fa fa-map-marker"></i>Ling Trung, Thủ Đức</a></li>
							<li><a href="#"><i class="fa fa-phone"></i>+8423658910</a></li>
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
