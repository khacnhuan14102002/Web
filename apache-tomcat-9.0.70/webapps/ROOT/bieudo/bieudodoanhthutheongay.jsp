<%@ page import="vn.edu.hcmuaf.fit.service.ThongkeInvoice" %>
<%@ page import="vn.edu.hcmuaf.fit.bean.Invoice" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 6/19/2023
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <%   ArrayList<Invoice> in = new ThongkeInvoice().thongKeTheoNgayHeThong();
        String ok = (String) session.getAttribute("okngay");
        String ngay= (String) session.getAttribute("ngay");
        if(ok!=null){
            if(ok.equals("ok")){
                in=new ThongkeInvoice().thongKeTheoNgay(ngay);
            }else{
                in=new ThongkeInvoice().thongKeTheoNgayHeThong();
            }
        } %>
    <script type="text/javascript">
        google.charts.load("current", {packages:["corechart"]});
        google.charts.setOnLoadCallback(drawChart);
        function drawChart() {
            // Create a data table with two columns: date and total
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Date');
            data.addColumn('number', 'Total');

            // Add the data rows from the 'in' array
            <%if(in.size()!=0){
            for(Invoice ts:in) { %>
            data.addRow(['<%=ts.getDatecreate()%>', <%=ts.getTotal()%>]);
            <% } %>
<%}%>
            // Set the chart options
            var options = {
                title: 'Total by Date',
                curveType: 'function',
                legend: { position: 'bottom' }
            };

            // Create a new line chart and draw it in the 'chart_div' div
            var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
        <%--function drawChart() {--%>
        <%--    var data = google.visualization.arrayToDataTable([--%>
        <%--        ['Task', 'Hours per Day'],--%>
        <%--        <%int i = 0;--%>
        <%--        if(in.size()!=0){--%>
        <%--            for(Invoice ts:in){--%>
        <%--                i +=ts.getTotal();--%>
        <%--        %>--%>
        <%--        ['<%=ts.getDatecreate()%>',  <%out.print(new ThongkeInvoice().layTongDoanhThuTheoNgay(ts.getDatecreate()));%>],--%>

        <%--        <%}--%>
        <%--      }%>--%>

        <%--    ]);--%>

        <%--    var options = {--%>
        <%--        title: 'Biểu đồ thống kê doanh thu theo ngày',--%>
        <%--        is3D: true,--%>
        <%--    };--%>

        <%--    var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));--%>
        <%--    chart.draw(data, options);--%>
        <%--}--%>
    </script>
</head>
<body>
<div id="piechart_3d" style="width: 900px; height: 500px;"></div>
</body>
</html>
