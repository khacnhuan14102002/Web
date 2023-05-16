package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import vn.edu.hcmuaf.fit.service.DetailInvoiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "detailinvoice", value = "/detailinvoice")
public class DetailInvoiveControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DetailInvoiceService detail = new DetailInvoiceService();
        String idinvoice = request.getParameter("Idinvoice");
        int invoiceid =0;
        try{
            invoiceid = Integer.parseInt(idinvoice);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        ArrayList<DetailInvoice> listde = detail.getAllIn(invoiceid);


        request.setAttribute("listde",listde);
       request.getRequestDispatcher("DetailHistory.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
