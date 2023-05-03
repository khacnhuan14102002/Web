package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;
import vn.edu.hcmuaf.fit.service.WishListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addwish", value = "/addwish")
public class AddwishControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("proid"));
        products pro = ProductService.getprobyId(id);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/login");
            return;
        }
        WishListService w =   new WishListService();
        w.adddwish(pro.getIdProduct(),pro.getImage(),pro.getNameProduct(),pro.getPriceNew(),user.getIdUser());

        request.getRequestDispatcher("/wishlist").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
