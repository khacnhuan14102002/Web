package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.service.InvoiceService;
import vn.edu.hcmuaf.fit.service.ThongkeInvoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "doanhthu", value = "/doanhthu")
public class DoanhthuControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThongkeInvoice in = new ThongkeInvoice();
        List<Invoice> listi=
                in.getAllInvoice();
        double price = 0;


        request.setAttribute("listi", listi);

        request.getRequestDispatcher("Doanhthu.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
