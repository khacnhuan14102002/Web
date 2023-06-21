package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.service.InvoiceService;
import vn.edu.hcmuaf.fit.service.ThongkeInvoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "theothang", value = "/theothang")
public class TheothangControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String month = request.getParameter("thang");
        ThongkeInvoice in = new ThongkeInvoice();
        List<Invoice> list = in.getAllMonth((month));
        String okthang ="none";
        if(list.size()!=0){
            okthang="ok";
        }
        HttpSession session = request.getSession();
        session.setAttribute("okthang", okthang);
        session.setAttribute("month", month);
        response.sendRedirect("Thongketheothang.jsp");
//        request.getRequestDispatcher("Thongketheothang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
