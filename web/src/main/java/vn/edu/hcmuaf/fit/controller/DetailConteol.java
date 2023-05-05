package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Review;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.ProductService;
import vn.edu.hcmuaf.fit.service.ReviewService;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.mail.Store;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "detail", value = "/detail")
public class DetailConteol extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("pid");
        ReviewService rw = new ReviewService();
        StoreService store = new StoreService();
        products p = store.getchitiet(id);

        List<Review> listAllReview = rw.getAllReviewByProductID((id));
        request.setAttribute("listAllReview", listAllReview);
        request.setAttribute("detail",p);
        request.getRequestDispatcher("detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
