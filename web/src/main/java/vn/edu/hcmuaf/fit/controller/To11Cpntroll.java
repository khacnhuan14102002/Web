package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.bean.Wishlist;
import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.StoreService;
import vn.edu.hcmuaf.fit.service.WishListService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "to11", value = "/to11")
public class To11Cpntroll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreService pro = new StoreService();
        List<products> list_to11 = pro.To11();
        List<category> listC = pro.getListCat();

        request.setAttribute("listCC",listC);
        request.setAttribute("list_to11",list_to11);
        WishListService service = new WishListService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int sizeW =0;
        if (user != null) {
            ArrayList<Wishlist> list = service.getAllWish(user.getIdUser());
            sizeW = list.size();
        }
        request.setAttribute("sizeW",sizeW);


        request.getRequestDispatcher("store.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
