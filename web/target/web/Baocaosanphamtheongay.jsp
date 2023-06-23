<%@ page import="vn.edu.hcmuaf.fit.bean.products" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.Soluongbanra" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/22/2023
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Thống kê theo ngày</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <!-- datatable -->
  <link href="vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
  <link href="vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
  <link href="vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
  <link href="vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
  <link href="vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <%--    <div class="row">--%>
  <%--        <jsp:include page="header.jsp"></jsp:include>--%>
  <%--    </div>--%>
  <br>
  <div class="row">


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

    <p>Tổng doanh thu có được: ${sum} VND</p>
  </div>
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
</body>
<!-- jQuery -->
<script src="vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- datatable -->
<script src="vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="vendors/jszip/dist/jszip.min.js"></script>
<script src="vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="vendors/pdfmake/build/vfs_fonts.js"></script>
<%--<script>--%>
<%--  var showFormBtn = document.getElementById("showForm");--%>
<%--  var myForm = document.getElementById("myForm");--%>
<%--  var isShown = false;--%>

<%--  showFormBtn.onclick = function() {--%>
<%--    if (isShown) {--%>
<%--      myForm.style.display = "none";--%>
<%--      isShown = false;--%>
<%--    } else {--%>
<%--      myForm.style.display = "block";--%>
<%--      isShown = true;--%>
<%--    }--%>
<%--  };--%>
<%--</script>--%>
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

<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>
</html>
