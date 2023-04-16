package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.ProductCart;
import vn.edu.hcmuaf.fit.bean.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "totalMoneyCart", value = "/totalMoneyCart")
public class TotalMoneyCartControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");

        request.setAttribute("totalPrice", 1000000000);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);
//        double totalMoney = 0;
//        for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
//            Integer key = entry.getKey();
//            ProductCart productcart = entry.getValue();
//        int total= productcart.quantity * productcart.pro.getPriceNew();
//        totalMoney = totalMoney + total;
//            }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
