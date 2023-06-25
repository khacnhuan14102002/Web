<%@ page import="java.util.List" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.*" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.category" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.Log" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 1/7/2023
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Log Login
  </title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
  <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <link href="build/css/manager.css" rel="stylesheet" type="text/css"/>
</head>
<style>
  img {
    width: 200px;
    height: 120px;
  }
</style>
<body>
<div class="container">

  <div class="table-wrapper">
    <div class="table-title">
      <div class="row">
        <div class="col-sm-6">
          <h2>Báo cáo sản phẩm</h2>
        </div>
        <div class="col-sm-6">
          <p>Tổng doanh thu có được: ${sum} VND</p>
          <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
            Excel
          </button>
        </div>
      </div>
    </div>
    <table id="datatable-buttons" class="table table-striped table-bordered">
      <thead>
      <tr>
        <th>STT</th>
        <th>Mã Sản phẩm</th>
        <th>Tên sản phẩm</th>
        <th>Số lượng đã bán</th>
        <th>Doanh thu</th>
      </tr>
      </thead>
      <%
        int count = 0;
        List<products> listI = (List<products>) request.getAttribute("listpro");
        List<Soluongbanra> listsl = (List<Soluongbanra>) request.getAttribute("listsl");
        double total =0;
        for (Soluongbanra sl : listsl) {
          for(products p : listI){
            if(sl.getProductID()==p.getIdProduct()){
              count +=1;


      %>
      <tbody>
      <%--            <td></td>--%>
      <%--            <%int count=0;for(TraSua ts : mapTS.values()){ count++;%>--%>
      <%--            <TR>--%>
      <TD> <%=count%></td>
      <td> <%=sl.getProductID()%></td>
      <td><%=p.getNameProduct()%></td>
      <td><%=sl.getSoLuongDaBan()%></td>
      <td><%=sl.getSoLuongDaBan()*p.getPriceNew()%> VND</td>
      <%--                <TD> <%=ts.getDoanhThu()%></TD>--%>
      <%--                <TD> <%=ts.getNgay()%></TD>--%>
      <%--            </TR>--%>
      <%--            <%} %>--%>
      </tbody>
      <%}%>
      <%}%>
      <%}%>
    </table>



    <%--        <div class="clearfix">--%>
    <%--            <ul class="pagination">--%>
    <%--                <c:forEach begin="1" end="${requestScope.endP}" var="i">--%>
    <%--                    <li class="${tag==i?"active":""}"><a href="log?page=${i}">${i}</a></li>--%>
    <%--                </c:forEach>--%>
    <%--            </ul>--%>
    <%--        </div>--%>
  </div>
  <a href="/adminpage">
    <button type="button" class="btn btn-primary">Trở về</button>
  </a>
  <button id="b1">Báo cáo theo tháng</button>
  <form action="sanphamthang" id="form1" style="display:none;">
    <input type="month" name="thang">
    <button class="btn btn-sm btn-defaut" type="submit">Báo cáo</button>
  </form>
  <button id="b2">Báo cáo theo ngày</button>
  <form action="sanphamngay" id="form2" style="display:none;">
    <input type="date" name="date">
    <button class="btn btn-sm btn-defaut" type="submit">Báo cáo</button>
  </form>
  <button id="b3">Báo cáo theo khoảng ngày</button>
  <form action="sanphamtuychon" id="form3" style="display:none;">
    <h1>Từ ngày:</h1>
    <input type="date" name="ngayBatDau">
    <h1>Đến ngày:</h1>
    <input type="date" name="ngayKetThuc">
    <button class="btn btn-sm btn-defaut" type="submit">Thống kê</button>
  </form>
</div>
<!-- Add Modal HTML -->
<script src="build/js/manager.js" type="text/javascript"></script>
<script>
  const button1 = document.getElementById("b1");
  const button2 = document.getElementById("b2");
  const button3 = document.getElementById("b3");
  const form1 = document.getElementById("form1");
  const form2 = document.getElementById("form2");
  const form3 = document.getElementById("form3");

  button1.addEventListener("click", () => {
    form1.style.display = form1.style.display === "none" ? "block" : "none";
    form2.style.display = "none";
    form3.style.display = "none";
  });

  button2.addEventListener("click", () => {
    form1.style.display = "none";
    form2.style.display = form2.style.display === "none" ? "block" : "none";
    form3.style.display = "none";
  });

  button3.addEventListener("click", () => {
    form1.style.display = "none";
    form2.style.display = "none";
    form3.style.display = form3.style.display === "none" ? "block" : "none";
  });

</script>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>           <form action="/xuatexcelthang" method="get" >
      <div class="modal-body">


        <p>chọn Ngày</p>
        <input type="month" name="thang">


      </div>
      <div class="modal-footer">
        <button class="primary-btn">Xuất</button>
      </div>
    </form>
    </div>
  </div>
</div>
</body>
</html>