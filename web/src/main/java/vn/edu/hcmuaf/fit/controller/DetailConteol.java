package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Review;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.bean.Wishlist;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;
import vn.edu.hcmuaf.fit.service.ReviewService;
import vn.edu.hcmuaf.fit.service.StoreService;
import vn.edu.hcmuaf.fit.service.WishListService;

import javax.mail.Store;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "detail", value = "/detail")
public class DetailConteol extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("pid");
        ReviewService rw = new ReviewService();
        StoreService store = new StoreService();
        products p = store.getchitiet(id);
        WishListService service = new WishListService();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<Wishlist> list =service.getAllWish(user.getIdUser());
        int sizeW= list.size();
        List<Review> listAllReview = rw.getAllReviewByProductID((id));
        float  total = 0;
       float avg = 0;
        int countAllReview = listAllReview.size();
        for(Review r : listAllReview){
            total += r.getScore();

        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        avg= Float.parseFloat(decimalFormat.format(total/rw.countAllReview()));

        request.setAttribute("listAllReview", listAllReview);
        request.setAttribute("detail",p);
        request.setAttribute("avg",avg);
        request.setAttribute("countAllReview", countAllReview);
        request.setAttribute("sizeW",sizeW);
        request.getRequestDispatcher("detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
