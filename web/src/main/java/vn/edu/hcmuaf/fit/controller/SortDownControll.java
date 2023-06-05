package vn.edu.hcmuaf.fit.controller;

import vn.edu.hcmuaf.fit.bean.category;
import vn.edu.hcmuaf.fit.bean.products;
import vn.edu.hcmuaf.fit.service.StoreService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "sortDown", value = "/sortDown")
public class SortDownControll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StoreService pro = new StoreService();
        List<products> list_minmax = pro.mintomax();
        List<category> listC = pro.getListCat();

        request.setAttribute("listCC",listC);
        request.setAttribute("list_minmax",list_minmax);



        request.getRequestDispatcher("store.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
