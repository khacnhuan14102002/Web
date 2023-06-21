<%@ page import="vn.edu.hcmuaf.fit.bean.Invoice" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/15/2023
  Time: 6:20 PM
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
  <div class="row">
    <jsp:include page="header.jsp"></jsp:include>
  </div>
  <br>
  <div class="row">

    <table id="datatable-buttons" class="table table-striped table-bordered">
      <thead>
      <tr>
        <th>STT</th>
        <th>Mã hóa đơn</th>
        <th>Doanh thu</th>
        <th>Ngày</th>
      </tr>
      </thead>
      <%
        int count = 0;
        List<Invoice> listI = (List<Invoice>) request.getAttribute("listi");
        for (Invoice in_voice : listI) {
          count +=1;

      %>
      <tbody>
      <%--            <td></td>--%>
      <%--            <%int count=0;for(TraSua ts : mapTS.values()){ count++;%>--%>
      <%--            <TR>--%>
      <TD> <%=count%></td>
      <td> <%=in_voice.getIdIn()%></td>
      <td><%=in_voice.getTotal()%></td>
      <td><%=in_voice.getDatecreate()%></td>
      <%--                <TD> <%=ts.getDoanhThu()%></TD>--%>
      <%--                <TD> <%=ts.getNgay()%></TD>--%>
      <%--            </TR>--%>
      <%--            <%} %>--%>
      </tbody>
      <%}%>
    </table>

    <p>Tổng doanh thu có được: ${sum} VND</p>
  </div>
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


<!-- Custom Theme Scripts -->
<script src="build/js/custom.min.js"></script>
</html>
