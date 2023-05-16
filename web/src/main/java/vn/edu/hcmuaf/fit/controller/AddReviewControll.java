package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.Review;
import vn.edu.hcmuaf.fit.bean.User;
import vn.edu.hcmuaf.fit.service.ReviewService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "addReview", value = "/addReview")
public class AddReviewControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String content = request.getParameter("content");
       int score = Integer.parseInt(request.getParameter("score"));
       int productID = Integer.parseInt(request.getParameter("idpro"));

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int idus = user.getIdUser();
        Date date = new Date();
        Review re = new Review(idus,productID,content,new Timestamp(new Date().getTime()),user.getNameUser(),score);
        ReviewService rw= new ReviewService();
        rw.insertReview(re);
  request.getRequestDispatcher("Thank.jsp").forward(request,response);
        return;

    }
}
