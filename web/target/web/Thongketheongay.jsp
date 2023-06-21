<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/19/2023
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vn.edu.hcmuaf.fit.bean.Invoice" %>
<%@ page import="vn.edu.hcmuaf.fit.service.InvoiceService" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.hcmuaf.fit.service.ThongkeInvoice" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/18/2023
  Time: 10:50 PM
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
    <div class="row">
        <div class="col-sm-3">
            <h1>Mời chọn ngày:</h1>
            <form action="theongay" method="post">
                <input type="date" name="ngay">
                <button class="btn btn-sm btn-defaut" >Thống kê</button>
            </form>
        </div>
        <div class="row" style="float:right">
            <button class="btn btn-info btn-sm" data-toggle="modal" data-target="#bieudotheongay">Xem biểu đồ</button>
            <div class="modal fade" id="bieudotheongay" role="dialog">
                <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="text-align:center">Biểu đồ doanh thu sản phẩm theo ngày</h4>
                        </div>
                        <div class="modal-body">
                                                        <jsp:include page="bieudo/bieudodoanhthutheongay.jsp"></jsp:include>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
    <br>
    <div class="row ">
        <%  ArrayList<Invoice> in = new ThongkeInvoice().thongKeTheoNgayHeThong();
            String ok = (String) session.getAttribute("okngay");
            String ngay= (String) session.getAttribute("ngay");


            if(ok!=null){
                if(ok.equals("ok")){
                    in=new ThongkeInvoice().thongKeTheoNgay(ngay);
                }else{
                    in=new ThongkeInvoice().thongKeTheoNgayHeThong();
                }
            } %>
        <%double total=0;for(Invoice t1 : in){total+=t1.getTotal();}%>
        <p>Tổng doanh thu có được: <%= total%> VND</p>
        <table id="datatable-buttons" class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>STT</th>
                <th>MÃ HÓA ĐƠN</th>
                <th>TÊN USER</th>
                <th>SDT</th>
                <th>Doanh thu</th>
                <th>Ngày</th>
            </tr>
            </thead>
            <tbody>
            <%int count=0;for(Invoice ts : in){ count++;%>
            <TR>
                <TD> <%= count%></td>
                <TD> <%= ts.getIdIn()%></TD>
                <TD> <%= ts.getNameuser()%></TD>
                <TD> <%= ts.getPhone()%></TD>
                <TD> <%= ts.getTotal()%></TD>
                <TD> <%= ts.getDatecreate()%></TD>
                <%--                <TD> <%= ts.getGia() %></TD>--%>
                <%--                <TD> <%= ts.getSoLuong()%></TD>--%>
                <%--                <TD> <%=ts.getDoanhThu()%></TD>--%>
                <%--                <TD> <%=ts.getNgay()%></TD>--%>
            </TR>
            <%} %>
            </tbody>
        </table>

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

