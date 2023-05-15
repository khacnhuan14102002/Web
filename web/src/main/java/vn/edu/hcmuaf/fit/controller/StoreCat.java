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

@WebServlet(name = "StorebyCat", value = "/category")
public class StoreCat extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cateId = request.getParameter("cid");
        StoreService store = new StoreService();
        List<products> listproid = store.getListProductByCategory(cateId);
        List<category> listC = store.getListCat();
        request.setAttribute("listCC",listC);
        request.setAttribute("listP",listproid);
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
