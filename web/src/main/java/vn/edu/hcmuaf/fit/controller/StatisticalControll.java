package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.service.ThongkeInvoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "statistical", value = "/statistical")
public class StatisticalControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ngayBatDau = request.getParameter("ngayBatDau");
        String ngayKetThuc = request.getParameter("ngayKetThuc");
        List<Invoice> list = new ThongkeInvoice().getAllInbyDate(ngayBatDau, ngayKetThuc);
        String okkn ="none";
        if(list.size()!=0){
            okkn="ok";
        }
        HttpSession session = request.getSession();
        session.setAttribute("okkn", okkn);
        session.setAttribute("ngayBatDau", ngayBatDau);
        session.setAttribute("ngayKetThuc", ngayKetThuc);
        response.sendRedirect("Thongketheokhoangngay.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

