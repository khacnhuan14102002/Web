package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.service.InvoiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "doanhthutheoThu", value = "/doanhthutheoThu")
public class DoanhThuThuControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        InvoiceService in = new InvoiceService();
        double totalMoney1 = in.totalMoneyDay(1);
        double totalMoney2 = in.totalMoneyDay(2);
        double totalMoney3 = in.totalMoneyDay(3);
        double totalMoney4 = in.totalMoneyDay(4);
        double totalMoney5 = in.totalMoneyDay(5);
        double totalMoney6 = in.totalMoneyDay(6);
        double totalMoney7 = in.totalMoneyDay(7);



        request.setAttribute("totalMoney1", totalMoney1);
        request.setAttribute("totalMoney2", totalMoney2);
        request.setAttribute("totalMoney3", totalMoney3);
        request.setAttribute("totalMoney4", totalMoney4);
        request.setAttribute("totalMoney5", totalMoney5);
        request.setAttribute("totalMoney6", totalMoney6);
        request.setAttribute("totalMoney7", totalMoney7);



        request.getRequestDispatcher("DoanhThuTheoThu.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
