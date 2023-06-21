package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.service.InvoiceService;
import vn.edu.hcmuaf.fit.service.ThongkeInvoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "theongay", value = "/theongay")
public class TheongayControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ngay = request.getParameter("ngay");
        ThongkeInvoice in = new ThongkeInvoice();
        List<Invoice> list = in.getAllMonth((ngay));
        String okngay ="none";
        double price = 0;
        if(list.size()!=0){
            okngay="ok";
        }


        request.setAttribute("sum", price);
        HttpSession session = request.getSession();
        session.setAttribute("okngay", okngay);
        session.setAttribute("ngay", ngay);
        response.sendRedirect("Thongketheongay.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
