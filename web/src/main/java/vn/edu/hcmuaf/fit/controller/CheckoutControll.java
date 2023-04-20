package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.DetailInvoice;
import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.ProductCart;
import vn.edu.hcmuaf.fit.service.DetailInvoiceService;
import vn.edu.hcmuaf.fit.service.InvoiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "checkout", value = "/checkout")

public class CheckoutControll extends HttpServlet {
    InvoiceService ins = new InvoiceService();
    DetailInvoiceService details = new DetailInvoiceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String diachi = request.getParameter("address");
        String phone = request.getParameter("tel");
        String phuonthucthanhtoan = request.getParameter("type");
        HttpSession session = request.getSession();
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        int total = 0;
        for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
            total += entry.getValue().quantity * entry.getValue().pro.getPriceNew();

        }
        Date date = new Date();

        Invoice invoice = new Invoice(name, diachi, phuonthucthanhtoan, "null", total, new Timestamp(new Date().getTime()), phone);

        int Invoieid = ins.addInvoice(invoice);
        for (Map.Entry<Integer, ProductCart> productcart : cart.entrySet()) {
            DetailInvoice detail = new DetailInvoice(Invoieid, productcart.getValue().pro.getIdProduct(), productcart.getValue().quantity, productcart.getValue().pro.getPriceNew());
            details.adddetail(detail);
            System.out.println("thành công");
        }
        session.setAttribute("cart",null);
        response.sendRedirect("/checksuccess");
    return;
    }
}