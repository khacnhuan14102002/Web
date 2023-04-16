package vn.edu.hcmuaf.fit.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import vn.edu.hcmuaf.fit.bean.*;
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
    InvoiceService invoiceSer = new InvoiceService();
    DetailInvoiceService detail = new DetailInvoiceService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       String address = request.getParameter("address");
//        String type = request.getParameter("payment");
//        HttpSession session = request.getSession();
//        ProductCart carts;
//        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
//        double total = 0;
//        for(Map.Entry<Integer,ProductCart> entry : cart.entrySet()){
//            total += entry.getValue().quantity * entry.getValue().pro.getPriceNew();
//        }
//        Date date = new Date();
//        int idinvoice = Integer.parseInt(" " + date.getTime());
//        User user = new User();
//        Invoice invoice = new Invoice(idinvoice,  user,address,type, "0", total, new Timestamp(new Date().getTime()));
//        invoice.setIdIn(idinvoice);
//        invoiceSer.addInvoice(invoice);
//        for(Map.Entry<Integer,ProductCart> procart : cart.entrySet()){
//            products pro = new products();
//            pro.setIdProduct(procart.getValue().pro.getIdProduct());
//            detail.addInvoiceDetail(new DetailInvoice(0,invoice,pro,procart.getValue().quantity));
//        }
//        session.setAttribute("cart",null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
