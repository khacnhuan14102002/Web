package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.service.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Addcart", value = "/addcart")
public class Addcart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String masp= request.getParameter("masp");
//        HttpSession session = request.getSession();
//        User us = (User) session.getAttribute("user");
//        if(us==null){
//            new Cart().addCart(masp);
//            response.sendRedirect("Cart.jsp");
//        }else{
//            response.sendRedirect("login.jsp");
        //}
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
