package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.service.InvoiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "historyinvoice", value = "/historyinvoice")
public class HistoryInvoiceControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvoiceService invoice = new InvoiceService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
       List<Invoice> list = invoice.getAllIn(user.getIdUser());


     request.setAttribute("listIn",list);
        request.getRequestDispatcher("Profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
