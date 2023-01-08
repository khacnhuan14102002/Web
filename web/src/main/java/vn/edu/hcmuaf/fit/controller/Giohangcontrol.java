package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Giohang;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Spliterator;

@WebServlet(name = "Giohangcontrol", value = "/Giohangcontrol")
public class Giohangcontrol extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Giohang cart= (Giohang) session.getAttribute("cart");
        String msp = request.getParameter("msp");
        String command = request.getParameter("command");
        ArrayList<Long> listBuy =null;
       String url="/Cart.jsp";
        try {
            listBuy= (ArrayList<Long>) session.getAttribute("cartid");
            long idBuy=0;
            if(request.getParameter("cartid") !=null){
                idBuy=Long.parseLong(request.getParameter("cartid"));

            }
            products pr=  ProductService.getchitiet(msp);
            switch (command){
                case"insert":
                    if(listBuy==null){
                        listBuy = new ArrayList<>();
                        session.setAttribute("cartid",listBuy);
                    }
                    if(listBuy.indexOf(idBuy)== -1){
                        cart.insertcart(pr,1);
                        listBuy.add(idBuy);

                        }
                    url= "/Cart.jsp";
                    break;
                default:
                    break;

                    }
                    RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
                    rd.forward(request,response);

        }catch (Exception e){

        }
    }
}
