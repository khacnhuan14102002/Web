package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.DetailInvoiceService;
import vn.edu.hcmuaf.fit.service.ManagerService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "detailinvoice", value = "/detailinvoice")
public class DetailInvoiveControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DetailInvoiceService detail = new DetailInvoiceService();
        ManagerService mn = new ManagerService();
        String idinvoice = request.getParameter("Idinvoice");
        int invoiceid =0;
        try{
            invoiceid = Integer.parseInt(idinvoice);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        ArrayList<DetailInvoice> listde = detail.getAllIn(invoiceid);
        List<products> p = mn.getAllProduct();
        request.setAttribute("listp",p);
        request.setAttribute("listde",listde);
       request.getRequestDispatcher("DetailHistory.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
