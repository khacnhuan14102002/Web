package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.ProductCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Cart", value = "/cart")
public class CartControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        HashMap<Integer, ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        int price = 0;
        for (Map.Entry<Integer, ProductCart> entry : cart.entrySet()) {
            Integer key = entry.getKey();
            ProductCart productcart = entry.getValue();
            price += productcart.quantity * productcart.pro.getPriceNew();

        }
        session.setAttribute("total", price);
        request.setAttribute("cart", cart);
        request.getRequestDispatcher("Cart.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
