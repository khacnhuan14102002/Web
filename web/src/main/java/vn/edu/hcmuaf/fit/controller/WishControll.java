package vn.edu.hcmuaf.fit.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import vn.edu.hcmuaf.fit.bean.Invoice;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.bean.Wishlist;
import vn.edu.hcmuaf.fit.service.InvoiceService;
import vn.edu.hcmuaf.fit.service.WishListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "wishlist", value = "/wishlist")
public class WishControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WishListService service = new WishListService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Wishlist> list =service.getAllWish(user.getIdUser());
        request.setAttribute("listW",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/wishlist.jsp");
        requestDispatcher.forward(request,response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
