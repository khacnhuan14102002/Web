<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">


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


  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>


</head>
<body>
<!-- HEADER -->
<header>
  <!-- TOP HEADER -->
  <div id="top-header">
    <div class="container">
      <ul class="header-links pull-left">
        <li><a href="#"><i class="fa fa-phone"></i>0723658910</a></li>
        <li><a href="#"><i class="fa fa-envelope-o"></i>shopntt@email.com</a></li>
        <li><a href="#"><i class="fa fa-map-marker"></i>Linh Trung, Thủ Đức</a></li>
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
            <a href="/index" class="logo">
              <img src="./image/ntt.png" alt="">
            </a>
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
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
  <!-- container -->
  <div class="container">
    <!-- responsive-nav -->
    <div id="responsive-nav">
      <!-- NAV -->
      <ul class="main-nav nav navbar-nav">
        <li><a href="/index">Trang chủ</a></li>
        <li><a href="/store">Sản phẩm</a></li>
        <li class="active"><a href="/about">Về chúng tôi</a> </li>
        <li><a href="/contactController">Liên hệ</a></li>
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
          <li><a href="/index">Trang chủ</a></li>
          <li class="active">Về chúng tôi</li>
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
 <!-- Billing Details -->
        <div class="billing-details">
          <div class="section-title">
            <h2 class="title" style="text-align: center">Về cửa hàng của chúng tôi</h2></div></br>
          <p>
          Handmade được dịch sang Tiếng Việt là làm thủ công hay làm bằng tay, những năm gần đây đồ handmade đang rất phổ biến trong giới trẻ. Với công nghệ internet phát triển như hiện nay, bạn có thể bắt gặp đồ handmade ở khắp mọi nơi trên internet, mạng xã hội facebook, từ những vật dụng cá nhân như vòng đeo tay, móc khóa, túi xách, đồ mỹ phẫm handmade như nước hoa, son môi,…
          Mang ý nghĩa là một sản phẩm nghệ thuật, tự tay còn người làm ra, nên chứa đựng trong đó đầy tình cảm, công sức, ý nghĩa nhiều hơn những sản phẩm thông thường.

          Là một sản phẩm được làm bằng tay nên sản phẩm tạo ra có thể không nhiều nên rất giá trị, mặc khác dù các tác phẩm có thể sao chép xong không thể nào giống y hệt sản phẩm ban đầu.
          Với công nghệ tiên tiến như hiện nay, ở những nước phát triển như Châu u,.. và ở Việt Nam đang là phong trào, con người lại thích những sản được làm bằng tay và vì thế những người làm đồ handmade giỏi lại kiếm được nhiều tiền trong những món đồ mà họ tạo ra.
          Có thể nói đồ handmade còn là một giá trị nghệ thuật và người làm đồ handmade là một nghệ nhân thật thụ.

          </p>
        </div>

      Chất liệu của đồ handmade
      Ngày nay ta có thể bắt gặp những món đồ handmade từ đủ mọi chất liệu khác nhau: từ đơn giản thông dụng như giấy, bìa, vải, len, sợi, gỗ cho đến những chất liệu chuyên biệt dành riêng cho các tín đồ handmade như: hạt cườm, lông vũ,… Cùng với sự thịnh hành của xu hướng đồ handmade, nguyên liệu dành cho việc thiết kế các sản phẩm thủ công ngày càng đa dạng, phong phú và dễ dàng tiếp cận. Sau đây là một số chất liệu không thể không kể đến khi nói về handmade.

     <h4>1. Vải</h4>
      Vải nỉ, vải dạ, vải thêu cross stitch hay vải lông thú đều là những loại vải dễ dàng sử dụng để tạo hình cũng như kết hợp với các chất liệu khác trong chế tạo đồ handmade.
      <h4>2. Giấy kraft</h4>
      Dù không quá đa dạng về màu sắc nhưng với nhiều kiểu giấy có độ dày ứng với các công dụng kỹ thuật khác nhau, giấy kraft là sự lựa chọn số một cho những sản phẩm như thiệp hay túi, hộp handmade.
      <h4>3. Len sợi, cói, đay</h4>
      Đan và móc là những kỹ thuật quen thuộc trong chế tác đồ handmade. Với nhiều đặc tính và màu sắc đa dạng, len, cói cũng như đay đã biến hóa vô cùng phong phú với đủ mọi thành phẩm từ một chi tiết trang trí nhỏ cho đến cả một tấm thảm lớn.

        <h4>4. Gỗ</h4>
      Không phải là một chất liệu dễ dàng để xử lý và tạo hình nhưng gỗ vẫn được ưa chuộng vì sự thô mộc đặc biệt của nó.
          <h4>6. Hạt, cúc áo</h4>
            Hạt đá, hạt nhựa,hạt gốm, hạt cườm bên cạnh cúc nhựa nhiều màu và cúc gỗ đề là những thành phần quen thuộc trong danh sách nguyên liệu của rất nhiều sản phẩm handmade đặc biệt là vòng tay.
            <h4>7. Vải da, dây da</h4>
      Trào lưu phụ kiện bằng da đã quay trở lại trong thời gian gần đây. Với vô vàn màu sắc và chủng loại để lựa chọn và kết hợp, chất liệu với vẻ ngoài tưởng chừng đơn điệu này có thể có những biến hóa khác lạ, đầy cá tính.Hạt đá, hạt nhựa,hạt gốm, hạt cườm bên cạnh cúc nhựa nhiều màu và cúc gỗ đề là những thành phần quen thuộc trong danh sách nguyên liệu của rất nhiều sản phẩm handmade đặc biệt là vòng tay.
    </div>
        <!-- /Billing Details -->



</div>

      <!-- Order Details -->

      <!-- /Order Details -->

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
            <p>Đây là shop có tên là shop</p>
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
              <li><a href="#">Tài khoản</a></li>
              <li><a href="#">Giỏ hàng</a></li>
              <li><a href="#">Yêu thích</a></li>
              <li><a href="#">Theo dõi đơn hàng</a></li>
              <li><a href="#">Trợ giúp</a></li>
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
