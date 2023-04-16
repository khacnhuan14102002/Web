<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.hcmuaf.fit.service.QuanLyUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<%--<head>--%>
  <meta charset="UTF-8">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<%--  <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--  <meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
<%--<!--  <meta name="author" content="Bin-It">-->--%>
<%--<!--  <meta property="og:url" />-->--%>
<%--<!--  <meta property="og:type" content="truongbinit" />-->--%>
<%--<!--  <meta property="og:title" content="Website TruongBin" />-->--%>
<%--<!--  <meta property="og:description" content="Wellcome to my Website" />-->--%>

  <title> Quan Ly User</title>
<!--  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"-->
<!--        integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<!--  <link rel="stylesheet" href="css/font-awesome.min.css">-->
  <!--===============================================================================================-->
  <link rel="stylesheet" href="css/QuanLyUser.css">
  <!-- Latest compiled and minified CSS -->
  <!--===============================================================================================-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <!-- jQuery library -->
  <!--===============================================================================================-->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <!--===============================================================================================-->
  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <!--===============================================================================================-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.min.css">
  <!--===============================================================================================-->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-sweetalert/1.0.1/sweetalert.js"></script>
  <!--===============================================================================================-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Open+Sans">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <!--===============================================================================================-->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/6.4.0/css/font-awesome.min.css">


  <script type="text/javascript">
    //Phân Trang Cho Table
    function Pager(tableName, itemsPerPage) {
      this.tableName = tableName;
      this.itemsPerPage = itemsPerPage;
      this.currentPage = 1;
      this.pages = 0;
      this.inited = false;

      this.showRecords = function (from, to) {
        var rows = document.getElementById(tableName).rows;
        for (var i = 1; i < rows.length; i++) {
          if (i < from || i > to)
            rows[i].style.display = 'none';
          else
            rows[i].style.display = '';
        }
      }

      this.showPage = function (pageNumber) {
        if (!this.inited) {
          alert("not inited");
          return;
        }
        var oldPageAnchor = document.getElementById('pg' + this.currentPage);
        oldPageAnchor.className = 'pg-normal';

        this.currentPage = pageNumber;
        var newPageAnchor = document.getElementById('pg' + this.currentPage);
        newPageAnchor.className = 'pg-selected';

        var from = (pageNumber - 1) * itemsPerPage + 1;
        var to = from + itemsPerPage - 1;
        this.showRecords(from, to);
      }

      this.prev = function () {
        if (this.currentPage > 1)
          this.showPage(this.currentPage - 1);
      }

      this.next = function () {
        if (this.currentPage < this.pages) {
          this.showPage(this.currentPage + 1);
        }
      }

      this.init = function () {
        var rows = document.getElementById(tableName).rows;
        var records = (rows.length - 1);
        this.pages = Math.ceil(records / itemsPerPage);
        this.inited = true;
      }
      this.showPageNav = function (pagerName, positionId) {
        if (!this.inited) {
          alert("not inited");
          return;
        }
        var element = document.getElementById(positionId);

        var pagerHtml = '<span onclick="' + pagerName +
                '.prev();" class="pg-normal">&#171</span> | ';
        for (var page = 1; page <= this.pages; page++)
          pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName +
                  '.showPage(' + page + ');">' + page + '</span> | ';
        pagerHtml += '<span onclick="' + pagerName + '.next();" class="pg-normal">&#187;</span>';

        element.innerHTML = pagerHtml;
      }
    }
  </script>
  <link rel="stylesheet" href="../../src/main/webapp/css/bootstrap.min.css">
</head>

<body onload="time()">
<script>
  swal("Xin Chào", "Chúc Bạn 1 Ngày Tốt Lành Nhé", "");
</script>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <i class="fas fa-bars"></i>
      </button>
      <a class="navbar-brand" href="#"><i class="fa fa-user-circle" aria-hidden="true"></i> QUẢN
        LÝ USER</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="#home" >USER</a></li>
        </li>
        <li><a href="/index.jsp"><b>Đăng xuất <i class="fas fa-sign-out-alt"></i></b></a></li>
        <li><a href="/admin.jsp" >Admin</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid al">
  <div id="clock"></div>
  <Br>
  <p class="timkiemnhanvien"><b>TÌM KIẾM TÊN :</b></p><Br><Br>
  <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Nhập tên TÊN cần tìm...">
  <i class="fa fa-search" aria-hidden="true"></i>

  <b>CHỨC NĂNG CHÍNH:</b><Br>
  <button class="nv xuat" data-toggle="tooltip" data-placement="top" title="Xuất File"><i
          class="fas fa-file-import"></i></button>

 <a href="AddUser.jsp"> <button class="nv xuat" data-toggle="tooltip" data-placement="top" title="Add User"
          onclick="document.getElementById('add-user-form').style.display='block'">
   <i class="fa-solid fa-plus"></i></button> </a>

  <div class="table-title">
    <div class="row">

    </div>

  </div>
  <table class="table table-bordered" id="myTable">
    <thead>
    <tr class="ex">
      <th width="auto">Mã USER</th>
      <th width="auto">Tên USER</th>
      <th>Email</th>
      <th>Số điện thoại</th>
      <th>Ngày đăng kí</th>
      <th>Vai trò</th>
      <th width="5px; !important">Tính Năng</th>
    </tr>
    </thead>
    <tbody>
<%
  int roleUs = 1; // assume roleUs is 1

  // Lấy danh sách user từ database
  List<User> listUser = QuanLyUser.getAllUsers();

  // Hiển thị danh sách user
  for (User user : listUser) {
%>
<tr>
  <td><%= user.getIdUser() %></td>
  <td><%= user.getNameUser() %></td>
  <td><%= user.getEmailUs() %></td>
  <td><%= user.getPhone() %></td>
  <td><%= user.getRegistrationDate() %></td>
  <td><% if (user.getRoleUs() == 1) { %>
    admin
    <% } else { %>
    khách hàng
    <% } %>
  </td>

  <td>
    <form method="post" action="QuanLyUserControl">
      <input type="hidden" name="idUser" value="<%= user.getIdUser() %>" />
      <input type="hidden" name="command" value="edit" />
      <button type="submit">Sửa</button>
    </form>

    <form method="post" action="deleteUser">
      <input type="hidden" name="idUser" value="<%= user.getIdUser() %>" />
      <input type="hidden" name="command" value="delete" />
      <button type="submit" onclick="return confirm('Bạn có chắc muốn xóa user này không?')">Xóa</button>

    </form>
  </td>
</tr>
<!-- Edit Modal HTML -->
<%
  }
%>
    </tbody>
  </table>
  <div id="pageNavPosition" class="text-right"></div>
  <script type="text/javascript">
    var pager = new Pager('myTable', 3);
    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);
  </script>
</div>

<script src="jquery.min.js"></script>
<script type="text/javascript">
  //Tìm kiếm
  function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[0];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";  }}}}
  //Lọc bảng
  // function sortTable() {
  //   var table, rows, switching, i, x, y, shouldSwitch;
  //   table = document.getElementById("myTable");
  //   switching = true;
  //   while (switching) {
  //     switching = false;
  //     rows = table.rows;
  //     for (i = 1; i < (rows.length - 1); i++) {
  //       shouldSwitch = false;
  //       x = rows[i].getElementsByTagName("TD")[0];
  //       y = rows[i + 1].getElementsByTagName("TD")[0];
  //       if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
  //         shouldSwitch = true;
  //         break;
  //       }
  //     }
  //     if (shouldSwitch) {
  //       rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
  //       switching = true;
  //       swal("Thành Công!", "Bạn Đã Lọc Thành Công", "success");
  //     }
  //   }
  // }
  //Thời Gian
  function time() {
    var today = new Date();
    var weekday = new Array(7);
    weekday[0] = "Chủ Nhật";
    weekday[1] = "Thứ Hai";
    weekday[2] = "Thứ Ba";
    weekday[3] = "Thứ Tư";
    weekday[4] = "Thứ Năm";
    weekday[5] = "Thứ Sáu";
    weekday[6] = "Thứ Bảy";
    var day = weekday[today.getDay()];
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    m = checkTime(m);
    s = checkTime(s);
    nowTime = h + ":" + m + ":" + s;
    if (dd < 10) {
      dd = '0' + dd
    }
    if (mm < 10) {
      mm = '0' + mm
    }
    today = day + ', ' + dd + '/' + mm + '/' + yyyy;
    tmp = '<i class="fa fa-clock-o" aria-hidden="true"></i> <span class="date">' + today + ' | ' + nowTime +
            '</span>';
    document.getElementById("clock").innerHTML = tmp;
    clocktime = setTimeout("time()", "1000", "Javascript");

    function checkTime(i) {
      if (i < 10) {
        i = "0" + i;
      }
      return i;
    }
  }

<%--  //Thêm--%>
<%--  // $(document).ready(function () {--%>
<%--  //   $('[data-toggle="tooltip"]').tooltip();--%>
<%--  //   var actions = $("table td:last-child").html();--%>
<%--  //   $(".add-new").click(function () {--%>
<%--  //     $(this).attr("disabled", "disabled");--%>
<%--  //     var index = $("table tbody tr:last-child").index();--%>
<%--  //     var row = '<tr>' +--%>
<%--  //             '<td><input type="text" class="form-control" name="name" id="name" placeholder="Nhập Tên"></td>' +--%>
<%--  //             '<td><input type="text" class="form-control" name="gioitinh" id="gioitinh" placeholder="Nhập Giới Tính"></td>' +--%>
<%--  //             '<td><input type="text" class="form-control" name="namsinh" id="namsinh" value="" placeholder="Nhập Ngày Sinh"></td>' +--%>
<%--  //             '<td><input type="text" class="form-control" name="diachi" id="diachi" value="" placeholder="Nhập hóa đơn"></td>' +--%>
<%--  //             '<td><input type="text" class="form-control" name="chucvu" id="chucvu" value="" placeholder="Nhập Chức Vụ"></td>' +--%>
<%--  //             '<td>' + actions + '</td>' +--%>
<%--  //             '</tr>';--%>
<%--  //     $("table").append(row);--%>
<%--  //     $("table tbody tr").eq(index + 1).find(".add, .edit").toggle();--%>
<%--  //     $('[data-toggle="tooltip"]').tooltip();--%>
<%--  //   });--%>
<%--  //   //Kiểm tra rỗng--%>
<%--  //   $(document).on("click", ".add", function () {--%>
<%--  //     var empty = false;--%>
<%--  //     var input = $(this).parents("tr").find('input[type="text"]');--%>
<%--  //     input.each(function () {--%>
<%--  //       if (!$(this).val()) {--%>
<%--  //         $(this).addClass("error");--%>
<%--  //         swal("Thông Báo!", "Dữ Liệu Trống Vui Lòng Kiểm Tra", "error");--%>
<%--  //         empty = true;--%>
<%--  //       } else {--%>
<%--  //         $(this).removeClass("error");--%>
<%--  //         swal("Thông Báo!", "Bạn Chưa Nhập Dữ Liệu", "warning");--%>
<%--  //       }--%>
<%--  //     });--%>
<%--  //     $(this).parents("tr").find(".error").first().focus();--%>
<%--  //     if (!empty) {--%>
<%--  //       input.each(function () {--%>
<%--  //         $(this).parent("td").html($(this).val());--%>
<%--  //         swal("Thành Công", "Bạn Đã Cập Nhật Thành Công", "success");--%>
<%--  //       });--%>
<%--  //       $(this).parents("tr").find(".add, .edit").toggle();--%>
<%--  //       $(".add-new").removeAttr("disabled");--%>
<%--  //     }--%>
<%--  //   });--%>
<%--  //   // Sửa--%>
<%--  //   $(document).on("click", ".edit", function () {--%>
<%--  //     $(this).parents("tr").find("td:not(:last-child)").each(function () {--%>
<%--  //       $(this).html('<input type="text" class="form-control" value="' + $(this)--%>
<%--  //               .text() + '">');--%>
<%--  //     });--%>
<%--  //     $(this).parents("tr").find(".add, .edit").toggle();--%>
<%--  //     $(".add-new").attr("disabled", "disabled");--%>
<%--  //   });--%>
<%--  //   jQuery(function () {--%>
<%--  //     jQuery(".add").click(function () {--%>
<%--  //       swal("Thành Công!", "Bạn Đã Sửa Thành Công", "success");--%>
<%--  //     });--%>
<%--  //   });--%>
<%--  //   // Xóa--%>
<%--  //   $(document).on("click", ".delete", function () {--%>
<%--  //     $(this).parents("tr").remove();--%>
<%--  //     swal("Thành Công!", "Bạn Đã Xóa Thành Công", "success");--%>
<%--  //     $(".add-new").removeAttr("disabled");--%>
<%--  //   });--%>
<%--  // });--%>
<%--  //Tool tip--%>
<%--  $(document).ready(function () {--%>
<%--    $('[data-toggle="tooltip"]').tooltip();--%>
<%--  });--%>
</script>

</body>

</html>
