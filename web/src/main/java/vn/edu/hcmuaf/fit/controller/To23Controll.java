package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "to23", value = "/to23")
public class To23Controll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreService pro = new StoreService();
        List<products> listP = pro.To23();
        List<category> listC = pro.getListCat();

        request.setAttribute("listCC",listC);
        request.setAttribute("listP",listP);



        request.getRequestDispatcher("store.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
