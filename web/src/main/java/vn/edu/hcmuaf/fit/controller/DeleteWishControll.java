package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.service.WishListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteWish", value = "/deleteWish")
public class DeleteWishControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productID = Integer.parseInt(request.getParameter("proID"));
        WishListService w = new WishListService();
        w.deleteWishbyIdPro(productID);
        request.getRequestDispatcher("/wishlist").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
