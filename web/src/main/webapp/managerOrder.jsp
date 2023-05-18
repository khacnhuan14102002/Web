<%@ page import="vn.edu.hcmuaf.fit.bean.Invoice" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Kim_Tuyet
  Date: 5/15/2023
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin - Quản lý Hóa đơn</title>
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
                    <h2>Quản lý Hóa Đơn</h2>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>
                    <span class="custom-checkbox">
                        <input type="checkbox" id="selectAll">
                        <label for="selectAll"></label>
                    </span>
                </th>
                <th>Mã hóa đơn</th>
                <th>Mã khách hàng</th>
                <th>Tên khách hàng</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>Tổng tiền</th>
                <th>Phương thức <br>thanh toán</th>
                <th>Ngày đặt hàng</th>
                <th>Trạng thái</th>
            </tr>
            </thead>
            <tbody>
            <%
                List<Invoice> listI = (List<Invoice>) request.getAttribute("listI");
                for (Invoice in_voice : listI) {
            %>
            <tr>
                <td>
                        <span class="custom-checkbox">
                            <input type="checkbox" id="checkbox1" name="options[]" value="1">
                            <label for="checkbox1"></label>
                        </span>
                </td>
                <td class="invoice-IdIn-<%=in_voice.getIdIn()%>"><%=in_voice.getIdIn()%>
                </td>
                <td class="invoice-IdUs-<%=in_voice.getIdIn()%>"><%=in_voice.getIdUs()%>
                </td>
                <td class="invoice-NameUs-<%=in_voice.getIdIn()%>"><%=in_voice.getNameuser()%>
                </td>
                <td class="invoice-Address-<%=in_voice.getIdIn()%>"><%=in_voice.getAddress()%>
                </td>
                <td class="invoice-N_phone-<%=in_voice.getIdIn()%>"><%=in_voice.getPhone()%>
                </td>
                <td class="invoice-Total-<%=in_voice.getIdIn()%>"><%=in_voice.getTotal()%>
                </td>
                <td class="invoice-Type-<%=in_voice.getIdIn()%>"><%=in_voice.getType()%>
                </td>
                <td class="invoice-Date-<%=in_voice.getIdIn()%>"><%=in_voice.getDatecreate()%>
                </td>
                <td class="invoice-Status-<%=in_voice.getIdIn()%>"><%=in_voice.getStatusIn()%>
                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
        <div class="clearfix">
            <ul class="pagination">
                <li class="page-item active"><a href="#" class="page-link">1</a></li>
            </ul>
        </div>
    </div>
    <a href="/adminpage">
        <button type="button" class="btn btn-primary">Trở về</button>
    </a>
</div>
<script src="build/js/manager.js" type="text/javascript"></script>
</body>
</html>
