package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.ProductCart;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Addcart", value = "/addcart")
public class Addcart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("proid"));
        products pro = ProductService.getprobyId(id);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            response.sendRedirect("/login");
        }
        ProductCart carts;
        HashMap<Integer,ProductCart> cart = (HashMap<Integer, ProductCart>) session.getAttribute("cart");
        if(cart == null){
            cart = new HashMap<Integer,ProductCart>();
            carts= new ProductCart(1,pro);
            cart.put(id,carts);
        }else{
            if(cart.containsKey(id)){
                carts = cart.get(id);
                carts.incre();
            }else{
                carts = new ProductCart(1,pro);
                cart.put(id,carts);
            }
        }

//        String masp= request.getParameter("masp");
//        HttpSession session = request.getSession();
//        User us = (User) session.getAttribute("user");
//        if(us==null){
//            new Cart().addCart(masp);
//            response.sendRedirect("Cart.jsp");
//        }else{
//            response.sendRedirect("login.jsp");
        //}
        session.setAttribute("cart",cart);
        for(Map.Entry<Integer,ProductCart> entry : cart.entrySet()){
            System.out.println(entry.getValue().pro.getNameProduct() + " : Số lượng" + entry.getValue().quantity);

        }
        response.sendRedirect("/cart");
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
