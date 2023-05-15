<%@ page import="vn.edu.hcmuaf.fit.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.UserDao" %>
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

<title>Admin - Quản lý User</title>
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
        <li><a href="/index"><b>Đăng xuất <i class="fas fa-sign-out-alt"></i></b></a></li>
        <li><a href="/adminpage" >Admin</a></li>
      </ul>
    </div>
  </div>
</nav>
<div class="container-fluid al">
  <div id="clock"></div>
  <Br>
  <p class="timkiemnhanvien"><b>TÌM KIẾM TÊN :</b></p><Br><Br>
<%--  <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Nhập tên TÊN cần tìm...">--%>
  <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Tìm kiếm theo tên người dùng...">
<%--  <button type="button">Tìm kiếm</button>--%>
  <i class="fa fa-search" aria-hidden="true"></i>

  <b>CHỨC NĂNG CHÍNH:</b><Br>
  <button class="nv xuat" data-toggle="tooltip" data-placement="top" title="Xuất File"><i
          class="fas fa-file-import"></i></button>

  <a href="AddUser.jsp"> <button class="nv nhap" data-toggle="tooltip" data-placement="top" title="Add User"
                                 onclick="document.getElementById('add-user-form').style.display='block'">
    <i class="fa-solid fa-plus"></i></button> </a>

  <div class="table-title">
    <div class="row">

    </div>

  </div>
  <table class="table table-bordered" id="myTable">
    <thead>
    <tr class="ex">

      <th>ID</th>
      <th>Tên người dùng</th>
      <th>Email</th>
      <th>Mật khẩu</th>
      <th>Số điện thoại</th>
      <th>Ngày đăng ký</th>
      <th>Vai trò</th>
      <th>Trạng thái hoạt động</th>
      <th>Thao tác</th>


    </tr>
    </thead>
    <tbody>
    <%
      int roleUs = 1; // assume roleUs is 1

      // Lấy danh sách user từ database
      List<User> listUser = UserDao.getAllUsers();

      // Hiển thị danh sách user
      for (User user : listUser) {
    %>
    <tr>
      <td><%= user.getIdUser() %></td>
      <td><%= user.getNameUser() %></td>
      <td><%= user.getEmailUs() %></td>
      <td><%= user.getPass() %></td>
      <td><%= user.getPhone() %></td>
      <td><%= user.getRegistrationDate() %></td>
      <td><%= user.getRoleUs() == 1 ? "Admin" : "Khách hàng" %></td>
      <td><%= user.getActive() ==1 ?  "Hoạt động" : "Không hoạt động" %></td>

      <td>
          <form action="EditUser.jsp" method="post">
            <button type="submit" name="user">Sửa</button>
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
<%--  thực hiện phân trang--%>
  <script type="text/javascript">
    var pager = new Pager('myTable', 3);
    pager.init();
    pager.showPageNav('pager', 'pageNavPosition');
    pager.showPage(1);
  </script>
</div>

<script src="jquery.min.js"></script>
<script type="text/javascript">

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
// tim kiem
  function searchUser() {
    // Lấy giá trị từ ô tìm kiếm
    var input = document.getElementById("myInput");
    var filter = input.value.toUpperCase();

    // Lấy bảng và các hàng trong bảng
    var table = document.getElementById("myTable");
    var tr = table.getElementsByTagName("tr");

    // Duyệt qua các hàng trong bảng và ẩn các hàng không khớp với giá trị tìm kiếm
    for (var i = 0; i < tr.length; i++) {
      var td = tr[i].getElementsByTagName("td")[1];
      if (td) {
        var txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

  // tim kiem theo ten
  function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
      td = tr[i].getElementsByTagName("td")[1];
      if (td) {
        txtValue = td.textContent || td.innerText;
        if (txtValue.toUpperCase().indexOf(filter) > -1) {
          tr[i].style.display = "";
        } else {
          tr[i].style.display = "none";
        }
      }
    }
  }

</script>

</body>

</html>
