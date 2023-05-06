package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.bean.Wishlist;
import vn.edu.hcmuaf.fit.service.WishListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "about", value = "/about")
public class AboutControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WishListService service = new WishListService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Wishlist> list =service.getAllWish(user.getIdUser());
        int sizeW= list.size();
        request.setAttribute("sizeW",sizeW);
        request.getRequestDispatcher("About.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
