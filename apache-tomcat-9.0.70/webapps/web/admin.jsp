<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ShopHandMade</title>
    <!-- Bootstrap -->
    <link href="vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a class="site_title"><i class="fa fa-angellist"></i> <span>ShopHandMade</span></a>
                </div>
                <div class="clearfix"></div>
                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="image/ntt.png" alt="..." class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>Xin chào,</span>
                        <h2>ShopNtt</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->
                <br/>
                <!-- sidebar menu -->
                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <ul class="nav side-menu">
                            <li><a><i class="fa fa-home"></i>Trang chủ<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="productdream.html">Dreamcatcher</a></li>
                                    <li><a href="productsp.html">Móc khóa</a></li>
                                    <li><a href="productmockhoa.html">Ốp lưng</a></li>
                                    <li><a href="productmockhoa.html">Sản phẩm khác</a></li>
                                    <li><a href="productmockhoa.html">Thiệp</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-edit"></i>Quản lý<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="general_elements.html">Quản lý nhân viên</a></li>
                                    <li><a href="http://localhost:8080/manageControl">Quản lý sản phẩm</a></li>
                                    <li><a href="typography.html">Quản lý hóa đơn</a></li>
                                    <li><a href="icons.html">Quản lý khách hàng</a></li>
                                    <li><a href="glyphicons.html">Quản lý nguyên liệu</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-bar-chart-o"></i>Báo cáo<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="chartjs.html">Báo cáo bán hàng</a></li>
                                    <li><a href="chartjs2.html">Báo cáo nhân viên</a></li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-user"></i>Tài khoản<span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="#">Thay đổi thông tin</a></li>
                                    <li><a href="index.jsp">Thoát</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->
                <!-- /menu footer buttons -->
                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="Cài đặt">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Toàn màn hình">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Khóa">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="Đăng xuất" href="">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>
                <!-- /menu footer buttons -->
            </div>
        </div>
        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open" style="padding-left: 15px;">
                            <a href="javascript:;" class="user-profile dropdown-toggle" aria-haspopup="true"
                               id="navbarDropdown" data-toggle="dropdown" aria-expanded="false">
                                <img src="image/ntt.png" alt="">ShopNtt
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="javascript:;">Hồ sơ</a>
                                <a class="dropdown-item" href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Cài đặt</span>
                                </a>
                                <a class="dropdown-item" href="javascript:;">Trợ giúp</a>
                                <a class="dropdown-item" href=""><i class="fa fa-sign-out pull-right"></i>Đăng
                                    xuất</a>
                            </div>
                        </li>

                        <li role="presentation" class="nav-item dropdown open">
                            <a href="javascript:;" class="dropdown-toggle info-number" id="navbarDropdown1"
                               data-toggle="dropdown" aria-expanded="false">
                                <i class="fa fa-envelope-o"></i>
                                <span class="badge bg-green">6</span>
                            </a>
                            <ul class="dropdown-menu list-unstyled msg_list" role="menu"
                                aria-labelledby="navbarDropdown1">
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="image/avt1.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>Quỳnh Như</span>
                            <span class="time">3 phút trước</span>
                          </span>
                                        <span class="message">
                            Tôi muốn đặt làm ốp lưng theo yêu cầu...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="image/avt2.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>Thanh Thuận</span>
                            <span class="time">5 phút trước</span>
                          </span>
                                        <span class="message">
                            Tôi hy vọng sản phẩm sẽ đẹp như mong đợi...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="image/avt3.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>Ngọc Trân</span>
                            <span class="time">11 phút trước</span>
                          </span>
                                        <span class="message">
                            Shop nhớ giao đủ đồ trong bộ đó nha...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="dropdown-item">
                                        <span class="image"><img src="image/avt4.jpg" alt="Profile Image"/></span>
                                        <span>
                            <span>Kim Tuyết</span>
                            <span class="time">15 phút trước</span>
                          </span>
                                        <span class="message">
                            Tôi muốn đặt làm 1 cái dreamcatcher...
                          </span>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <div class="text-center">
                                        <a class="dropdown-item">
                                            <strong>Xem tất cả</strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->
        <!-- page content -->
        <div class="right_col" role="main">
            <!-- top tiles -->
            <div class="row" style="display: inline-block;">
                <div class="tile_count">
                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i>Tổng số người dùng</span>
                        <div class="count">10</div>
                        <span class="count_bottom"><i class="green">1.5% </i>Từ tuần trước</span>
                    </div>
                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-clock-o"></i>Thời gian trung bình</span>
                        <div class="count">50.10</div>
                        <span class="count_bottom"><i class="green"><i
                                class="fa fa-sort-asc"></i>2% </i>Từ tuần trước</span>
                    </div>
                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i>Tổng số nam giới</span>
                        <div class="count">2</div>
                        <span class="count_bottom"><i class="red"><i
                                class="fa fa-sort-desc"></i>1% </i>Từ tuần trước</span>
                    </div>
                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i>Tổng số nữ giới</span>
                        <div class="count green">5</div>
                        <span class="count_bottom"><i class="green"><i
                                class="fa fa-sort-asc"></i>1.5% </i>Từ tuần trước</span>
                    </div>
                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Tổng số khác</span>
                        <div class="count">3</div>
                        <span class="count_bottom"><i class="green"><i
                                class="fa fa-sort-asc"></i>1% </i>Từ tuần trước</span>
                    </div>
                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i>Tổng số kết nối</span>
                        <div class="count">10</div>
                        <span class="count_bottom"><i class="green"><i class="fa fa-sort-asc"></i>1.5% </i> Từ tuần trước</span>
                    </div>
                </div>
            </div>
            <!-- /top tiles -->
            <div class="row">
                <div class="col-md-12 col-sm-12 ">
                    <div class="dashboard_graph">
                        <div class="row x_title">
                            <div class="col-md-6">
                                <h3>Hoạt động</h3>
                            </div>
                        </div>
                        <div class="col-md-9 col-sm-9 ">
                            <div id="chart_plot_01" class="demo-placeholder"></div>
                        </div>
                        <div class="col-md-3 col-sm-3  bg-white">
                            <div class="x_title">
                                <h2>Hiệu suất hàng đầu</h2>
                                <div class="clearfix"></div>
                            </div>

                            <div class="col-md-12 col-sm-12 ">
                                <div>
                                    <p>Facebook</p>
                                    <div class="">
                                        <div class="progress progress_sm" style="width: 76%;">
                                            <div class="progress-bar bg-green" role="progressbar"
                                                 data-transitiongoal="80"></div>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <p>Twitter</p>
                                    <div class="">
                                        <div class="progress progress_sm" style="width: 76%;">
                                            <div class="progress-bar bg-green" role="progressbar"
                                                 data-transitiongoal="60"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12 col-sm-12 ">
                                <div>
                                    <p>Phương tiện truyền thông khác</p>
                                    <div class="">
                                        <div class="progress progress_sm" style="width: 76%;">
                                            <div class="progress-bar bg-green" role="progressbar"
                                                 data-transitiongoal="40"></div>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <p>Website</p>
                                    <div class="">
                                        <div class="progress progress_sm" style="width: 76%;">
                                            <div class="progress-bar bg-green" role="progressbar"
                                                 data-transitiongoal="50"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
            </div>
            <br/>
            <div class="row">
                <!-- End to do list -->
            </div>
        </div>
    </div>
</div>
<!-- /page content -->
</div>
</div>

<!-- jQuery -->
<script src="vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="vendors/Chart.js/dist/Chart.min.js"></script>
<!-- jQuery Sparklines -->
<script src="vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- morris.js -->
<script src="vendors/raphael/raphael.min.js"></script>
<script src="vendors/morris.js/morris.min.js"></script>
<!-- gauge.js -->
<script src="vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- Skycons -->
<script src="vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="vendors/Flot/jquery.flot.js"></script>
<script src="vendors/Flot/jquery.flot.pie.js"></script>
<script src="vendors/Flot/jquery.flot.time.js"></script>
<script src="vendors/Flot/jquery.flot.stack.js"></script>
<script src="vendors/Flot/jquery.flot.resize.js"></script>
<!-- Flot plugins -->
<script src="vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="vendors/DateJS/build/date.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="vendors/moment/min/moment.min.js"></script>
<script src="vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>

</body>
</html>